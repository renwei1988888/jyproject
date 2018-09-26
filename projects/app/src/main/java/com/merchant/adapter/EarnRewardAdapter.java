package com.merchant.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.merchant.R;
import com.merchant.entity.EarnRewardEntity;

import java.util.List;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/1814:32
 * desc   :  赚钱赏金适配器
 * version: 1.0
 */
public class EarnRewardAdapter extends MyBaseAdapter {

    private Activity mActivity;
    private List<EarnRewardEntity> lists;

    public EarnRewardAdapter(List<EarnRewardEntity> lists, Activity context) {
        super(lists, context);
        this.mActivity = context;
        this.lists = lists;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HoldView hold = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_earnreward_item, null);
            hold = new HoldView(convertView);
            convertView.setTag(hold);
        } else {
            hold = (HoldView) convertView.getTag();
        }
        EarnRewardEntity model = lists.get(position);
        hold.shopname_tv.setText(model.getShopname());
        hold.rewardamount_tv.setText(model.getRewardamount());
        if (position == 0) {
            hold.pm_img.setImageDrawable(null);
        } else if (position == 1) {
            hold.pm_img.setImageDrawable(null);
        } else if (position == 2) {
            hold.pm_img.setImageDrawable(null);
        } else {
            hold.pm_img.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }

    class HoldView {
        ImageView pm_img;
        TextView shopname_tv, rewardamount_tv;

        public HoldView(View v) {
            pm_img = (ImageView) v.findViewById(R.id.pm_img);
            shopname_tv = (TextView) v.findViewById(R.id.shopname_tv);
            rewardamount_tv = (TextView) v.findViewById(R.id.rewardamount_tv);
        }

    }
}
