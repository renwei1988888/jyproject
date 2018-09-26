package com.merchant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:24
 * desc   : 我的支付宝
 * version: 1.0
 */
public class MyAlipayActivtiy extends BaseActivity implements View.OnClickListener {

    private LinearLayout account_ll;
    private RelativeLayout noaccount_rl;
    private TextView toadd_tv, myalipay_name_tv, myalipay_account_tv;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myalipay);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "我的支付宝", this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        account_ll = findViewById(R.id.account_ll);
        account_ll.setVisibility(View.GONE);
        noaccount_rl = findViewById(R.id.noaccount_rl);
        noaccount_rl.setVisibility(View.VISIBLE);
        toadd_tv = findViewById(R.id.toadd_tv);
        myalipay_account_tv = findViewById(R.id.myalipay_account_tv);
        myalipay_name_tv = findViewById(R.id.myalipay_name_tv);

        toadd_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID://返回
                finish();
                overTransition(1);
                break;
            case R.id.toadd_tv: // 添加支付宝账号
                intent = new Intent(this, AddAlipayActivity.class);
                startActivityForResult(intent, 100);
                overTransition(2);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 101) {
            if (requestCode == 100) {
                myalipay_account_tv.setText(data.getStringExtra("account"));
                myalipay_name_tv.setText("刘春晓");
                account_ll.setVisibility(View.VISIBLE);
                noaccount_rl.setVisibility(View.GONE);
            }
        }

    }
}
