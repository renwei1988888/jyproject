package com.merchant.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.merchant.R;
import com.merchant.adapter.IntelligentSaleAdapter;
import com.merchant.entity.IntelligentSaleEntity;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.UIUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/189:47
 * desc   : 智能售卖
 * version: 1.0
 */
public class IntelligentSaleActivity extends BaseActivity implements View.OnClickListener {

    private List<IntelligentSaleEntity> list;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intelligentsale);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "智能售卖", this);
        UIUtil.setStautsBar(this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        listview = findViewById(R.id.listview);
        list = new ArrayList<IntelligentSaleEntity>();

        for (int i = 0; i < 4; i++) {
            IntelligentSaleEntity entity = new IntelligentSaleEntity();
            entity.setIshot(true);
            entity.setPro_mark("超低价热销款，爆款推荐，超实惠月租金");
            entity.setPro_name("飞艇摇摇车 （儿童）");
            entity.setPro_price("¥98.00");
            list.add(entity);
        }
        IntelligentSaleAdapter adapter = new IntelligentSaleAdapter(list, this);
        listview.setAdapter(adapter);

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
