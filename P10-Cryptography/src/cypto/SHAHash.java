package cypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static java.util.Objects.hash;

/**
 *
 * @author Khevita
 */

public class SHAHash {
    public static void main(String data, String alogrithm) {
        String hashed;
        try {
            MessageDigest sha = MessageDigest.getInstance(algorithm);
            byte[] byteData = sha.digest();
            //konversi dari byte ke hex
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1)); 
            }
            hashed = sb.toString();
        } catch (NoSuchAlgorithmException e) {
        }
        return hashed;
    }
    
    public static void main(String[] args) {
        String data ="Selamat datang di Politeknik Harapan Bersama Tegal";
        System.out.println("SHA-1\t: "+data);
        System.out.println("SHA-1\t: "+hash(data, "SHA-1"));
        System.out.println("SHA-1\t: "+hash(data, "SHA-256"));
        System.out.println("SHA-1\t: "+hash(data, "SHA-512"));
    }

   
}
