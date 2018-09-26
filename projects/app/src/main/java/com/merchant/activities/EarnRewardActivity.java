package com.merchant.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.adapter.EarnRewardAdapter;
import com.merchant.entity.EarnRewardEntity;
import com.merchant.utils.HeaderViewControler;

import java.util.ArrayList;
import java.util.List;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/1810:15
 * desc   : 赚钱赏金
 * version: 1.0
 */
public class EarnRewardActivity extends BaseActivity implements View.OnClickListener {

    private TextView rewardamount_tv, all_tv, used_tv;
    private ListView rewardlistview;
    private List<EarnRewardEntity> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earnreward);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "赚钱赏金", this);

        rewardamount_tv = findViewById(R.id.rewardamount_tv);
        all_tv = findViewById(R.id.all_tv);
        used_tv = findViewById(R.id.used_tv);

        rewardlistview = findViewById(R.id.rewardlistview);

        list = new ArrayList<EarnRewardEntity>();
        for (int i = 0; i < 20; i++) {
            EarnRewardEntity entity = new EarnRewardEntity();
            entity.setShopname("东塘步步高店");
            entity.setRewardamount("¥20000.00");
            list.add(entity);
        }
        EarnRewardAdapter adapter = new EarnRewardAdapter(list, this);

        rewardlistview.setAdapter(adapter);

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
