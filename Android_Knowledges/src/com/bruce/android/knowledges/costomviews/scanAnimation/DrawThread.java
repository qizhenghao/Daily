package com.bruce.android.knowledges.costomviews.scanAnimation;

import android.view.SurfaceView;

/**
 * @author Sodino E-mail:sodinoopen@hotmail.com
 * @version Time：2012-6-18 上午03:14:31
 */
public class DrawThread extends Thread {
        private SurfaceView surfaceView;
        private boolean running;

        public DrawThread(SurfaceView surfaceView) {
                this.surfaceView = surfaceView;
        }

        public void run() {
                if (surfaceView == null) {
                        return;
                }
                if (surfaceView instanceof ParabolaView) {
                        ((ParabolaView) surfaceView).handleThread();
                }
        }

        public void setRunning(boolean b) {
                running = b;
        }

        public boolean isRunning() {
                return running;
        }
}