package com.zzw.componentbase.utils;

import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 创建人: xieyushang
 * 时间: 2017-12-20 14:58
 */

public class PasswordUtils {
    /**
     * 密码加密
     * @param username 用户
     * @param password 密码
     * @return
     */
    public static String getSha1(String username, String password){
        if(TextUtils.isEmpty(username)){
            return null;
        }else if(TextUtils.isEmpty(password)){
            return null;
        }
        String str = password+username;
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for(int i =0;i<j;i++){
                byte byteO = md[i];
                buf[k++] = hexDigits[byteO >>> 4 & 0xf];
                buf[k++] = hexDigits[byteO & 0xf];
            }
            return new String(buf);
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
