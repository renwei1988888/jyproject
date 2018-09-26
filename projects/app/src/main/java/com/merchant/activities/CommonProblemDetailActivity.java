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
 * date   : 2018/9/189:46
 * desc   : 常见问题详情
 * version: 1.0
 */
public class CommonProblemDetailActivity extends BaseActivity implements View.OnClickListener {

    private TextView detail_type_tv, detail_tv;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commonproblemdetail);

        findViewAndInit();
    }

    private void findViewAndInit() {
        detail_type_tv = findViewById(R.id.detail_type_tv);
        detail_tv = findViewById(R.id.detail_tv);
        intent = getIntent();
        int commtype = (int) intent.getIntExtra("type", 0);
        if (commtype == 0) {
            HeaderViewControler.setHeaderView(this, "什么是余额", this);
            detail_type_tv.setText("什么是余额");
        } else if (commtype == 1) {
            HeaderViewControler.setHeaderView(this, "如何充值", this);
            detail_type_tv.setText("如何充值");
        } else if (commtype == 2) {
            HeaderViewControler.setHeaderView(this, "如何提现", this);
            detail_type_tv.setText("如何提现");
        } else if (commtype == 3) {
            HeaderViewControler.setHeaderView(this, "如何添加银行卡", this);
            detail_type_tv.setText("如何添加银行卡");
        } else if (commtype == 4) {
            HeaderViewControler.setHeaderView(this, "如何删除银行卡", this);
            detail_type_tv.setText("如何删除银行卡");
        } else {
            HeaderViewControler.setHeaderView(this, "钱包的功能", this);
            detail_type_tv.setText("钱包的功能");
        }
        UIUtil.setColor(this, getResources().getColor(R.color.black));

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
