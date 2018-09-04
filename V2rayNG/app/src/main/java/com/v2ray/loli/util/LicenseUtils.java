package com.v2ray.loli.util;

import android.util.Log;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LicenseUtils {
    public static String licenseDecode(String source, String key) {
        String keySha1 = sha1(key);
        long strLenth = source.length();
        long keyLenth = keySha1.length();
        int i = 0;
        int j = 0;
        String hash = "";
        while (i < strLenth) {
            String sub = source.substring(i, i + 2);
            String revStr = new StringBuilder(sub).reverse().toString();
            //Log.d("license", "revStr is " + revStr);
            String convert = new BigInteger(revStr, 36).toString(16);
            int ordStr = Integer.valueOf(convert, 16);
            if (j == keyLenth) {
                j = 0;
            }

            int ordKey = ord(keySha1.substring(j, j + 1));
            j++;
            hash = hash + (char) (ordStr - ordKey);
            i += 2;
        }
        return hash;
    }

    public static int ord(String s) {
        return s.length() > 0 ? (s.getBytes(StandardCharsets.UTF_8)[0] & 0xff) : 0;
    }

    private static String byteArrayToHexString(byte[] b) {
        String result = "";
        for (int i=0; i < b.length; i++) {
            result +=
                    Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }

    private static String sha1(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        }
        catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return byteArrayToHexString(md.digest(str.getBytes()));
    }
}
