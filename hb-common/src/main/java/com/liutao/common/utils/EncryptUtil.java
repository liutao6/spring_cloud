package com.liutao.common.utils;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * User: Liu Tao
 * Date: 2017/8/10
 * Time: 下午4:40
 */
@Slf4j
public class EncryptUtil {

    private static final MessageDigest md;
    private static final BASE64Encoder b64Encoder;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
            b64Encoder = new BASE64Encoder();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * md5加密
     *
     * @param pwd        密码
     * @param saltSource 密码盐
     * @return
     */
    public static String md5(String pwd, String saltSource) {
        StringBuffer md5 = new StringBuffer();
        try {
            byte[] salt = saltSource.getBytes();
            md.reset();
            md.update(salt);
            md.update(pwd.getBytes("UTF-8"));
            byte[] bys = md.digest();
            md5.append((char) salt[0]);
            md5.append((char) salt[1]);
            md5.append(b64Encoder.encode(bys));
        } catch (UnsupportedEncodingException e) {
            log.error("加密失败", e);
        }
        return md5.toString();
    }
}
