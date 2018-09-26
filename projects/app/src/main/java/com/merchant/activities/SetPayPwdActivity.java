package com.merchant.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:10
 * desc   : 设置支付密码
 * version: 1.0
 */
public class SetPayPwdActivity extends BaseActivity implements View.OnClickListener {

    private EditText one_edt, two_edt, three_edt, four_edt, five_edt, six_edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setpaypwd);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "设置支付密码", this);

        one_edt = findViewById(R.id.one_edt);
        two_edt = findViewById(R.id.two_edt);
        three_edt = findViewById(R.id.three_edt);
        four_edt = findViewById(R.id.four_edt);
        five_edt = findViewById(R.id.five_edt);
        six_edt = findViewById(R.id.six_edt);
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
