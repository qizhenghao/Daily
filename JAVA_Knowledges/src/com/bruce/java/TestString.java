package com.bruce.java;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by qizhenghao on 17/4/13.
 */
public class TestString {

    private final String ss;
    static String main = "www.renren.com/SysHome.do?";// 线上正式环境用
    static String main1 = "www.renren.com/SysHome.do?";// 线上正式环境用

    public TestString() {
        ss = "";
    }

    public static void main(String[] args) throws IllegalAccessException {

        String override = "http://www.renren.com/SysHome.do?";
        String origin = "http://宝箱";

        System.out.println(isOverride2Login(override, origin));

//        //测试反射修改字符串的char数组
//        String s1 = "1", s2 = "2";
//        HashMap map = new HashMap(2);
//        map.put(s1, 1);
//        map.put(s2, 2);
//
//        for (Field field: s1.getClass().getDeclaredFields()) {
//            field.setAccessible(true);
//            if (field.getName().equals("value")) {
//                field.set(s1, new char[]{'2'});
//            } else if (field.getName().equals("hash")) {
//                field.set(s1, 0);
//            }
//        }
//
//        for (Object key : map.keySet()) {
//            System.out.println(key + " : " + map.get(key));
//        }
    }

    private static boolean isOverride2Login(String overrideUrl, String originUrl) {
        String splitKey = "://";
        overrideUrl = overrideUrl.substring(overrideUrl.indexOf(splitKey) + splitKey.length(), overrideUrl.length());
        originUrl = originUrl.substring(originUrl.indexOf(splitKey) + splitKey.length(), originUrl.length());
        return (overrideUrl.startsWith(main) || overrideUrl.startsWith(main1)) && !originUrl.startsWith(main);
    }
}
