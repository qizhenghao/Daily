package com.bruce.android.knowledges;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ListView;
import com.bruce.android.knowledges.Activities.*;

public class MyActivity extends Activity implements View.OnClickListener{

    private Context mContext = null;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initViews();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initData() {
        mContext = MyActivity.this;
    }

    private void initViews() {

    }


    private AlphaAnimation mHideAnimation= null;
    private AlphaAnimation mShowAnimation= null;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_open_test_shader_btn:
                startActivity(new Intent(mContext, TestShaderActivity.class));
                break;
            case R.id.main_open_test_canvas_btn:
                startActivity(new Intent(mContext, CanvasActivity.class));
                break;
            case R.id.main_open_test_custom_viewgroup_btn:
                startActivity(new Intent(mContext, TestCustomViewGroupActivity.class));
                break;
            case R.id.main_open_test_flowlayout_btn:
                startActivity(new Intent(mContext, TestFlowLayoutActivity.class));
                break;
            case R.id.main_open_textviewlink_btn:
                startActivity(new Intent(mContext, TextViewLinkActivity.class));
                break;
            case R.id.main_open_rotation_text_btn:
                startActivity(new Intent(mContext, TestRotationTextViewActivity.class));
                break;
            case R.id.main_open_transform_matrix_btn:
                startActivity(new Intent(mContext, TestTransformMatrixActivity.class));
                break;
            case R.id.main_open_single_touch_btn:
                startActivity(new Intent(mContext, TestSingleTouchActivity.class));
                break;

            default:
                break;
        }
    }


    /**
     * View渐隐动画效果
     */
    private void setHideAnimation(View view, int duration) {
        if (null == view || duration < 0) {
            return;
        }
        if (null != mHideAnimation) {
            mHideAnimation.cancel();
        }
        mHideAnimation = new AlphaAnimation(1.0f, 0.0f);
        mHideAnimation.setDuration(duration);
        mHideAnimation.setFillAfter(true);
        view.startAnimation(mHideAnimation);
    }

    /**
     * View渐现动画效果
     */
    private void setShowAnimation(View view, int duration) {
        if (null == view || duration < 0) {
            return;
        }
        if (null != mShowAnimation) {
            mShowAnimation.cancel();
        }
        mShowAnimation = new AlphaAnimation(0.0f, 1.0f);
        mShowAnimation.setDuration(duration);
        mShowAnimation.setFillAfter(true);
        view.startAnimation(mShowAnimation);
    }
}
