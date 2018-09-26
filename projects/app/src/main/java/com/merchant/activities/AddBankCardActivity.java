package com.merchant.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.constants.Constants;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:11
 * desc   : 添加银行卡
 * version: 1.0
 */
public class AddBankCardActivity extends BaseActivity implements View.OnClickListener {

    private EditText card_edt;
    private TextView tonext_tv;
    private ImageView toscan_img;
    private String cardId;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybankcard_add);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "添加银行卡", this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        card_edt = findViewById(R.id.card_edt);
        tonext_tv = findViewById(R.id.tonext_tv);
        toscan_img = findViewById(R.id.toscan_img);

        tonext_tv.setOnClickListener(this);
        toscan_img.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID://返回
                finish();
                overTransition(1);
                break;
            case R.id.tonext_tv: // 下一步
                cardId = card_edt.getText().toString().trim();
                intent = new Intent(this, VerificationBankCardActivity.class);
                startActivity(intent);
                overTransition(2);
                break;
            case R.id.toscan_img: // 扫描银行卡
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    // 申请权限
                    ActivityCompat.requestPermissions(AddBankCardActivity.this, new String[]{Manifest.permission.CAMERA}, Constants.REQ_PERM_CAMERA);
                    return;
                }
                intent = new Intent(this, ScanBankCardActivity.class);
                startActivity(intent);
                overTransition(2);
                break;
            default:
                break;
        }
    }
}
