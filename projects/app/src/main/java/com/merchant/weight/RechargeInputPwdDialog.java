package com.merchant.weight;

import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.ViewParamsSetUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/2517:48
 * desc   :
 * version: 1.0
 */
public class RechargeInputPwdDialog extends Dialog {

    public TextView tv_dialog_title, moneytype_tv;
    public RelativeLayout toadd_rl;
    public ImageView cancel_img;

    public RechargeInputPwdDialog(Context context) {
        super(context, R.style.add_dialog);
        this.setContentView(R.layout.dialog_rechargeinputpwd);
        ViewParamsSetUtil.setDialogPosition(this);

        tv_dialog_title = (TextView) findViewById(R.id.tv_dialog_title);
        moneytype_tv = findViewById(R.id.moneytype_tv);
        cancel_img = findViewById(R.id.cancel_img);
        toadd_rl = findViewById(R.id.toadd_rl);
    }
}
