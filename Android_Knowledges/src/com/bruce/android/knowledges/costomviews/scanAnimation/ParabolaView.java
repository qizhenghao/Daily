package com.bruce.android.knowledges.costomviews.scanAnimation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @author Sodino E-mail:sodinoopen@hotmail.com
 * @version Time：2012-6-18 上午02:52:33
 */
public class ParabolaView extends SurfaceView implements SurfaceHolder.Callback {
        /** 每30ms刷一帧。 */
        private static final long SLEEP_DURATION = 10l;
        private SurfaceHolder holder;
        /** 动画图标。 */
        private Bitmap bitmap;
        private DrawThread thread;
        private PhysicalTool physicalTool;
        private ParabolaView.ParabolaListener listener;
        /** 默认未创建，相当于Destory。 */
        private boolean surfaceDestoryed = true;

        public ParabolaView(Context context, AttributeSet attrs, int defStyle) {
                super(context, attrs, defStyle);
                init();
        }

        public ParabolaView(Context context, AttributeSet attrs) {
                super(context, attrs);
                init();
        }

        public ParabolaView(Context context) {
                super(context);
                init();
        }

        private void init() {
                holder = getHolder();
                holder.addCallback(this);
                holder.setFormat(PixelFormat.TRANSPARENT);

                setZOrderOnTop(true);
                // setZOrderOnTop(false);

                physicalTool = new PhysicalTool();
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
                surfaceDestoryed = false;
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            Log.d("Bruce1", "surfaceDestroyed");
                surfaceDestoryed = true;
                physicalTool.cancel();
        }

        public void handleThread() {
                Canvas canvas = null;

                Paint pTmp = new Paint();
                pTmp.setAntiAlias(true);
                pTmp.setColor(Color.RED);

                Paint paint = new Paint();
                // 设置抗锯齿
                paint.setAntiAlias(true);
                paint.setColor(Color.CYAN);
                physicalTool.start();
            Log.d("Bruce1", "doing:" + physicalTool.doing());
                if (listener != null) {
                        listener.onParabolaStart(this);
                }
                while (physicalTool.doing()) {
                        try {
                                physicalTool.compute();
                                canvas = holder.lockCanvas();
                                // 设置画布的背景为透明。
                                canvas.drawColor(Color.TRANSPARENT, android.graphics.PorterDuff.Mode.CLEAR);
                                // 绘上新图区域
                                float x = (float) physicalTool.getX();
                                // float y = (float) physicalTool.getY();
                                float y = (float) physicalTool.getMirrorY(getHeight(), bitmap.getHeight());
                                // LogOut.out(this, "x:" + x + " y:" + y);
                                canvas.drawRect(x, y, x + bitmap.getWidth(), y + bitmap.getHeight(), pTmp);
                                canvas.drawBitmap(bitmap, x, y, paint);
                                holder.unlockCanvasAndPost(canvas);
                                Thread.sleep(SLEEP_DURATION);
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }
                // 清除屏幕内容
                // 直接按"Home"回桌面，SurfaceView被销毁了，lockCanvas返回为null。
                if (surfaceDestoryed == false) {
                        canvas = holder.lockCanvas();
                        canvas.drawColor(Color.TRANSPARENT, android.graphics.PorterDuff.Mode.CLEAR);
                        holder.unlockCanvasAndPost(canvas);
                }

                thread.setRunning(false);
                if (listener != null) {
                        listener.onParabolaEnd(this);
                }
        }

        public void showMovie() {
                if (thread == null) {
                        thread = new DrawThread(this);
                } else if (thread.getState() == Thread.State.TERMINATED) {
                        thread.setRunning(false);
                        thread = new DrawThread(this);
                }
            Log.d("Bruce1", "thread.getState:" + thread.getState());
                if (thread.getState() == Thread.State.NEW) {
                        thread.start();
                }
        }

        /** 正在播放动画时，返回true；否则返回false。 */
        public boolean isShowMovie() {
                return physicalTool.doing();
        }

        public void setIcon(Bitmap bit) {
                bitmap = bit;
        }

        public void setParams(int height, int width) {
                physicalTool.setParams(height, width);
        }

        /** 设置抛物线的动画监听器。 */
        public void setParabolaListener(ParabolaView.ParabolaListener listener) {
                this.listener = listener;
        }

        static interface ParabolaListener {
                public void onParabolaStart(ParabolaView view);

                public void onParabolaEnd(ParabolaView view);
        }
}