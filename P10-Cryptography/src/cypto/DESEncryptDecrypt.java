package cypto;

import java.io.UnsupportedEncodingException;
import java.security.*;
import  javax.crypto.*;

/**
 *
 * @author Khevita
 */

public class DESEncryptDecrypt {
    public static void doEncryptDecrypt() {
        try {
            String data = "Dasar Symmetric Cryptograpy";
            byte[] plain = data.getBytes("UTF8");
            //membuat DES private key
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            keyGen.init(56);
            Key key = keyGen.generateKey();
            //membuat DES cipher => print ke provider
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            byte[] cipherText = cipher.doFinal(plain);
            //proses decrypt
            Cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] originText = cipher.doFinal(cipherText);
            System.out.println("Plain Text: "+data);
            System.out.println("Enkripsi: "+new String(cipherText, "UTF8"));
            System.out.println("Enkripsi Heksa: "+MyStringUtils.getHexString(cipherText));
             System.out.println("Dekripsi: "+new String(originText, "UTF8"));
        } catch (UnsupportedEncodingException | BadPaddingException |
                NoSuchAlgorithmException | BadPaddingException |
                IllegalBlockSizeException | NoSuchPaddingException e) {
            
        }
    }
    
    public static void main(String[] args) {
        doEncryptDecrypt();
    }
}
