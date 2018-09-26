package com.merchant.weight;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.merchant.R;
import com.merchant.utils.ViewParamsSetUtil;


/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/710:53
 * desc   : 自定义dialog管理-仿苹果的白色dialog
 * version: 1.0
 */
public class DialogManager implements View.OnClickListener {
    /**
     * 取消按钮
     */
    public final static int CANCEL_BTN = R.id.tv_dialog_cancel;
    /**
     * 确定按钮
     */
    public final static int CONFIRM_BTN = R.id.tv_dialog_confirm;

    private Dialog mDialog;
    private TextView tv_dialog_cancel, tv_dialog_confirm;
    private TextView tv_dialog_title, tv_dialog_content, tv_dialog_other;
    private ImageView img;
    private OnButListener butListener;
    private Context context;

    public DialogManager(Context context) {
        this.context = context;
    }

    @SuppressLint("InflateParams")
    public void initTwoBtnDialog(View.OnClickListener listener) {
        mDialog = new Dialog(context, R.style.m_dialogstyle);
        mDialog.setCanceledOnTouchOutside(true);
        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

            @Override
            public void onDismiss(DialogInterface dialog) {
            }
        });

        View view = LayoutInflater.from(context).inflate(
                R.layout.dialog_twobtn_white_layout, null);
        // 标题和内容
        tv_dialog_title = (TextView) view.findViewById(R.id.tv_dialog_title);
        tv_dialog_content = (TextView) view
                .findViewById(R.id.tv_dialog_content);
        // 取消按钮
        tv_dialog_cancel = (TextView) view.findViewById(R.id.tv_dialog_cancel);
        // 图片
        img = (ImageView) view.findViewById(R.id.img);
        img.setVisibility(View.GONE);

        // 确定按钮
        tv_dialog_confirm = (TextView) view
                .findViewById(R.id.tv_dialog_confirm);

        if (listener != null) {
            tv_dialog_cancel.setOnClickListener(listener);
            tv_dialog_confirm.setOnClickListener(listener);
        } else {
            tv_dialog_cancel.setOnClickListener(this);
            tv_dialog_confirm.setOnClickListener(this);
        }

        mDialog.setContentView(view);

        // Window dialogWindow = mDialog.getWindow();
        // dialogWindow.setGravity(Gravity.CENTER);
        // WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        // lp.width = (int) (ScreenUtils.getScreenWidth(mActivity) * 0.8);
        // lp.y = hight;
        // dialogWindow.setAttributes(lp);
        ViewParamsSetUtil.setDialogPosition(mDialog);

    }

    /**
     * @param cancel   - 取消按钮的文字
     * @param confirm  - 确定按钮的文字
     * @param Title    - 标题
     * @param Content  - 内容
     * @param listener - 点击监听，可以传null
     */
    public void initTwoBtnDialog(CharSequence cancel, CharSequence confirm,
                                 CharSequence Title, CharSequence Content, View.OnClickListener listener) {
        initTwoBtnDialog(listener);
        tv_dialog_title.setText(Title);
        tv_dialog_content.setText(Content);
        tv_dialog_confirm.setText(confirm);
        tv_dialog_cancel.setText(cancel);
        Show();
    }

    /**
     * @param Content           内容
     * @param onDismissListener
     */
    public void initOneBtnDialog(CharSequence Content,
                                 DialogInterface.OnDismissListener onDismissListener) {
        initOneBtnDialog("确定", "提示", Content, onDismissListener);
    }

    /**
     * @param icon              true 正确的图标
     * @param Content           内容
     * @param onDismissListener
     */
    public void initOneBtnDialog(boolean icon, CharSequence Content, DialogInterface.OnDismissListener onDismissListener) {
        initOneBtnDialog("确定", "提示", Content, onDismissListener);
        if (icon) {
            // img.setImageResource(R.drawable.tishzq_28x28);
        } else {
            //img.setImageResource(R.drawable.icon_ts_img);
        }
        img.setVisibility(View.VISIBLE);
    }


    public void initOneBtnDialog(boolean icon, CharSequence Title, CharSequence Content, DialogInterface.OnDismissListener onDismissListener) {
        initOneBtnDialog("确定", Title, Content, onDismissListener);
        if (icon) {
            //img.setImageResource(R.drawable.tishzq_28x28);
        } else {
            //img.setImageResource(R.drawable.icon_ts_img);
        }
        img.setVisibility(View.VISIBLE);
    }

    public void initTwoBtnDialog(boolean icon, CharSequence cancel,
                                 CharSequence confirm, CharSequence Title, CharSequence Content,
                                 View.OnClickListener listener) {
        initTwoBtnDialog(cancel, confirm, Title, Content, listener);
        if (icon) {
            //img.setImageResource(R.drawable.tishzq_28x28);
        } else {
            //img.setImageResource(R.drawable.icon_ts_img);
        }
        img.setVisibility(View.VISIBLE);
    }

    public void initTwoBtnDialog(int rid, CharSequence cancel,
                                 CharSequence confirm, CharSequence Title, CharSequence Content,
                                 View.OnClickListener listener) {
        initTwoBtnDialog(cancel, confirm, Title, Content, listener);
        img.setImageResource(rid);
        img.setVisibility(View.VISIBLE);
    }

    /**
     * 一个按钮的mDialog
     *
     * @param confirm           -按钮的内容
     * @param Title             - 标题
     * @param Content           - 内容信息
     * @param onDismissListener - 取消监听,，可以传null
     */
    public void initOneBtnDialog(CharSequence confirm, CharSequence Title,
                                 CharSequence Content, DialogInterface.OnDismissListener onDismissListener) {
        initOneBtnDialog();

        if (onDismissListener != null) {
            mDialog.setOnDismissListener(onDismissListener);
        }

        tv_dialog_title.setText(Title);
        tv_dialog_content.setText(Content);
        tv_dialog_confirm.setText(confirm);
        Show();
    }

    /*结果提示小弹窗*/
    public void initNoBtnLittleDialog(CharSequence Title) {
        initNoBtnLittleDialog();
        tv_dialog_content.setText(Title);
        Show();
    }

    /**
     * 没有按钮的mDialog
     *
     * @param confirm -按钮的内容
     * @param Title   - 标题
     * @param Content - 内容信息
     * @param other   - 取消监听,，可以传null
     */
    public void initNoBtnDialog(CharSequence confirm, CharSequence Title,
                                CharSequence Content, CharSequence other) {
        initNoBtnDialog();

        tv_dialog_title.setText(Title);
        tv_dialog_content.setText(Content);
        tv_dialog_other.setText(other);
        Show();
    }

    public void initOneBtnDialog(CharSequence confirm, CharSequence Title,
                                 CharSequence Content, DialogInterface.OnDismissListener onDismissListener,
                                 View.OnClickListener l) {
        initOneBtnDialog();

        if (l != null) {
            tv_dialog_confirm.setOnClickListener(l);
        }

        tv_dialog_title.setText(Title);
        tv_dialog_content.setText(Content);
        tv_dialog_confirm.setText(confirm);
        Show();
    }

    @SuppressLint("InflateParams")
    public void initOneBtnDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        mDialog = new Dialog(context, R.style.m_dialogstyle);
        mDialog.setCanceledOnTouchOutside(true);
        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

            @Override
            public void onDismiss(DialogInterface dialog) {
            }
        });

        View view = LayoutInflater.from(context).inflate(
                R.layout.dialog_onebtn_white_layout, null);
        // 标题和内容
        tv_dialog_title = (TextView) view.findViewById(R.id.tv_dialog_title);
        tv_dialog_content = (TextView) view
                .findViewById(R.id.tv_dialog_content);
        // 确定按钮
        tv_dialog_confirm = (TextView) view
                .findViewById(R.id.tv_dialog_confirm);
        tv_dialog_confirm.setOnClickListener(this);
        // 图片
        img = (ImageView) view.findViewById(R.id.img);
        img.setVisibility(View.GONE);

        mDialog.setContentView(view);

        // Window dialogWindow = mDialog.getWindow();
        // dialogWindow.setGravity(Gravity.CENTER);
        // WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        // lp.width = (int) (ScreenUtils.getScreenWidth(mActivity) * 0.8);
        // lp.y = hight;
        // dialogWindow.setAttributes(lp);
        ViewParamsSetUtil.setDialogPosition(mDialog);
    }

    public void initNoBtnLittleDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        mDialog = new Dialog(context, R.style.m_littledialogstyle);
        mDialog.setCanceledOnTouchOutside(true);
        mDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

            @Override
            public void onDismiss(DialogInterface dialog) {
            }
        });

        View view = LayoutInflater.from(context).inflate(
                R.layout.dialog_nobtn_white_layout, null);
        // 设置提示内容
        tv_dialog_content = (TextView) view
                .findViewById(R.id.tv_dialog_content);
        mDialog.setContentView(view);
        ViewParamsSetUtil.setLittleDialogPosition(mDialog);
    }

    @SuppressLint("InflateParams")
    public void initNoBtnDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        mDialog = new Dialog(context, R.style.m_dialogstyle);
        mDialog.setCanceledOnTouchOutside(true);
        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

            @Override
            public void onDismiss(DialogInterface dialog) {
            }
        });

        View view = LayoutInflater.from(context).inflate(
                R.layout.dialog_nobtn_white_layout, null);
        // 标题和内容
        tv_dialog_content = (TextView) view
                .findViewById(R.id.tv_dialog_content);

        mDialog.setContentView(view);

        // Window dialogWindow = mDialog.getWindow();
        // dialogWindow.setGravity(Gravity.CENTER);
        // WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        // lp.width = (int) (ScreenUtils.getScreenWidth(mActivity) * 0.8);
        // lp.y = hight;
        // dialogWindow.setAttributes(lp);
        ViewParamsSetUtil.setDialogPosition(mDialog);
    }

    /**
     * 确定按钮的点击监听
     *
     * @param listener
     */
    public void setConfirmBitOnClickListener(View.OnClickListener listener) {
        if (tv_dialog_confirm != null) {
            tv_dialog_confirm.setOnClickListener(listener);
        }
    }

    /**
     * 设置提示文字
     *
     * @param Title   标题
     * @param Content 内容
     */
    public void setTitleandContent(CharSequence Title, CharSequence Content) {
        if (tv_dialog_title != null) {
            tv_dialog_title.setText(Title);
        }
        if (tv_dialog_content != null) {
            tv_dialog_content.setText(Content);
        }

    }

    /**
     * 设置按钮的文字
     *
     * @param cancel  取消
     * @param confirm 查看
     */
    public void setButText(CharSequence cancel, CharSequence confirm) {
        if (tv_dialog_cancel != null) {
            tv_dialog_cancel.setText(cancel);
        }
        if (tv_dialog_confirm != null) {
            tv_dialog_confirm.setText(confirm);
        }
    }

    /**
     * 设置按钮的文字
     *
     * @param confirm 确定
     */
    public void setButText(CharSequence confirm) {
        if (tv_dialog_confirm != null) {
            tv_dialog_confirm.setText(confirm);
        }
    }

    /**
     * mDialog 取消完成后的监听
     *
     * @param listener
     */
    public void setOnDismissListener(DialogInterface.OnDismissListener listener) {
        if (mDialog != null) {
            mDialog.setOnDismissListener(listener);
        }
    }

    public void Show() {
        if (mDialog != null && !mDialog.isShowing()) {
            try {// 抓捕异常，防止程序崩溃
                mDialog.show();
            } catch (Exception e) {
            }
        }
    }

    /**
     * 自定义的按钮点击监听
     *
     * @param butListener
     */
    public void setOnButListener(OnButListener butListener) {
        this.butListener = butListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_dialog_cancel:
                if (mDialog != null && mDialog.isShowing()) {
                    mDialog.dismiss();
                }

                if (butListener != null) {
                    butListener.dialogCancel();
                }

                break;
            case R.id.tv_dialog_confirm:
                if (mDialog != null && mDialog.isShowing()) {
                    mDialog.dismiss();
                }

                if (butListener != null) {
                    butListener.dialogConfirm();
                }

                break;

            default:
                break;
        }

    }

    public void dismiss() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    /**
     * 设置点击外部是否取消
     *
     * @param bol           点击外部是否取消
     * @param iskeylistener 是否屏蔽掉返回键监听
     */
    public void setCanceledOnTouchOutside(boolean bol, boolean iskeylistener) {
        if (mDialog != null) {
            mDialog.setCanceledOnTouchOutside(bol);
            if (iskeylistener) {
                mDialog.setOnKeyListener(keylistener);
            }
        }
    }

    /**
     * 返回键监听，屏蔽掉按返回键Dialog消失
     */
    private DialogInterface.OnKeyListener keylistener = new DialogInterface.OnKeyListener() {
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                return true;
            } else {
                return false;
            }
        }
    };

    public Dialog getmDialog() {
        return mDialog;
    }

    public TextView getTv_dialog_cancel() {
        return tv_dialog_cancel;
    }

    public TextView getTv_dialog_confirm() {
        return tv_dialog_confirm;
    }

    public TextView getTv_dialog_title() {
        return tv_dialog_title;
    }

    public TextView getTv_dialog_content() {
        return tv_dialog_content;
    }

    public interface OnButListener {
        /**
         * 点击取消按钮时需要进行的操作
         */
        public void dialogCancel();

        /**
         * 点击确定按钮时需要进行的操作
         */
        public void dialogConfirm();
    }
}
