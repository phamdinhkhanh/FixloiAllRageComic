package com.raywenderlich.alltherages.utils;

import android.util.Log;

/**
 * Created by laptopTCC on 6/4/2017.
 */

public class Utils {
    private static String TAG = "Utils";

    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {

        }
        return null;
    }

    public static String getCodeRegister(String id) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id).append("*&/asd].``~");
        Log.e(TAG, String.format("getCodeRegister: %s", stringBuilder.toString()));
        return MD5(stringBuilder.toString());
    }
}
