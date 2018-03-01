package com.wugeek.auth.service.utils;

import java.security.MessageDigest;

/**
 * Created by 郭世雄 on 2016/12/30.
 */
public class MD5Utils {

    public static String string2MD5(String string) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = string.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            char[] MD5String = new char[md.length * 2];
            int k = 0;
            for (byte byte0 : md) {
                MD5String[k++] = hexDigits[byte0 >>> 4 & 0xf];
                MD5String[k++] = hexDigits[byte0 & 0xf];
            }
            return String.valueOf(MD5String);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
