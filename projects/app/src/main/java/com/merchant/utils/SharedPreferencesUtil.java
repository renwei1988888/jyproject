package com.merchant.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/711:16
 * desc   : 本地数据保存
 * version: 1.0
 */
public class SharedPreferencesUtil {

    /**
     * 获取UserId
     *
     * @param mcontext
     * @return
     */
    public static String getUserId(Context mcontext) {
        SharedPreferences resultpre_pass = PreferenceManager
                .getDefaultSharedPreferences(mcontext);
        return resultpre_pass.getString("UserId", "");
    }

    /**
     * 保存UserId
     *
     * @param userId
     * @param mcontext
     */
    public static void setUserId(String userId,
                                 Context mcontext) {
        SharedPreferences resultpre_patient = PreferenceManager
                .getDefaultSharedPreferences(mcontext);
        SharedPreferences.Editor editor = resultpre_patient.edit();
        editor.putString("UserId", userId);
        editor.commit();
    }

    /**
     * 保存Token
     *
     * @param token
     * @param mcontext
     */
    public static void setResult_AuthToken(String token,
                                           Context mcontext) {
        SharedPreferences resultpre_patient = PreferenceManager
                .getDefaultSharedPreferences(mcontext);
        SharedPreferences.Editor editor = resultpre_patient.edit();
        editor.putString("AuthToken", token);
        editor.commit();
    }

    /**
     * 获取Token
     *
     * @param mcontext
     * @return
     */
    public static String getResult_AuthToken(Context mcontext) {
        SharedPreferences resultpre_patient = PreferenceManager
                .getDefaultSharedPreferences(mcontext);
        return resultpre_patient.getString("AuthToken", "");
    }

    public static String getResult_Cookie(Context mcontext) {
        SharedPreferences resultpre_patient = PreferenceManager
                .getDefaultSharedPreferences(mcontext);
        return resultpre_patient.getString("Cookie", "");
    }

    public static void clear_Cookie(Context mcontext) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(mcontext);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Cookie", "");
        editor.commit();
    }

    /**
     * 保存服务器当前时间 （yyyy-MM-dd HH:mm:ss）
     */
    public static void setServerNowTime(long serverNowTime, Context mcontext) {
        SharedPreferences resultpre_patient = PreferenceManager
                .getDefaultSharedPreferences(mcontext);
        SharedPreferences.Editor editor = resultpre_patient.edit();
        editor.putLong("serverNowTime", serverNowTime);
        editor.commit();
    }

    /**
     * 获取服务器当前时间 （yyyy-MM-dd HH:mm:ss）
     */
    public static long getServerNowTime(Context mcontext) {
        SharedPreferences resultpre_patient = PreferenceManager
                .getDefaultSharedPreferences(mcontext);
        return resultpre_patient.getLong("serverNowTime", 0);
    }

    /*清理本地数据*/
    public static void clearSharePref(Context mcontext) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(mcontext);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("savefilename", "");
        editor.putString("UserId", "");
        editor.putString("realname", "");
        editor.putBoolean("isAuth", false);
        editor.putBoolean("isBankAuth", false);
        editor.putString("UserId", "");
        editor.putString("AuthToken", "");
        editor.commit();
    }
}
