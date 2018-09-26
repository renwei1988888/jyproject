package com.merchant.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.HeaderViewControler;
import com.merchant.utils.TextUtil;
import com.merchant.utils.UIUtil;
import com.merchant.weight.PwdKeyboardView;

/**
 * @name renwei
 * @time 2018/9/24 10:58
 * @class 找回密码-设置新的密码
 */
public class PayPwdFindSetNewPwdActivity extends BaseActivity implements View.OnClickListener {

    private EditText one_edt, two_edt, three_edt, four_edt, five_edt, six_edt;
    private String onep, twop, threep, fourp, fivep, sixp,
            onepp, twopp, threepp, fourpp, fivepp, sixpp, password;
    private TextView pwddes_tv, suggesiondes_tv;
    private PwdKeyboardView keyboardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypwdfindsetnewpwd);

        findViewAndInit();
    }

    private void findViewAndInit() {
        HeaderViewControler.setHeaderView(this, "身份认证", this);
        UIUtil.setColor(this, getResources().getColor(R.color.black));

        keyboardView = findViewById(R.id.key_board);
        one_edt = findViewById(R.id.one_edt);
        two_edt = findViewById(R.id.two_edt);
        three_edt = findViewById(R.id.three_edt);
        four_edt = findViewById(R.id.four_edt);
        five_edt = findViewById(R.id.five_edt);
        six_edt = findViewById(R.id.six_edt);
        pwddes_tv = findViewById(R.id.pwddes_tv);
        suggesiondes_tv = findViewById(R.id.suggesiondes_tv);

        password = "";
        keyboardView.setOnKeyListener(new PwdKeyboardView.OnKeyListener() {
            @Override
            public void onInput(String text) {
                password = password + text;
                if (TextUtil.isEmpty(onep)) {
                    one_edt.setText(text);
                    one_edt.setEnabled(false);
                    onep = text;
                    two_edt.setFocusable(false);
                    two_edt.setFocusableInTouchMode(true);
                    two_edt.requestFocus();
                } else if (TextUtil.isEmpty(twop)) {
                    two_edt.setText(text);
                    two_edt.setEnabled(false);
                    twop = text;
                    three_edt.setFocusable(false);
                    three_edt.setFocusableInTouchMode(true);
                    three_edt.requestFocus();
                } else if (TextUtil.isEmpty(threep)) {
                    three_edt.setText(text);
                    three_edt.setEnabled(false);
                    threep = text;
                    four_edt.setFocusable(false);
                    four_edt.setFocusableInTouchMode(true);
                    four_edt.requestFocus();
                } else if (TextUtil.isEmpty(fourp)) {
                    four_edt.setText(text);
                    four_edt.setEnabled(false);
                    fourp = text;
                    five_edt.setFocusable(false);
                    five_edt.setFocusableInTouchMode(true);
                    five_edt.requestFocus();
                } else if (TextUtil.isEmpty(fivep)) {
                    five_edt.setText(text);
                    five_edt.setEnabled(false);
                    fivep = text;
                    six_edt.setFocusable(false);
                    six_edt.setFocusableInTouchMode(true);
                    six_edt.requestFocus();
                } else if (TextUtil.isEmpty(sixp)) {
                    six_edt.setText(text);
                    six_edt.setEnabled(false);
                    sixp = text;

                    // 当最后一个数字输入完成后，进行下一步操作
                    pwddes_tv.setText(getResources().getString(R.string.withdrawpwd_confirm));
                    suggesiondes_tv.setVisibility(View.VISIBLE);
                    one_edt.setText("");
                    two_edt.setText("");
                    three_edt.setText("");
                    four_edt.setText("");
                    five_edt.setText("");
                    six_edt.setText("");

                    one_edt.setEnabled(true);
                    two_edt.setEnabled(true);
                    three_edt.setEnabled(true);
                    four_edt.setEnabled(true);
                    five_edt.setEnabled(true);
                    six_edt.setEnabled(true);

                    one_edt.setFocusable(false);
                    one_edt.setFocusableInTouchMode(true);
                    one_edt.requestFocus();
                } else {
                    if (TextUtil.isEmpty(onepp)) {
                        one_edt.setText(text);
                        one_edt.setEnabled(false);
                        onepp = text;
                        two_edt.setFocusable(false);
                        two_edt.setFocusableInTouchMode(true);
                        two_edt.requestFocus();
                    } else if (TextUtil.isEmpty(twopp)) {
                        two_edt.setText(text);
                        two_edt.setEnabled(false);
                        twopp = text;
                        three_edt.setFocusable(false);
                        three_edt.setFocusableInTouchMode(true);
                        three_edt.requestFocus();
                    } else if (TextUtil.isEmpty(threepp)) {
                        three_edt.setText(text);
                        three_edt.setEnabled(false);
                        threepp = text;
                        four_edt.setFocusable(false);
                        four_edt.setFocusableInTouchMode(true);
                        four_edt.requestFocus();
                    } else if (TextUtil.isEmpty(fourpp)) {
                        four_edt.setText(text);
                        four_edt.setEnabled(false);
                        fourpp = text;
                        five_edt.setFocusable(false);
                        five_edt.setFocusableInTouchMode(true);
                        five_edt.requestFocus();
                    } else if (TextUtil.isEmpty(fivepp)) {
                        five_edt.setText(text);
                        five_edt.setEnabled(false);
                        fivepp = text;
                        six_edt.setFocusable(false);
                        six_edt.setFocusableInTouchMode(true);
                        six_edt.requestFocus();
                    } else if (TextUtil.isEmpty(sixpp)) {
                        six_edt.setText(text);
                        six_edt.setEnabled(false);
                        sixpp = text;

                        // 当最后一个数字输入完成后，进行下一步操作
                        pwddes_tv.setText(getResources().getString(R.string.withdrawpwd_confirm));
                        suggesiondes_tv.setVisibility(View.VISIBLE);
                        one_edt.setText("");
                        two_edt.setText("");
                        three_edt.setText("");
                        four_edt.setText("");
                        five_edt.setText("");
                        six_edt.setText("");

                        one_edt.setEnabled(true);
                        two_edt.setEnabled(true);
                        three_edt.setEnabled(true);
                        four_edt.setEnabled(true);
                        five_edt.setEnabled(true);
                        six_edt.setEnabled(true);

                        one_edt.setFocusable(false);
                        one_edt.setFocusableInTouchMode(true);
                        one_edt.requestFocus();
                    } else {
                        finish();
                        overTransition(1);
                    }
                }
            }

            @Override
            public void onDelete() {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case HeaderViewControler.ID:// 返回
                finish();
                overTransition(1);
                break;
            default:
                break;
        }
    }

}
