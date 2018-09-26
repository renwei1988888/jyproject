package com.merchant.utils;

import android.os.Handler;

import com.merchant.weight.DialogManager;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:30
 * desc   : 弹出框工具类
 * version: 1.0
 */
public class DialogUtil {
    public static void setNoBtnLittleDialogDismiss(final DialogManager dialogManager) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialogManager.dismiss();
            }
        }, 1500);
    }
}
