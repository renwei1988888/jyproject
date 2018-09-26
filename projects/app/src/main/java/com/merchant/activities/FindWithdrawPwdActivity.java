package com.merchant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:39
 * desc   : 找回提现密码
 * version: 1.0
 */
public class FindWithdrawPwdActivity extends BaseActivity implements View.OnClickListener {

    private EditText idcard_edt;
    private TextView toauth_tv;
    private String idcard;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findwithdrawpwd);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "找回提现密码", this);

        idcard_edt = findViewById(R.id.idcard_edt);
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
            case R.id.idcard_edt:
                idcard = idcard_edt.getText().toString().trim();
                intent = new Intent();
                startActivity(intent);
                overTransition(2);
                break;
            default:
                break;
        }
    }
}
