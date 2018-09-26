package com.merchant.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.entity.IntelligentSaleEntity;

import java.util.List;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/1815:08
 * desc   : 智能售卖适配器
 * version: 1.0
 */
public class IntelligentSaleAdapter extends MyBaseAdapter {

    private Activity mActivity;
    private List<IntelligentSaleEntity> lists;

    public IntelligentSaleAdapter(List<IntelligentSaleEntity> lists, Activity context) {
        super(lists, context);
        this.mActivity = context;
        this.lists = lists;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HoldView hold = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_intelligentsale_item, null);
            hold = new HoldView(convertView);
            convertView.setTag(hold);
        } else {
            hold = (HoldView) convertView.getTag();
        }
        IntelligentSaleEntity model = lists.get(position);

        hold.product_img.setImageDrawable(null);
        hold.pro_name.setText(model.getPro_name());
        hold.pro_mark.setText(model.getPro_mark());
        hold.pro_price.setText(model.getPro_price());

        if (position == 0) {
            hold.product_img.setImageDrawable(mActivity.getResources().getDrawable(R.mipmap.intelligentsale_itemone_img));
            hold.ishot_tv.setVisibility(View.VISIBLE);
            hold.ishot_tv.setText("Hot");
        } else if (position == 1)
            hold.product_img.setImageDrawable(mActivity.getResources().getDrawable(R.mipmap.intelligentsale_itemtwo_img));
        else if (position == 2)
            hold.product_img.setImageDrawable(mActivity.getResources().getDrawable(R.mipmap.intelligentsale_itemthree_img));
        else
            hold.product_img.setImageDrawable(mActivity.getResources().getDrawable(R.mipmap.intelligentsale_itemfour_img));

        return convertView;
    }

    class HoldView {
        ImageView product_img;
        TextView pro_name, pro_mark, pro_price, ishot_tv;

        public HoldView(View v) {
            product_img = v.findViewById(R.id.product_img);
            ishot_tv = v.findViewById(R.id.ishot_tv);
            pro_name = v.findViewById(R.id.pro_name);
            pro_mark = v.findViewById(R.id.pro_mark);
            pro_price = v.findViewById(R.id.pro_price);
        }

    }
}
