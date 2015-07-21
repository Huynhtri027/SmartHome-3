package com.gdgl.util;

import com.gdgl.smarthome.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyOKOnlyDlg {
	Context context;
	Dialog dialog;
	Button sure;
	TextView textView;
	Dialogcallback dialogcallback;
	boolean cannotCancele = false;
	
	public MyOKOnlyDlg(Context con) {
		this.context = con;
		dialog = new Dialog(context, R.style.MyDialog);
		dialog.setContentView(R.layout.ok_only_dlg);
		textView = (TextView) dialog.findViewById(R.id.txt_title);
		sure = (Button) dialog.findViewById(R.id.btn_ok);
		sure.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(cannotCancele) {
					dialogcallback.dialogdo();
				}
				dismiss();
			}
		});
	}
	
	public interface Dialogcallback {
		public void dialogdo();
	}

	public void setDialogCallback(Dialogcallback dialogcallback) {
		this.dialogcallback = dialogcallback;
	}
	
	public void setCannotCanceled() {
		cannotCancele = true;
		dialog.setCancelable(false);
		dialog.setCanceledOnTouchOutside(false);
	}
	
	public void setContent(String content) {
		textView.setText(content);
	}
	
	public void show() {
		dialog.show();
	}

	public void hide() {
		dialog.hide();
	}

	public void dismiss() {
		dialog.dismiss();
	}
}
