package com.merchant.weight;

import android.app.Dialog;
import android.content.Context;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.ViewParamsSetUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/2517:12
 * desc   :
 * version: 1.0
 */
public class RechargeChooseWayDialog extends Dialog {
    public TextView tv_dialog_title;
    public LinearLayout toadd_ll;
    public ImageView cancel_img;

    public RechargeChooseWayDialog(Context context) {
       super(context, R.style.add_dialog);
        this.setContentView(R.layout.dialog_rechargechooseway);
        ViewParamsSetUtil.setDialogPosition(this);

        tv_dialog_title = (TextView) findViewById(R.id.tv_dialog_title);
        cancel_img = findViewById(R.id.cancel_img);
        toadd_ll = findViewById(R.id.toadd_ll);
    }
}
