package com.merchant.activities;

import android.os.Bundle;
import android.view.View;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/1810:23
 * desc   : 商户贷
 * version: 1.0
 */
public class MerchantLoanActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchantloan);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "商户贷", this);
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
