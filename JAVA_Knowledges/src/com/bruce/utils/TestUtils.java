package com.bruce.utils;

/**
 * Created by qizhenghao on 15-9-15.
 */
public class TestUtils {

    public static void main(String[] args) {

//        long testMils1 = 19*60*60*1000 + 30*60*1000;
//        long testMils2 = 19*60*60*1000;
//        System.out.println(TimeUtils.isSameDayOfMillis(System.currentTimeMillis()-100000, System.currentTimeMillis()));
//        System.out.println(TimeUtils.isSameDayOfMillis(System.currentTimeMillis()-1000000, System.currentTimeMillis()));
//        System.out.println(TimeUtils.isSameDayOfMillis(System.currentTimeMillis()-10000000, System.currentTimeMillis()));
//        System.out.println(TimeUtils.isSameDayOfMillis(System.currentTimeMillis()-testMils1, System.currentTimeMillis()));
//        System.out.println(TimeUtils.isSameDayOfMillis(System.currentTimeMillis()-testMils2, System.currentTimeMillis()));
//
//        long testMils3 = 3*60*60*1000 + 59*60*1000;
//        long testMils4 = 19*60*60*1000;
//        System.out.println(TimeUtils.isMoreThanHours(System.currentTimeMillis()-testMils3, System.currentTimeMillis(), 4));
//        System.out.println(TimeUtils.isMoreThanMinutes(System.currentTimeMillis()-61*1000, System.currentTimeMillis(), 1));
//        System.out.println(TimeUtils.isMoreThanMinutes(System.currentTimeMillis()-59*1000, System.currentTimeMillis(), 1));

        financing(10000, 30, 1, 0.015f); //存银行一万元，按照定期一年利率1.5%存储，复利30年后  = 15631
        financing(10000, 30, 3, 0.0275f);//存银行一万元，按照定期三年利率2.75%存储，复利30年后 = 22094
        financing(10000, 30, 5, 0.03f);  //存银行一万元，按照定期五年利率3.0%存储，复利30年后  = 23130
        financing(10000, 30, 1, 0.1f);   //存P2P一万元，按照定期一年利率10.0%存储，复利30年后 = 17万
        financing(10000, 30, 1, 0.12f);  //存P2P一万元，按照定期一年利率12.0%存储，复利30年后 = 30万
        financing(10000, 30, 1, 0.203f); //自理财一万元，按照定期一年利率20.3%存储，复利30年后 = 256万
        financing(10000, 30, 1, 0.25f);  //自理财一万元，按照定期一年利率25.0%存储，复利30年后 = 808万
        financing(10000, 30, 1, 0.30f);  //自理财一万元，按照定期一年利率30.0%存储，复利30年后 = 2620万
        financing(1000000, 40, 1, 0.30f);  // = 361亿，这是巴菲特级别的人
    }

    public static void financing(double corpus, int year, int cycle, float rate) {
        int loop = year/cycle;
        for (int i=0;i<loop;i++) {
            corpus = corpus*(1 + rate*cycle);
        }
        System.out.println(corpus);
    }
}
