package com.merchant.weight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.merchant.R;
import com.merchant.utils.Save;
import com.merchant.utils.ScreenUtils;


/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/810:30
 * desc   : 项目底部自定义控件
 * version: 1.0
 */
public class FooterView extends LinearLayout {
    // 底部tab
    private ImageView img_receivables, img_marketing, img_member, img_management;
    private LinearLayout lin_receivables, lin_marketing, lin_member, lin_management;
    private Bitmap[] imgBitmaps;
    private Context context;
    private boolean isLondingOver;
    private int tab;

    public FooterView(Context context) {
        super(context);
    }

    public FooterView(Context context, AttributeSet attrs, int paramInt) {
        super(context, attrs, paramInt);
    }

    public FooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.footer_view_layout, this);
        this.context = context;
        img_receivables = (ImageView) findViewById(R.id.img_receivables);
        img_marketing = (ImageView) findViewById(R.id.img_marketing);
        img_member = (ImageView) findViewById(R.id.img_member);
        img_management = (ImageView) findViewById(R.id.img_management);

        lin_receivables = (LinearLayout) findViewById(R.id.lin_receivables);
        lin_marketing = (LinearLayout) findViewById(R.id.lin_marketing);
        lin_member = (LinearLayout) findViewById(R.id.lin_member);
        lin_management = (LinearLayout) findViewById(R.id.lin_management);

        new MyAsyncTask().execute();
    }

    public void setOnClickmListener(OnClickListener listener) {
        lin_marketing.setOnClickListener(listener);
        lin_receivables.setOnClickListener(listener);
        lin_member.setOnClickListener(listener);
        lin_management.setOnClickListener(listener);
    }

    /**
     * 根据点击按钮改变底部状态
     */
    public void setFooter(boolean receivablesIscheck, boolean marketingIscheck,
                          boolean memberIscheck, boolean managementIscheck) {
        if (!isLondingOver) {
            return;
        }
        if (receivablesIscheck) {
            img_receivables.setImageBitmap(imgBitmaps[0]);
        } else {
            img_receivables.setImageBitmap(imgBitmaps[1]);
        }
        if (marketingIscheck) {
            img_marketing.setImageBitmap(imgBitmaps[2]);
        } else {
            img_marketing.setImageBitmap(imgBitmaps[3]);
        }
        if (memberIscheck) {
            img_member.setImageBitmap(imgBitmaps[4]);
        } else {
            img_member.setImageBitmap(imgBitmaps[5]);
        }
        if (managementIscheck) {
            img_management.setImageBitmap(imgBitmaps[6]);
        } else {
            img_management.setImageBitmap(imgBitmaps[7]);
        }

    }

    /**
     * 根据点击按钮改变底部状态
     */
    public void setFooterTab(int tab) {
        this.tab = tab;
        if (tab == 0) {
            setFooter(true, false, false, false);
        } else if (tab == 1) {
            setFooter(false, true, false, false);
        } else if (tab == 2) {
            setFooter(false, false, true, false);
        } else if (tab == 3) {
            setFooter(false, false, false, true);
        }
    }

    private class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            imgBitmaps = new Bitmap[10];
            Bitmap top = BitmapFactory.decodeResource(context.getResources(), R.drawable.top_bg);
            int w = ScreenUtils.getScreenWidth(context);
            int width2 = ScreenUtils.getScreenHeight(context) + 200;
            imgBitmaps[0] = Save.ScaleBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher), w, width2);
            imgBitmaps[1] = Save.ScaleBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher), w, width2);
            imgBitmaps[2] = Save.ScaleBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher), w, width2);
            imgBitmaps[3] = Save.ScaleBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher), w, width2);
            imgBitmaps[4] = Save.ScaleBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher), w, width2);
            imgBitmaps[5] = Save.ScaleBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher), w, width2);
            imgBitmaps[6] = Save.ScaleBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher), w, width2);
            imgBitmaps[7] = Save.ScaleBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher), w, width2);
            return null;

        }

        @Override
        protected void onPostExecute(Void result) {
            isLondingOver = true;
            setFooterTab(tab);
        }

    }

}
