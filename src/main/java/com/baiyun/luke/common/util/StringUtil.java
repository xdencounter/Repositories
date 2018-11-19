package com.baiyun.common.util;

import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public StringUtil() {
        // TODO Auto-generated constructor stub
    }

    // base64转成原字符串
    public static String base64Decoder(String text) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        String string = new String(decoder.decodeBuffer(text));
        return string;
    }

    // 转成哈希
    public static String toHexString(String src) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0, len = src.length(); i < len; i++) {
            int ch = (int) src.charAt(i);
            sb.append(Integer.toHexString(ch).toUpperCase());
        }
        return sb.toString();
    }


    /**
     * 下划线转驼峰
     *
     * @param str
     * @return
     */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = Pattern.compile("_(\\w)").matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 驼峰转大写字母和下划线
     *
     * @param param
     * @return
     */
    public static String humpToLine(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append("_");
            }
            sb.append(Character.toUpperCase(c));
        }
        return sb.toString();
    }

    /**
     * 首字母转小写
     *
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        char[] cs = s.toCharArray();
        cs[0] += 32;
        return String.valueOf(cs);
    }


    /**
     * 首字母转大写
     *
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s) {
        char[] cs = s.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    /**
     * 比较两个字符串是否相等，null和“”等同
     *
     * @param strA String
     * @param strB String
     * @return boolean (true:相等 false:不相等)
     */
    public static boolean equals(String strA, String strB) {
        if (strA == null || strA.length() == 0) {
            if (strB == null || strB.length() == 0) {
                return true;
            }
            return false;
        }

        return strA.equals(strB);
    }

    /**
     * 判断字符串是否为null或是长度为0
     *
     * @param str String 字符串
     * @return boolean (true:是 false:否)
     */
    public static boolean isEmpty(String str) {
        return Boolean.valueOf(str == null || str.length() == 0);
    }

    /**
     * 判断字符串是否为非null或是长度不为0
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        return str.matches("[\\d]+[.]?[\\d]+");
    }


}
