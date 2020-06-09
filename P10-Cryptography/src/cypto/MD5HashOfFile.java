package cypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Khevita
 */

public class MD5HashOfFile {
    private static String file;
    public static String hashFile(String[] args) {
        String hased = "";
        try {
            MessageDigest md = MessageDigest.getInstance("Md5");
            FileInputStream fis = new FileInputStream(file);
            byte[] byteData = new byte[1024];
            int nRead;
            while ((nRead = fis.read(byteData)) != -1) {
                md.update(byteData, 0, nRead); 
            }
            byte[] mdBytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mdBytes.length; i++) {
                sb.append(Integer.toString((mdBytes[i] & 0xff) + 0x100,16).substring(1));  
            }
            hased = sb.toString();
        } catch (IOException | NoSuchAlgorithmException e) {
        }
        return hased;
    }
    
    public static void main(String[] args) {
        String file = System.getProperty("user.dir") + File.separator + "manifest.mf";
        System.out.println("File\t\t: "+file);
        System.out.println("MD5 checksum\t: "+hashFile(file));
    }

}
