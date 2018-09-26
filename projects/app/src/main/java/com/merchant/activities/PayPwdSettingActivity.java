package com.merchant.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.merchant.R;

/**
 * @name renwei
 * @time 2018/9/17 22:14
 * @class 支付密码设置
 */
public class PayPwdSettingActivity extends BaseActivity implements View.OnClickListener {

    private EditText one_edt, two_edt, three_edt, four_edt, five_edt, six_edt;
    private String onep, twop, threep, fourp, fivep, sixp, paypwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setpaypwd);

        findViewAndInit();
    }

    private void findViewAndInit() {
        one_edt = findViewById(R.id.one_edt);
        two_edt = findViewById(R.id.two_edt);
        three_edt = findViewById(R.id.three_edt);
        four_edt = findViewById(R.id.four_edt);
        five_edt = findViewById(R.id.five_edt);
        six_edt = findViewById(R.id.six_edt);

        onep = one_edt.getText().toString().trim();
        twop = two_edt.getText().toString().trim();
        threep = three_edt.getText().toString().trim();
        fourp = four_edt.getText().toString().trim();
        fivep = five_edt.getText().toString().trim();
        sixp = six_edt.getText().toString().trim();
        paypwd = onep + twop + threep + fourp + fivep + sixp;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.six_edt:
                break;
            default:
                break;

        }
    }
}
