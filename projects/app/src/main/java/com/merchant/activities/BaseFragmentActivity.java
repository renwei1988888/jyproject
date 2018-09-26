package com.merchant.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.merchant.R;
import com.merchant.services.DataFetchService;
import com.merchant.utils.AppController;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/810:07
 * desc   : Fragment基础类
 * version: 1.0
 */
public class BaseFragmentActivity extends FragmentActivity {

    protected DataFetchService dft;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppController.listActivity.add(this);
        context = this.getBaseContext();
        dft = new DataFetchService(context);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppController.listActivity.remove(this);
    }

    /**
     * 定义窗口进出方式
     * @param sty int型 1为左进右出，2为右进左出
     */
    public void overTransition(int sty)
    {
        switch (sty)
        {
            case 1:
                overridePendingTransition(R.anim.trans_lift_in, R.anim.trans_right_out);
                break;
            case 2:
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_lift_out);
                break;
            default:
                break;
        }
    }

    public DataFetchService getDft(){
        return this.dft;
    }
}
