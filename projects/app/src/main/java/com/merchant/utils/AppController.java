package com.merchant.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/710:07
 * desc   : app配置类
 * version: 1.0
 */
public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();
    public static List<Activity> listActivity = new ArrayList<Activity>();
    public static boolean isFromRegister;
    public static boolean isFromGestureVerify;
    public static boolean isFromHomeActivity;
    public static boolean isFromNewsNoticeDetailsActivity;
    public static boolean AccountInfIsChange;
    public static boolean isFristLogin = true;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    ////拍照存储的文件名
    public static final String IMAGE_PATH = "HJGApp";
    public static final File FILE_SDCARD = Environment.getExternalStorageDirectory().getAbsoluteFile();
    public static final File FILE_LOCAL = new File(FILE_SDCARD,IMAGE_PATH);
    public static final File FILE_PIC_SCREENSHOT = new File(FILE_LOCAL,"images/screenshots");

    private static AppController mInstance;
    public static int screenWidth;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        screenWidth = ScreenUtils.getScreenWidth(getApplicationContext());
//		CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(this);
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
