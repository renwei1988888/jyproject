package com.merchant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:25
 * desc   : 提现设置
 * version: 1.0
 */
public class PaySettingActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout tofindpwd_rl, tochangepwd_rl;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawsetting);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "提现设置", this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        tochangepwd_rl = findViewById(R.id.tochangepwd_rl);
        tofindpwd_rl = findViewById(R.id.tofindpwd_rl);

        tofindpwd_rl.setOnClickListener(this);
        tochangepwd_rl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID://返回
                finish();
                overTransition(1);
                break;
            case R.id.tochangepwd_rl:
                intent = new Intent(this, PayPwdChangeActivity.class);
                startActivity(intent);
                overTransition(2);
                break;
            case R.id.tofindpwd_rl:
                intent = new Intent(this, PayPwdFindActivity.class);
                startActivity(intent);
                overTransition(2);
                break;
            default:
                break;
        }
    }
}
