package com.merchant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:40
 * desc   : 常见问题
 * version: 1.0
 */
public class CommonProblemActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout whatbalance_rl, whatrecharge_rl, whatwithdraw_rl, whataddbank_rl, whatdeletebank_rl, whatwallet_rl;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commonproblem);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "常见问题", this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        whatbalance_rl = findViewById(R.id.whatbalance_rl);
        whatrecharge_rl = findViewById(R.id.whatrecharge_rl);
        whatwithdraw_rl = findViewById(R.id.whatwithdraw_rl);
        whataddbank_rl = findViewById(R.id.whataddbank_rl);
        whatdeletebank_rl = findViewById(R.id.whatdeletebank_rl);
        whatwallet_rl = findViewById(R.id.whatwallet_rl);

        whatbalance_rl.setOnClickListener(this);
        whatrecharge_rl.setOnClickListener(this);
        whatwithdraw_rl.setOnClickListener(this);
        whataddbank_rl.setOnClickListener(this);
        whatdeletebank_rl.setOnClickListener(this);
        whatwallet_rl.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID://返回
                finish();
                overTransition(1);
                break;
            case R.id.whatbalance_rl:
                intent = new Intent(this, CommonProblemDetailActivity.class);
                intent.putExtra("type", 0);
                startActivity(intent);
                overTransition(2);
                break;
            case R.id.whatrecharge_rl:
                intent = new Intent(this, CommonProblemDetailActivity.class);
                intent.putExtra("type", 1);
                startActivity(intent);
                overTransition(2);
                break;
            case R.id.whatwithdraw_rl:
                intent = new Intent(this, CommonProblemDetailActivity.class);
                intent.putExtra("type", 2);
                startActivity(intent);
                overTransition(2);
                break;
            case R.id.whataddbank_rl:
                intent = new Intent(this, CommonProblemDetailActivity.class);
                intent.putExtra("type", 3);
                startActivity(intent);
                overTransition(2);
                break;
            case R.id.whatdeletebank_rl:
                intent = new Intent(this, CommonProblemDetailActivity.class);
                intent.putExtra("type", 4);
                startActivity(intent);
                overTransition(2);
                break;
            case R.id.whatwallet_rl:
                intent = new Intent(this, CommonProblemDetailActivity.class);
                intent.putExtra("type", 5);
                startActivity(intent);
                overTransition(2);
                break;
            default:
                break;
        }
    }
}
