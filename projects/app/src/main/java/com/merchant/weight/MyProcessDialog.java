package com.merchant.weight;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.merchant.R;


/**
 * 加载对话框
 * 
 * @author renwei
 */
public class MyProcessDialog extends Dialog {
	public MyProcessDialog(Context context, String str) {
		super(context, R.style.MyProgressDialog);
		this.setContentView(R.layout.progress_dialog);
		TextView text = (TextView) this.findViewById(R.id.txt_wait);
		text.setText(str);
	}
}
