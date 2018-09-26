package com.merchant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:07
 * desc   : 我的银行卡
 * version: 1.0
 */
public class MyBankCardActivity extends BaseActivity implements View.OnClickListener {

    private ListView bankcard_lv;
    private TextView toadd_tv;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybankcard);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "我的银行卡", this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        bankcard_lv = findViewById(R.id.bankcard_lv);
        toadd_tv = findViewById(R.id.toadd_tv);

        toadd_tv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID:// 返回
                finish();
                overTransition(1);
                break;
            case R.id.toadd_tv: // 增加银行卡
                intent = new Intent(this, AddBankCardActivity.class);
                startActivity(intent);
                overTransition(2);
                break;
            default:
                break;
        }
    }
}
