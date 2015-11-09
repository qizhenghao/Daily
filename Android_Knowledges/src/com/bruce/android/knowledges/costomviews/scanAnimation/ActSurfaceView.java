package com.bruce.android.knowledges.costomviews.scanAnimation;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.bruce.android.knowledges.R;

public class ActSurfaceView extends Activity implements OnClickListener, ParabolaView.ParabolaListener, Callback,
        RotateAnimation.InterpolatedTimeListener {
        public static final int REFRESH_TEXTVIEW = 1;
        private Button btnStartAnimation;
        /** 动画界面。 */
        private ParabolaView parabolaView;
        /** 购物车处显示购物数量的TextView。 */
        private TextView txtNumber;
        /** 购物车中的数量。 */
        private int number;
        private Handler handler;
        /** TextNumber是否允许显示最新的数字。 */
        private boolean enableRefresh;

        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.test_scan_animation_main);

                handler = new Handler(this);

                number = 0;

                btnStartAnimation = (Button) findViewById(R.id.btnStartAnim);
                btnStartAnimation.setOnClickListener(this);

                parabolaView = (ParabolaView) findViewById(R.id.surfaceView);
                parabolaView.setParabolaListener(this);

                txtNumber = (TextView) findViewById(R.id.txtNumber);
        }

        public void onClick(View v) {
                if (v == btnStartAnimation) {
                    Log.d("Bruce1" , "isShowMovie:" + parabolaView.isShowMovie());
                        if (parabolaView.isShowMovie() == false) {
                                number++;
                                enableRefresh = true;
                                parabolaView.setIcon(BitmapFactory.decodeResource(getResources(), R.drawable.scan_icon));
                                // 设置起始Y轴高度和终止X轴位移
                                parabolaView.setParams(200, ((ViewGroup) txtNumber.getParent()).getLeft());
                                parabolaView.showMovie();
                        }
                }
        }

        public void onParabolaStart(ParabolaView view) {

        }

        public void onParabolaEnd(ParabolaView view) {
                handler.sendEmptyMessage(REFRESH_TEXTVIEW);
        }

        public boolean handleMessage(Message msg) {
                switch (msg.what) {
                case REFRESH_TEXTVIEW:

                        if (txtNumber.getVisibility() != View.VISIBLE) {
                                txtNumber.setVisibility(View.VISIBLE);
                        }
                        RotateAnimation anim = new RotateAnimation(txtNumber.getWidth() >> 1, txtNumber.getHeight() >> 1,
                                        RotateAnimation.ROTATE_INCREASE);
                        anim.setInterpolatedTimeListener(this);
                        txtNumber.startAnimation(anim);
                        break;
                }
                return false;
        }

        @Override
        public void interpolatedTime(float interpolatedTime) {
                // 监听到翻转进度过半时，更新txtNumber显示内容。
                if (enableRefresh && interpolatedTime > 0.5f) {
                        txtNumber.setText(Integer.toString(number));
                        // Log.d("ANDROID_LAB", "setNumber:" + number);
                        enableRefresh = false;
                }
        }
}