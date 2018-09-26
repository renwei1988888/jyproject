package com.merchant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;

/**
 * @name renwei
 * @time 2018/9/24 0:56
 * @class 找回密码第二步
 */
public class PayPwdFindStepTwoActivity extends BaseActivity implements View.OnClickListener {

    private TextView toauth_tv;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypwdfind_steptwo);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "找回提现密码", this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        toauth_tv = findViewById(R.id.toauth_tv);
        toauth_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID:// 返回
                finish();
                overTransition(1);
                break;
            case R.id.toauth_tv: // 验证完毕，设置新的密码
                intent = new Intent(this, PayPwdFindSetNewPwdActivity.class);
                startActivity(intent);
                finish();
                overTransition(2);
                break;
            default:
                break;
        }
    }
}
