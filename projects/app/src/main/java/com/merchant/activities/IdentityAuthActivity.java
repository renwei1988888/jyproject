package com.merchant.activities;

import android.os.Bundle;
import android.view.View;

import com.merchant.utils.HeaderViewControler;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:38
 * desc   : 身份认证
 * version: 1.0
 */
public class IdentityAuthActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "身份认证", this);
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
