package com.merchant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:05
 * desc   : 我的钱包
 * version: 1.0
 */
public class MyWalletActivity extends BaseActivity implements View.OnClickListener {

    private TextView sum_tv, wsum_tv, toproblem_tv;
    private RelativeLayout mybankcard_rl, paysetting_rl, myalilpay_rl;
    private LinearLayout recharge_ll, withdraw_ll;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "我的钱包", this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        sum_tv = findViewById(R.id.sum_tv);
        wsum_tv = findViewById(R.id.wsum_tv);
        toproblem_tv = findViewById(R.id.toproblem_tv);

        mybankcard_rl = findViewById(R.id.mybankcard_rl);
        paysetting_rl = findViewById(R.id.paysetting_rl);
        myalilpay_rl = findViewById(R.id.myalilpay_rl);
        recharge_ll = findViewById(R.id.recharge_ll);
        withdraw_ll = findViewById(R.id.withdraw_ll);

        toproblem_tv.setOnClickListener(this);
        mybankcard_rl.setOnClickListener(this);
        paysetting_rl.setOnClickListener(this);
        myalilpay_rl.setOnClickListener(this);
        recharge_ll.setOnClickListener(this);
        withdraw_ll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID: // 返回
                finish();
                overTransition(1);
                break;
            case R.id.toproblem_tv: // 常见问题
                intent = new Intent(this, CommonProblemActivity.class);
                startActivity(intent);
                overTransition(2);
                break;
            case R.id.mybankcard_rl: // 我的银行卡
                intent = new Intent(this, MyBankCardActivity.class);
                startActivity(intent);
                overTransition(2);
                break;
            case R.id.paysetting_rl: // 支付设置
                intent = new Intent(this, PaySettingActivity.class);
                startActivity(intent);
                overTransition(2);
                break;
            case R.id.myalilpay_rl: // 我的支付宝
                intent = new Intent(this, MyAlipayActivtiy.class);
                startActivity(intent);
                overTransition(2);
                break;
            case R.id.recharge_ll: // 充值
                intent = new Intent(this, RechargeActivity.class);
                startActivity(intent);
                overTransition(2);
                break;
            case R.id.withdraw_ll: // 提现
                intent = new Intent(this, WithDrawActivity.class);
                startActivity(intent);
                overTransition(2);
                break;
            default:
                break;
        }
    }
}
