package com.merchant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:24
 * desc   : 新增支付宝账号
 * version: 1.0
 */
public class AddAlipayActivity extends BaseActivity implements View.OnClickListener {

    private TextView sure_tv;
    private EditText alipay_edt;
    private String alipay_account;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addalipay);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "添加支付宝", this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        sure_tv = findViewById(R.id.sure_tv);
        alipay_edt = findViewById(R.id.alipay_edt);

        sure_tv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID: // 返回
                finish();
                overTransition(1);
                break;
            case R.id.sure_tv: // 完成
                alipay_account = alipay_edt.getText().toString().trim();
                intent = new Intent();
                intent.putExtra("account", alipay_account);
                setResult(101, intent);
                finish();
                overTransition(1);
                break;
            default:
                break;
        }
    }
}
