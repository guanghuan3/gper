package com.guanghuan3.homework.myspringframework.utils;

import org.springframework.util.StringUtils;

/**
 * Created by Administrator
 * on 2019/4/20.
 */
public class MyStringUtils {

    /**
     * 首字母小写
     *  将string的第一个字符转换成char然后增加32，则得到英文字符的大写转小些
     * @param source
     * @return
     */
    public static String toFirstLowerCase(String source) {
        // 65-90为英文字母大写区间，不在此区间的字符串不作处理
        if (isEmpty(source)
                || source.toCharArray()[0] < 65
                || source.toCharArray()[0] > 90) {
            return source;
        }

        char[] chars = source.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    /**
     * 首字母大写
     *  将string的第一个字符转换成char然后增加32，则得到英文字符的大写转小些
     * @param source
     * @return
     */
    public static String toFirstUpperCase(String source) {
        // 65-90为英文字母大写区间，不在此区间的字符串不作处理
        if (isEmpty(source)
                || source.toCharArray()[0] < 97
                || source.toCharArray()[0] > 122) {
            return source;
        }

        char[] chars = source.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    public static boolean isNotEmpty(String str) {
        return !StringUtils.isEmpty(str);
    }

    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }
}
