package com.merchant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.ToastManager;
import com.merchant.utils.UIUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/1810:09
 * desc   : 营业诊断
 * version: 1.0
 */
public class BusinessDiagnosisActivity extends BaseActivity implements View.OnClickListener {

    private TextView coldmost_date_tv, amount_tv, sum_tv, newcustomer_tv, oldcustomer_tv, cold_scan_tv,
            hotmost_date_tv, hot_amount_tv, hot_sum_tv, hot_newcustomer_tv, hot_oldcustomer_tv, hot_scan_tv;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businessdiagnosis);
        UIUtil.setStautsBar(this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "生意诊断", this);

        coldmost_date_tv = findViewById(R.id.coldmost_date_tv);
        amount_tv = findViewById(R.id.amount_tv);
        sum_tv = findViewById(R.id.sum_tv);
        newcustomer_tv = findViewById(R.id.newcustomer_tv);
        oldcustomer_tv = findViewById(R.id.oldcustomer_tv);
        cold_scan_tv = findViewById(R.id.cold_scan_tv);

        hotmost_date_tv = findViewById(R.id.hotmost_date_tv);
        hot_amount_tv = findViewById(R.id.hot_amount_tv);
        hot_sum_tv = findViewById(R.id.hot_sum_tv);
        hot_newcustomer_tv = findViewById(R.id.hot_newcustomer_tv);
        hot_oldcustomer_tv = findViewById(R.id.hot_oldcustomer_tv);
        hot_scan_tv = findViewById(R.id.hot_scan_tv);

        cold_scan_tv.setOnClickListener(this);
        hot_scan_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID://返回
                finish();
                overTransition(1);
                break;
            case R.id.cold_scan_tv: //cold-立即查看
                ToastManager.toastShort(this, "功能开发中...");
                break;
            case R.id.hot_scan_tv: //hot-立即查看
                ToastManager.toastShort(this, "功能开发中...");
//                intent = new Intent();
//                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
