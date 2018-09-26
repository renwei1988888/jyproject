package com.merchant.utils;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.merchant.R;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/711:16
 * desc   : 页面头部管理器
 * version: 1.0
 */
public class HeaderViewControler {
    public final static int ID = R.id.img_back;
    public final static int TV_TITTLE = R.id.tv_title;

    public final static int HEADER_RL = R.id.header_top_rl;

    public static void setHeaderView(Activity mActivity, String title, OnClickListener l) {
        TextView tv_title = (TextView) mActivity.findViewById(TV_TITTLE);
        ImageView img_back = (ImageView) mActivity.findViewById(ID);
        tv_title.setText(title);
        img_back.setOnClickListener(l);
    }

    // 设置顶部箭头和文字颜色
    public static void setHeaderArrowFontColor(Activity mActivity) {
        TextView title_tv = mActivity.findViewById(R.id.tv_title);
        title_tv.setTextColor(mActivity.getResources().getColor(R.color.black));

        ImageView left_img = mActivity.findViewById(HeaderViewControler.ID);
        left_img.setImageDrawable(mActivity.getResources().getDrawable(R.mipmap.arrow_left_28x28));
    }

}
