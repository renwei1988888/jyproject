package com.merchant.utils;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.WindowManager;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/711:16
 * desc   : app工具类
 * version: 1.0
 */
public class AppUtil {

	/**
     * 获取屏幕分辨率
     * @param context
     * @return
     */
    public static int[] getScreenDispaly(Context context) {
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		int width = windowManager.getDefaultDisplay().getWidth();// 手机屏幕的宽度
		int height = windowManager.getDefaultDisplay().getHeight();//手机屏幕的高度
		int result[] = { width, height };
		return result;
	}

    /**
	 * 获取版本名称
	 * @param context
	 * @return
	 */
	public static String getVerName(Context context) {
		String verName = "";
		try {
			verName = context.getPackageManager().getPackageInfo(
					"com.hjg.hjg88", 0).versionName;
		} catch (NameNotFoundException e) {
			Log.e("erro", e.getMessage());
		}
		return verName;
	}

	/**
     * 得到手机识别码
     */
    public static String getIMEI(Context context) {
        TelephonyManager mTelephonyMgr = (TelephonyManager) context
                .getSystemService(context.TELEPHONY_SERVICE);
        //String imei = mTelephonyMgr.getImei();
        String imei = "";
        return imei;
    }
    
	/**
     * 得到特定 key --- Crc
     */
    public static String getCrc(String time, String imei, String key) {
        return MD5.md5(time + imei  + MD5.md5(key));
    }
    
    
    /**
     * 生成授权信息
     * @param crc
     * @param time
     * @param imei
     * @param key
     * @return
     */
   /* public static AuthInfoModel getAuthInfo(String crc, String time, String imei){
    	AuthInfoModel model = new AuthInfoModel();
    	model.setCrc(crc);
    	model.setTime(time);
    	model.setImei(imei);
    	return model;
    }*/
}
