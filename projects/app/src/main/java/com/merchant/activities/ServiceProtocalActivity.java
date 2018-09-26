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
 * date   : 2018/9/189:15
 * desc   : 服务协议
 * version: 1.0
 */
public class ServiceProtocalActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout payprotocal_rl, paycode_rl;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payprotocal);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "服务协议", this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        payprotocal_rl = findViewById(R.id.payprotocal_rl);
        paycode_rl = findViewById(R.id.paycode_rl);

        payprotocal_rl.setOnClickListener(this);
        paycode_rl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID://返回
                finish();
                overTransition(1);
                break;
            case R.id.payprotocal_rl:
                intent = new Intent(this, ServiceProtocalDetailActivity.class);
                intent.putExtra("title", "支付服务协议");
                startActivity(intent);
                overTransition(2);
                break;
            case R.id.paycode_rl:
                intent = new Intent(this, ServiceProtocalDetailActivity.class);
                intent.putExtra("title", "支付银联二维码服务协议");
                startActivity(intent);
                overTransition(2);
                break;
            default:
                break;
        }
    }
}
