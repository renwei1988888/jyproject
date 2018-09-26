package com.merchant.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.merchant.R;
import com.merchant.activities.BusinessAnlysisActivity;
import com.merchant.activities.BusinessDiagnosisActivity;
import com.merchant.activities.BusinessSettingActivity;
import com.merchant.activities.CustomerAnlysisActivity;
import com.merchant.activities.CustomerPortraitActivity;
import com.merchant.activities.HomeFragmentActivity;
import com.merchant.activities.IntelligentSaleActivity;
import com.merchant.activities.MyWalletActivity;
import com.merchant.utils.UIUtil;
import com.merchant.utils.ViewParamsSetUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/188:59
 * desc   : 经营
 * version: 1.0
 */
public class ManagementFragment extends Fragment implements View.OnClickListener {

    private LinearLayout lin_bus_anlysis, lin_bus_customer_anlysis, lin_bus_mywallet, lin_bus_setting,
            lin_bus_intelligentsale, lin_bus_diagnosis, lin_bus_customer_portrait, lin_toreport, lin_toloan,
            lin_toschool, middle_ll, bottom_ll;

    private RelativeLayout top_rl;

    private Intent intent;

    private HomeFragmentActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_management, container, false);
        findViewAndInit(v);
        return v;
    }

    private void findViewAndInit(View v) {
        mActivity = (HomeFragmentActivity) getActivity();
        UIUtil.setStautsBar(mActivity);

        lin_bus_anlysis = v.findViewById(R.id.lin_bus_anlysis);
        lin_bus_customer_anlysis = v.findViewById(R.id.lin_bus_customer_anlysis);
        lin_bus_mywallet = v.findViewById(R.id.lin_bus_mywallet);
        lin_bus_setting = v.findViewById(R.id.lin_bus_setting);
        lin_bus_intelligentsale = v.findViewById(R.id.lin_bus_intelligentsale);
        lin_bus_diagnosis = v.findViewById(R.id.lin_bus_diagnosis);
        lin_bus_customer_portrait = v.findViewById(R.id.lin_bus_customer_portrait);
        lin_toreport = v.findViewById(R.id.lin_toreport);
        lin_toloan = v.findViewById(R.id.lin_toloan);
        lin_toschool = v.findViewById(R.id.lin_toschool);

        top_rl = v.findViewById(R.id.top_rl);
        middle_ll = v.findViewById(R.id.middle_ll);
        bottom_ll = v.findViewWithTag(R.id.bottom_ll);
        ViewParamsSetUtil.setViewHight(top_rl, 0.3f, mActivity);
        ViewParamsSetUtil.setViewHight(middle_ll, 0.28f, mActivity);
        ViewParamsSetUtil.setViewHight(bottom_ll, 0.3f, mActivity);

        lin_bus_anlysis.setOnClickListener(this);
        lin_bus_customer_anlysis.setOnClickListener(this);
        lin_bus_mywallet.setOnClickListener(this);
        lin_bus_setting.setOnClickListener(this);
        lin_bus_intelligentsale.setOnClickListener(this);
        lin_bus_diagnosis.setOnClickListener(this);
        lin_bus_customer_portrait.setOnClickListener(this);
        lin_toreport.setOnClickListener(this);
        lin_toloan.setOnClickListener(this);
        lin_toschool.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_bus_anlysis:
                intent = new Intent(mActivity, BusinessAnlysisActivity.class);
                startActivity(intent);
                mActivity.overTransition(2);
                break;
            case R.id.lin_bus_customer_anlysis:
                intent = new Intent(mActivity, CustomerAnlysisActivity.class);
                startActivity(intent);
                mActivity.overTransition(2);
                break;
            case R.id.lin_bus_mywallet:
                intent = new Intent(mActivity, MyWalletActivity.class);
                startActivity(intent);
                mActivity.overTransition(2);
                break;
            case R.id.lin_bus_setting:
                intent = new Intent(mActivity, BusinessSettingActivity.class);
                startActivity(intent);
                mActivity.overTransition(2);
                break;
            case R.id.lin_bus_intelligentsale:
                intent = new Intent(mActivity, IntelligentSaleActivity.class);
                startActivity(intent);
                mActivity.overTransition(2);
                break;
            case R.id.lin_bus_diagnosis:
                intent = new Intent(mActivity, BusinessDiagnosisActivity.class);
                startActivity(intent);
                mActivity.overTransition(2);
                break;
            case R.id.lin_bus_customer_portrait:
                intent = new Intent(mActivity, CustomerPortraitActivity.class);
                startActivity(intent);
                mActivity.overTransition(2);
                break;
            case R.id.lin_toreport:
                intent = new Intent(mActivity, BusinessDiagnosisActivity.class);
                startActivity(intent);
                mActivity.overTransition(2);
                break;
            case R.id.lin_toloan:
                intent = new Intent(mActivity, BusinessDiagnosisActivity.class);
                startActivity(intent);
                mActivity.overTransition(2);
                break;
            case R.id.lin_toschool:
                intent = new Intent(mActivity, BusinessDiagnosisActivity.class);
                startActivity(intent);
                mActivity.overTransition(2);
                break;
            default:
                break;
        }

    }
}
