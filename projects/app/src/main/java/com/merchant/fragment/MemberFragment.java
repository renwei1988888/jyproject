package com.merchant.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.merchant.R;
import com.merchant.activities.BaseFragmentActivity;
import com.merchant.activities.HomeFragmentActivity;
import com.merchant.utils.UIUtil;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/188:57
 * desc   : 会员
 * version: 1.0
 */
public class MemberFragment extends Fragment implements View.OnClickListener {

    private HomeFragmentActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_member, container, false);
        findViewAndInit(v);
        return v;
    }

    private void findViewAndInit(View v) {
        mActivity = (HomeFragmentActivity) getActivity();
        UIUtil.setStautsBar(mActivity);

    }

    @Override
    public void onClick(View v) {

    }
}
