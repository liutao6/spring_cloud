package com.liutao.common.utils;

import java.util.Random;

/**
 * User: Liu Tao
 * Date: 2017/8/10
 * Time: 下午4:52
 */
public class RandomUtil {

    /**
     * 获取随机字符串
     *
     * @param length 长度
     * @return
     */
    public static String getRandomSalt(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
