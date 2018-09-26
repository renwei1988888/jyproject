package com.merchant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:20
 * desc   : 服务协议详情
 * version: 1.0
 */
public class ServiceProtocalDetailActivity extends BaseActivity implements View.OnClickListener {

    private TextView detail_type_tv, detail_content_tv;
    private Intent intent;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problemandpaydetail);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "服务协议", this);

        detail_type_tv = findViewById(R.id.detail_type_tv);
        detail_content_tv = findViewById(R.id.detail_content_tv);

        intent = getIntent();
        title = intent.getStringExtra("title");
        detail_type_tv.setText(title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID://返回
                finish();
                overTransition(1);
                break;
            default:
                break;
        }
    }
}
