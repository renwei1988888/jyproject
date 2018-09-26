package com.merchant.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.merchant.R;
import com.merchant.fragment.ManagementFragment;
import com.merchant.fragment.MarketingFragment;
import com.merchant.fragment.MemberFragment;
import com.merchant.fragment.ReceivablesFragment;
import com.merchant.utils.AppController;
import com.merchant.utils.SharedPreferencesUtil;
import com.merchant.weight.FooterView;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/810:11
 * desc   : Fragment主页
 * version: 1.0
 */
public class HomeFragmentActivity extends BaseFragmentActivity implements View.OnClickListener {

    private int tab = 3;
    private Context context;
    private FooterView footerView;
    private ManagementFragment managementFragment;
    private MemberFragment memberFragment;
    private ReceivablesFragment receivablesFragment;
    private MarketingFragment marketingFragment;
    private Intent intent;
    private Fragment[] fragments;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homefragment);
        context = getBaseContext();
        findViewandInit();
        setUIData();
    }

    private void findViewandInit() {
        fragments = new Fragment[4];
        // 设置底部导航栏
        footerView = (FooterView) findViewById(R.id.mFooterView);
        footerView.setOnClickmListener(this);
        intent = getIntent();
        if (intent != null) {
            tab = intent.getIntExtra("tab", 3);
        }
        footerView.setFooterTab(tab);
    }

    private void setUIData() {
        footerView.setFooterTab(tab);
        if (tab > 3) {
            footerView.setFooterTab(tab - 1);
        } else {
            footerView.setFooterTab(tab);
        }
        setFragment();
    }

    /**
     * 设置与tab相关的Fragment
     */
    private void setFragment() {
        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (fragments[tab] == null) {
            if (tab == 0) {
                if (receivablesFragment == null) {
                    receivablesFragment = new ReceivablesFragment();
                }
                fragments[tab] = receivablesFragment;
                transaction.add(R.id.id_content, fragments[tab]);
            } else if (tab == 1) {
                if (marketingFragment == null) {
                    marketingFragment = new MarketingFragment();
                }
                fragments[tab] = marketingFragment;
                transaction.add(R.id.id_content, fragments[tab]);
            } else if (tab == 2) {
                if (memberFragment == null) {
                    memberFragment = new MemberFragment();
                }
                fragments[tab] = memberFragment;
                transaction.add(R.id.id_content, fragments[tab]);
            } else if (tab == 3) {
                if (managementFragment == null) {
                    managementFragment = new ManagementFragment();
                }
                fragments[tab] = managementFragment;
                transaction.add(R.id.id_content, fragments[tab]);
            }
        }
        for (int i = 0; i < fragments.length; i++) {
            if (fragments[i] != null) {
                if (i == tab) {
                    transaction.show(fragments[i]);
                } else {
                    transaction.hide(fragments[i]);
                }
            }
        }
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_receivables:// 首页
                if (tab != 0) {
                    tab = 0;
                    setUIData();
                }
                break;
            case R.id.lin_marketing:
                if (tab != 1) {
                    tab = 1;
                    setUIData();
                }
                break;
            case R.id.lin_member:
                if (tab != 2) {
                    tab = 2;
                    setUIData();
                }
                break;
            case R.id.lin_management:
                if (tab != 3) {
                    tab = 3;
                    setUIData();
                }
                break;
            default:
                break;
        }

    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                default:
                    break;
            }
        }

        ;
    };

    public void ChangeFragment(int tab) {
        this.tab = tab;
        setUIData();
    }

    public int getTab() {
        return this.tab;
    }

    /**
     * 退出当前Fragment
     */
    public void finishFragment() {
        if (tab == 0) {
            return;
        }
        if (fragments[tab] != null) {
            fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.remove(fragments[tab]);
            // transaction.commit();
            transaction.commitAllowingStateLoss();
            fragments[tab] = null;
            if (tab == 1) {
                receivablesFragment = null;
            } else if (tab == 2) {
            } else if (tab == 3) {
            }
        }
        tab = 0;
        setUIData();

    }

    @Override
    protected void onResumeFragments() {// 此方法可以避免状态丢失
        // 无效的用户名时的操作
//        if (tab == 3 && SharedPreferencesUtil.getResult_AuthToken(context).length() == 0) {
//            signOut();
//        }
        super.onResumeFragments();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        // Activity以singleTask模式启动，intent传值的解决办法
        super.onNewIntent(intent);
        setIntent(intent);
        getIntent().putExtras(intent);
    }

    /**
     * 退出我的账户
     */
    public void signOut() {
        if (fragments[2] != null) {
            fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.remove(fragments[2]);
            transaction.commitAllowingStateLoss();
            // transaction.commitAllowingStateLoss();
            receivablesFragment = null;
            fragments[2] = null;
        }
        tab = 4;
        setUIData();
    }

    private long exitTime = 0;

    /**
     * 返回键监听，按两次返回键退出程序
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                for (Activity activity : AppController.listActivity) {
                    activity.finish();
                }
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public Handler getmHandler() {
        return mHandler;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
