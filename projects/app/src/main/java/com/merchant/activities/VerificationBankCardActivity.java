package com.merchant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:14
 * desc   : 验证银行卡
 * version: 1.0
 */
public class VerificationBankCardActivity extends BaseActivity implements View.OnClickListener {

    private TextView protocal_tv;
    private ImageView isagree_img;
    private Boolean isagree = true;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybankcard_validate);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "验证银行卡", this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        isagree_img = findViewById(R.id.isagree_img);
        // 设置是否同意服务协议
        setIsAgree(isagree);
        isagree_img.setOnClickListener(this);

        protocal_tv = findViewById(R.id.protocal_tv);
        protocal_tv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID://返回
                finish();
                overTransition(1);
                break;
            case R.id.isagree_img:
                setIsAgree(isagree);
                break;
            case R.id.protocal_tv:
                intent = new Intent(this, ServiceProtocalActivity.class);
                startActivity(intent);
                overTransition(2);
                break;
            default:
                break;
        }
    }

    private void setIsAgree(Boolean isAgree) {
        if (isAgree) {
            isagree_img.setImageDrawable(getResources().getDrawable(R.mipmap.mybank_agree_yes));
            isagree = false;
        } else {
            isagree_img.setImageDrawable(getResources().getDrawable(R.mipmap.mybank_agree_no));
            isagree = true;
        }

    }
}
