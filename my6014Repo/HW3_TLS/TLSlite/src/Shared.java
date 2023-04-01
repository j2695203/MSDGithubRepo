import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;

public class Shared {

    static Certificate getCertificate(String filename) throws CertificateException, FileNotFoundException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        InputStream certificateInputStream = new FileInputStream(filename);
        return certificateFactory.generateCertificate(certificateInputStream);
    }
    static BigInteger getDHpublicKey(BigInteger DH_priv){
        BigInteger DH_g = new BigInteger("2");
        BigInteger DH_N = new BigInteger(
                "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD1" +
                        "29024E088A67CC74020BBEA63B139B22514A08798E3404DD" +
                        "EF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245" +
                        "E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7ED" +
                        "EE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3D" +
                        "C2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F" +
                        "83655D23DCA3AD961C62F356208552BB9ED529077096966D" +
                        "670C354E4ABC9804F1746C08CA18217C32905E462E36CE3B" +
                        "E39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9" +
                        "DE2BCBF6955817183995497CEA956AE515D2261898FA0510" +
                        "15728E5A8AACAA68FFFFFFFFFFFFFFFF",16);
        return DH_g.modPow(DH_priv,DH_N);
    }

    static BigInteger getDHshareKey(BigInteger DH_pubA, BigInteger DH_privB){
        BigInteger DH_N = new BigInteger(
                "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD1" +
                        "29024E088A67CC74020BBEA63B139B22514A08798E3404DD" +
                        "EF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245" +
                        "E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7ED" +
                        "EE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3D" +
                        "C2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F" +
                        "83655D23DCA3AD961C62F356208552BB9ED529077096966D" +
                        "670C354E4ABC9804F1746C08CA18217C32905E462E36CE3B" +
                        "E39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9" +
                        "DE2BCBF6955817183995497CEA956AE515D2261898FA0510" +
                        "15728E5A8AACAA68FFFFFFFFFFFFFFFF",16);
        return DH_pubA.modPow(DH_privB,DH_N);
    }

    static PrivateKey getRSAprivetKey(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        InputStream privateKeyInputStream = new FileInputStream(filename);
        byte[] privateKeyBytes = privateKeyInputStream.readAllBytes();
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
    }

    static byte[] getSignature(PrivateKey privateKey, BigInteger DHpublicKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initSign(privateKey);
        signature.update(DHpublicKey.toByteArray()); // data
        return signature.sign();
    }

    static byte[] hkdfExpand(byte[] input, String tag) throws NoSuchAlgorithmException, InvalidKeyException {
        // mac initialize
        Mac mac = Mac.getInstance("HmacSHA256");
        String algorithm  = "RawBytes";
        SecretKeySpec key = new SecretKeySpec(input, algorithm);
        mac.init(key);
        //  data = tag concatenated with a byte with value 1
        mac.update(tag.getBytes());
        mac.update((byte) 1);
        //	return first 16 bytes of output key material
        byte[] macBytes = mac.doFinal();;
        byte[] ret = new byte[16];
        System.arraycopy(macBytes,0,ret,0,16);
        return ret;
    }

    static byte[] getHMAC_makeKeys(byte[] input, String tag) throws NoSuchAlgorithmException, InvalidKeyException {
        // mac initialize
        Mac mac = Mac.getInstance("HmacSHA256");
        String algorithm  = "RawBytes";
        SecretKeySpec key = new SecretKeySpec(input, algorithm);
        mac.init(key);
        return mac.doFinal(tag.getBytes());
    }

    static byte[] getHMAC_handshakeMAC(byte[] input, ArrayList<byte[]> msg) throws NoSuchAlgorithmException, InvalidKeyException {
        // mac initialize
        Mac mac = Mac.getInstance("HmacSHA256");
        String algorithm  = "RawBytes";
        SecretKeySpec key = new SecretKeySpec(input, algorithm);
        mac.init(key);
        for(byte[] el: msg){
            mac.update(el);
        }
        return mac.doFinal();
    }

    static byte[] getHMAC_msg(byte[] input, byte[] msg) throws NoSuchAlgorithmException, InvalidKeyException {
        // mac initialize
        Mac mac = Mac.getInstance("HmacSHA256");
        String algorithm  = "HmacSHA256";
        SecretKeySpec key = new SecretKeySpec(input, algorithm);
        mac.init(key);
        return mac.doFinal(msg);
    }


    static void verifySignature(Certificate CA, Certificate certificate, BigInteger DH_pub, byte[] digitalSignature) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, CertificateException, NoSuchProviderException {
        // verify server certificate first
        certificate.verify(CA.getPublicKey());

        Signature signature_verify = Signature.getInstance("SHA256WithRSA");
        signature_verify.initVerify(certificate.getPublicKey());
        signature_verify.update(DH_pub.toByteArray());
        boolean verified = signature_verify.verify(digitalSignature);
        if(!verified){
            throw new SignatureException("server signature verified fail");
        }
    }

    static byte[] encryptPlainText(String msg, byte[] encryptSrc, byte[] ivSrc, byte[] macSrc) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // 7-1. create and initialize a cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(encryptSrc, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivSrc);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        // 7-2. encrypt message and HMAC
        byte[] plainText = msg.getBytes();
        byte[] plainText_HMAC = Shared.getHMAC_msg(macSrc, plainText);
        byte[] plainText_send = new byte[plainText.length + plainText_HMAC.length];
        System.arraycopy(plainText,0,plainText_send,0,plainText.length);
        System.arraycopy(plainText_HMAC, 0, plainText_send,plainText.length,plainText_HMAC.length);
        return cipher.doFinal(plainText_send);
    }

    static byte[] decryptCipherText(byte[] cipherText, byte[] encryptSrc, byte[] ivSrc, byte[] macSrc) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // 8-1. create and initialize a cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(encryptSrc, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivSrc);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        // 8-2. decrypt message
        return cipher.doFinal(cipherText);
    }

    static byte[] getMsgPartFromPlainText(byte[] plainText){
        byte[] plainText_msg = new byte[plainText.length-32];
        System.arraycopy(plainText,0,plainText_msg,0,plainText.length-32);
        return plainText_msg;
    }

    static byte[] getHMACPartFromPlainText(byte[] plainText){
        byte[] plainText_HMAC = new byte[32];
        System.arraycopy(plainText,plainText.length-32,plainText_HMAC,0,32);
        return plainText_HMAC;
    }

    static void verifyHMAC(byte[] macSrc, byte[] msg, byte[] HMAC_decrypt) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] HMAC_verify = Shared.getHMAC_msg(macSrc, msg);
        if(!Arrays.toString(HMAC_verify).equals(Arrays.toString(HMAC_decrypt))){
            throw new RuntimeException("HMAC verified fail");
        }
    }
}
