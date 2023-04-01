import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;

public class Server {
    // session keys
    byte[] serverEncrypt;
    byte[] clientEncrypt;
    byte[] serverMAC;
    byte[] clientMAC;
    byte[] serverIV;
    byte[] clientIV;

    ArrayList<byte[]> messages = new ArrayList<>(); // record handshake message

    public Server() throws IOException, CertificateException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException, ClassNotFoundException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchProviderException {
        // open a socket, listen for connections
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket clientSocket = serverSocket.accept();
        // handshake and all the message
        handshake_msg_server(clientSocket);
    }


    private void handshake_msg_server(Socket clientSocket) throws IOException, ClassNotFoundException, CertificateException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchProviderException {

    // 2. (S->C) Server Certificate, DiffieHellman public key, Signed DiffieHellman public key (Sign[g^ks % N, Spriv])
        // 2-0. receive nonce from client
        ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
        BigInteger nonce_c = (BigInteger) objectInputStream.readObject();
        messages.add(nonce_c.toByteArray());

        // 2-1. get server certificate
        Certificate certificate_s = Shared.getCertificate("CASignedServerCertificate.pem");

        // 2-2. get DiffieHellman public key
        BigInteger DH_priv_s = new BigInteger(256, new SecureRandom()); // custom
        BigInteger DH_pub_s = Shared.getDHpublicKey(DH_priv_s);

        // 2-3. Signed DiffieHellman public key ( Sign[g^ks % N, Spriv] ) using RSA private key
        PrivateKey RSA_priv_s = Shared.getRSAprivetKey("serverPrivateKey.der");
        byte[] digitalSignature_s = Shared.getSignature(RSA_priv_s, DH_pub_s);

        // 2-4. Send to client
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        objectOutputStream.writeObject(certificate_s);
        objectOutputStream.writeObject(DH_pub_s);
        objectOutputStream.writeObject(digitalSignature_s);
        // record all the handshake message
        messages.add(certificate_s.getEncoded());
        messages.add(DH_pub_s.toByteArray());
        messages.add(digitalSignature_s);


        // 2-5. receive handshake step 3 from client
        Certificate certificate_c = (Certificate) objectInputStream.readObject();
        BigInteger DH_pub_c = (BigInteger) objectInputStream.readObject();
        byte[] digitalSignature_c = (byte[]) objectInputStream.readObject();
        messages.add(certificate_c.getEncoded());
        messages.add(DH_pub_c.toByteArray());
        messages.add(digitalSignature_c);

        // 2-6. verify the client
        Certificate CAcertificate = Shared.getCertificate("CAcertificate.pem");
        Shared.verifySignature(CAcertificate, certificate_c,DH_pub_c,digitalSignature_c);

        // 2-6. COMPUTE DH SHARED SECRET KEY
        BigInteger DH_shared = Shared.getDHshareKey(DH_pub_c,DH_priv_s);

        // 2-7. derive 6 session keys from the shared secret
        makeSecretKeys(nonce_c,DH_shared);

        // 4. (S->C) MAC (Server's MAC key, all handshake messages so far)
        byte[] mac_msg_s = Shared.getHMAC_handshakeMAC(serverMAC,messages);
        objectOutputStream.writeObject(mac_msg_s);
        messages.add(mac_msg_s);

        // 6. verify MAC message
        byte[] mac_msg_c = (byte[]) objectInputStream.readObject();
        byte[] mac_msg_verify = Shared.getHMAC_handshakeMAC(clientMAC, messages);
        if(!Arrays.equals(mac_msg_c, mac_msg_verify)) {
            throw new RuntimeException("MAC verify failed");
        }
        messages.add(mac_msg_c);

        ///////////////////////////////////
        // 7. start sending message to client
        String msg = "This is a message from server.";
        byte[] cipherText = Shared.encryptPlainText(msg, serverEncrypt, serverIV, serverMAC);
        objectOutputStream.writeObject(cipherText);

        // 10. Decrypt message from client
        byte[] cipherText_rcv = (byte[]) objectInputStream.readObject();
        // 8-2. decrypt message
        byte[] plainText = Shared.decryptCipherText(cipherText_rcv,clientEncrypt,clientIV,clientMAC);
        byte[] plainText_msg = Shared.getMsgPartFromPlainText(plainText);
        byte[] plainText_HMAC = Shared.getHMACPartFromPlainText(plainText);
        // 8-3. check message and verify HMAC
        System.out.println("PlainText(Receive): " + new String (Shared.getMsgPartFromPlainText(plainText) ) + "\n");
        Shared.verifyHMAC(clientMAC,plainText_msg,plainText_HMAC);

    }

    private void makeSecretKeys(BigInteger nonce_c, BigInteger DH_share) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] prk = Shared.getHMAC_makeKeys(nonce_c.toByteArray(), String.valueOf(DH_share));
        serverEncrypt = Shared.hkdfExpand(prk, "server encrypt");
        clientEncrypt = Shared.hkdfExpand(serverEncrypt, "client encrypt");
        serverMAC = Shared.hkdfExpand(clientEncrypt, "server MAC");
        clientMAC = Shared.hkdfExpand(serverMAC, "client MAC");
        serverIV = Shared.hkdfExpand(clientMAC, "server IV");
        clientIV = Shared.hkdfExpand(serverIV, "client IV");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, SignatureException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchProviderException {
        Server server = new Server();
    }

}
