/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicotricks;

import java.security.MessageDigest;

/**
 *
 * @author Kone
 */
public class Hasher {
    public static String getMD5String(String s) throws Exception {
        MessageDigest hasher = MessageDigest.getInstance("MD5");
        byte[] plaintxt = s.getBytes("UTF-8");
        byte[] hashpass = hasher.digest(plaintxt);
        StringBuilder hexedPass = new StringBuilder();
        for (int i = 0; i < hashpass.length; i++) {
            if (Math.abs(0xFF & hashpass[i]) <= 0xF) {
                hexedPass.append("0");
            }
            hexedPass.append(Integer.toHexString(0xFF & hashpass[i]));
        }
        return hexedPass.toString();
    }
}
