package com.merchant.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/1810:08
 * desc   : 营业设置
 * version: 1.0
 */
public class BusinessSettingActivity extends BaseActivity implements View.OnClickListener {

    private Switch systemnotice_switch, voice_switch, recharge_switch, change_switch, sms_switch;
    private RelativeLayout membermanager_rl, production_rl, suggesion_rl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businesssetting);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "营业设置", this);
        UIUtil.setStautsBar(this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        systemnotice_switch = findViewById(R.id.systemnotice_switch);
        voice_switch = findViewById(R.id.voice_switch);
        recharge_switch = findViewById(R.id.recharge_switch);
        change_switch = findViewById(R.id.change_switch);
        sms_switch = findViewById(R.id.sms_switch);
        membermanager_rl = findViewById(R.id.membermanager_rl);
        production_rl = findViewById(R.id.production_rl);
        suggesion_rl = findViewById(R.id.suggesion_rl);

        membermanager_rl.setOnClickListener(this);
        production_rl.setOnClickListener(this);
        suggesion_rl.setOnClickListener(this);
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
