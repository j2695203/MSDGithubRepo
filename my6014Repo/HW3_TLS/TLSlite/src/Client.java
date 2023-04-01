import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    // session keys
    byte[] serverEncrypt;
    byte[] clientEncrypt;
    byte[] serverMAC;
    byte[] clientMAC;
    byte[] serverIV;
    byte[] clientIV;

    ArrayList<byte[]> messages = new ArrayList<>();

    public Client() throws CertificateException, IOException, NoSuchAlgorithmException, SignatureException, InvalidKeySpecException, InvalidKeyException, ClassNotFoundException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchProviderException {
        // create client socket
        Socket clientSocket = new Socket("localhost",8080);

        handshake_msg_client(clientSocket);
    }

    private void handshake_msg_client(Socket clientSocket) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, CertificateException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchProviderException {
    // 1. (C->S) Nonce1 (32 bytes from a SecureRandom object)
        BigInteger nonce_c = new BigInteger(256, new SecureRandom());
        // send
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        objectOutputStream.writeObject(nonce_c);
        messages.add(nonce_c.toByteArray());


    // 3. (C->S) Client Certificate, DiffieHellman public key, Signed DiffieHellman public key (Sign[g^kc % N, Cpriv])
        // 3-0. receive certificate, DH_pub, signature from client
        ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
        Certificate certificate_s = (Certificate) objectInputStream.readObject();
        BigInteger DH_pub_s = (BigInteger) objectInputStream.readObject();
        byte[] digitalSignature_s = (byte[]) objectInputStream.readObject();
        messages.add(certificate_s.getEncoded());
        messages.add(DH_pub_s.toByteArray());
        messages.add(digitalSignature_s);

        // 3-0-1. verify the server
        Certificate CAcertificate = Shared.getCertificate("CAcertificate.pem");
        Shared.verifySignature(CAcertificate, certificate_s,DH_pub_s,digitalSignature_s);
//
//        // 3-0-2. verify the server
//        Shared.verifySignature(certificate_s,DH_pub_s,digitalSignature_s);

        // 3-1. get client certificate
        Certificate certificate_c = Shared.getCertificate("CASignedClientCertificate.pem");

        // 3-2. get DiffieHellman public key
        BigInteger DH_priv_c = new BigInteger(256, new SecureRandom()); // custom
        BigInteger DH_pub_c = Shared.getDHpublicKey(DH_priv_c);

        // 3-3. Signed DiffieHellman public key ( Sign[g^kc % N, Cpriv] ) using RSA private key
        PrivateKey RSA_priv_c = Shared.getRSAprivetKey("clientPrivateKey.der");
        byte[] digitalSignature_c = Shared.getSignature(RSA_priv_c, DH_pub_c);

        // 3-4. Send to server
        objectOutputStream.writeObject(certificate_c);
        objectOutputStream.writeObject(DH_pub_c);
        objectOutputStream.writeObject(digitalSignature_c);
        messages.add(certificate_c.getEncoded());
        messages.add(DH_pub_c.toByteArray());
        messages.add(digitalSignature_c);


        // 3-5. COMPUTE DH SHARED SECRET KEY
        BigInteger DH_shared = Shared.getDHshareKey(DH_pub_s,DH_priv_c);

        // 3-6. derive 6 session keys from the shared secret
        makeSecretKeys(nonce_c,DH_shared);

        // 5. (C->S) MAC(all handshake messages so far including the previous step, Client's MAC key).
        // 5-1. verify MAC message
        byte[] mac_msg_s = (byte[]) objectInputStream.readObject();
        byte[] mac_msg_verify = Shared.getHMAC_handshakeMAC(serverMAC, messages);
        if(!Arrays.equals(mac_msg_s, mac_msg_verify)) {
            throw new RuntimeException("MAC verify failed");
        }
        messages.add(mac_msg_s);
        // 5-2 send MAC to server
        byte[] mac_msg_c = Shared.getHMAC_handshakeMAC(clientMAC, messages);
        objectOutputStream.writeObject(mac_msg_c);
        messages.add(mac_msg_c);

        ///////////////////////
        // 8. Decrypt message from server
        byte[] cipherText_rcv = (byte[]) objectInputStream.readObject();
        // 8-2. decrypt message
        byte[] plainText = Shared.decryptCipherText(cipherText_rcv,serverEncrypt,serverIV,serverMAC);
        byte[] plainText_msg = Shared.getMsgPartFromPlainText(plainText);
        byte[] plainText_HMAC = Shared.getHMACPartFromPlainText(plainText);
        // 8-3. check message and verify HMAC
        System.out.println("PlainText(Receive): " + new String (Shared.getMsgPartFromPlainText(plainText) ) + "\n");
        Shared.verifyHMAC(serverMAC,plainText_msg,plainText_HMAC);

        // 9. Send Confirm Message back to server
        String msg = "Message received by client.";
        byte[] cipherText_snd = Shared.encryptPlainText(msg, clientEncrypt, clientIV, clientMAC);
        objectOutputStream.writeObject(cipherText_snd);
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


    public static void main(String[] args) throws IOException, ClassNotFoundException, CertificateException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchProviderException {
        Client client = new Client();
    }

}
