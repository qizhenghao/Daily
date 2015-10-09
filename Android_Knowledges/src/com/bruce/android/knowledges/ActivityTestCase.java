package com.bruce.android.knowledges;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;

/**
 * Created by qizhenghao on 15-9-17.
 */
public class ActivityTestCase extends AndroidTestCase {

    public static final String TAG = "**Test**: ";
    public void testSave() throws Exception {
        Context context = getContext();

        Log.e(TAG, context.getCacheDir().getAbsolutePath());
        Log.e(TAG, context.getPackageCodePath());
        Log.e(TAG, context.getFilesDir().getAbsolutePath());
    }
}
