package com.merchant.activities;

import android.os.Bundle;
import android.view.View;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;
import com.merchant.weight.CircleProgressView;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/1810:20
 * desc   : 顾客画像
 * version: 1.0
 */
public class CustomerPortraitActivity extends BaseActivity implements View.OnClickListener {

    private CircleProgressView sex_circlepview, age_circlepview, work_circlepview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerportrait);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "顾客画像", this);
        UIUtil.setStautsBar(this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        sex_circlepview = findViewById(R.id.sex_circlepview);
        age_circlepview = findViewById(R.id.age_circlepview);
        work_circlepview = findViewById(R.id.work_circlepview);

        sex_circlepview.setProgress(37);
        sex_circlepview.setmTxtHint1("37%");
        sex_circlepview.setmTxtHint2("女性");

        age_circlepview.setProgress(37);
        age_circlepview.setmTxtHint1("37%");
        age_circlepview.setmTxtHint2("20-30岁");

        work_circlepview.setProgress(37);
        work_circlepview.setmTxtHint1("37%");
        work_circlepview.setmTxtHint2("白领");

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
