package com.merchant.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/617:51
 * desc   : 提示框攻击类
 * version: 1.0
 */
public class ToastManager {

    // 提示框短暂停留
    public static void toastShort(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    // 提示框长时间停留
    public static void toastLong(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_LONG).show();
    }

}
