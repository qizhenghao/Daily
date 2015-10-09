package com.bruce.utils;

import java.util.TimeZone;

/**
 * Created by qizhenghao on 15-9-15.
 */
public class TimeUtils {

    public static final int SECONDS_IN_DAY = 60 * 60 * 24;
    public static final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;

    /***
     * 判断是否为同一天
     * @param ms1
     * @param ms2
     * @return
     */
    public static boolean isSameDayOfMillis(final long ms1, final long ms2) {
        final long interval = ms1 - ms2;
        return interval < MILLIS_IN_DAY
                && interval > -1L * MILLIS_IN_DAY
                && toDay(ms1) == toDay(ms2);
    }

    private static long toDay(long millis) {
        return (millis + TimeZone.getDefault().getOffset(millis)) / MILLIS_IN_DAY;
    }

    /**
     * 间隔时间大于n小时
     */
    public static boolean isMoreThanHours(final long ms1, final long ms2, int nHour) {
        return nHour-1<Math.abs((ms1 - ms2)/(1*60*60*1000));
    }

    /**
     * 间隔时间大于n分钟
     */
    public static boolean isMoreThanMinutes(final long ms1, final long ms2, int nMinute) {
        return nMinute-1<Math.abs((ms1 - ms2)/(1*60*1000));
    }
}
