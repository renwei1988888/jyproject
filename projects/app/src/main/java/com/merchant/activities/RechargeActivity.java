package com.merchant.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;
import com.merchant.weight.DialogManager;
import com.merchant.weight.RechargeChooseWayDialog;
import com.merchant.weight.RechargeInputPwdDialog;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:06
 * desc   : 充值
 * version: 1.0
 */
public class RechargeActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout way_rl;
    private RechargeChooseWayDialog dialogManager;
    private RechargeInputPwdDialog pwdDialog;
    private Intent intent;
    private TextView toRecharge_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "充值", this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        way_rl = findViewById(R.id.way_rl);
        way_rl.setOnClickListener(this);

        dialogManager = new RechargeChooseWayDialog(this);
        dialogManager.tv_dialog_title.setText("选择银行卡");
        dialogManager.toadd_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getBaseContext(), AddBankCardActivity.class);
                startActivity(intent);
                finish();
                overTransition(2);
            }
        });
        dialogManager.cancel_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogManager.dismiss();
            }
        });


        pwdDialog = new RechargeInputPwdDialog(this);
        pwdDialog.tv_dialog_title.setText("请输入支付密码");
        pwdDialog.toadd_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getBaseContext(), PayPwdFindSetNewPwdActivity.class);
                startActivity(intent);
                finish();
                overTransition(2);
            }
        });
        pwdDialog.cancel_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwdDialog.dismiss();
            }
        });

        toRecharge_tv = findViewById(R.id.toRecharge_tv);
        toRecharge_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID://返回
                finish();
                overTransition(1);
                break;
            case R.id.way_rl:
                dialogManager.show();
                dialogManager.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        dialogManager.dismiss();
                    }
                });
                break;
            case R.id.toRecharge_tv:
                pwdDialog.show();
                pwdDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        pwdDialog.dismiss();
                    }
                });
                break;
            default:
                break;
        }
    }
}
