package com.bruce.android.knowledges.costomviews.scanAnimation;

import android.util.Log;

/**
 * @author zhenghao.qi
 * @version 1.0
 * @time 2015年11月09日14:45:32
 */
public class ScanAnimaitonStrategy implements IAnimationStrategy {
    /**
     * 起始X坐标
     */
    private int startX;
    /**
     * 起始Y坐标
     */
    private int startY;
    /**
     * 起始点到终点的Y轴位移。
     */
    private int shift;
    /**
     * X Y坐标。
     */
    private double currentX, currentY;
    /**
     * 动画开始时间。
     */
    private long startTime;
    /**
     * 循环时间
     */
    private long cyclePeriod;
    /**
     * 动画正在进行时值为true，反之为false。
     */
    private boolean doing;

    public void start() {
        startTime = System.currentTimeMillis();
        doing = true;
    }

    /**
     * 设置起始位置坐标
     */
    public void setParams(int x, int y, int shift, long cyclePeriod) {
        this.startX = x;
        this.startY = y;
        this.shift = shift;
        this.cyclePeriod = cyclePeriod;
        Log.d("Brure1", "cyclePeriod = " + cyclePeriod);
    }

    /**
     * 根据当前时间计算小球的X/Y坐标。
     */
    public void compute() {
        long intervalTime = (System.currentTimeMillis() - startTime) % cyclePeriod;
        double angle = Math.toRadians(360 * 1.0d * intervalTime / cyclePeriod);
        int y = (int) (shift / 2 * Math.cos(angle));
        y = Math.abs(y - shift/2);
        currentY = startY + y;
        doing = true;
    }

    @Override
    public void setParams() {

    }

    @Override
    public boolean doing() {
        return doing;
    }

    public double getX() {
        return currentX;
    }

    public double getY() {
        return currentY;
    }


    public void cancel() {
        doing = false;
    }
}