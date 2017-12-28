package com.ludvk.activity.dialog;

import com.ludvk.activity.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class TextViewAlertDialog extends Dialog {

    private Context context;
    private View mainView;
    private View.OnClickListener onClickListener;
    private String title, message, leftBtnString, rightBtnString;
   
    
    public TextViewAlertDialog(Context context, String title, String leftBtnString, String rightBtnString, String message, View.OnClickListener onClickListener) {
        super(context, R.style.TextViewAlertDialog);
        this.context = context;
        this.title = title;
        this.message = message;
        this.leftBtnString = leftBtnString;
        this.rightBtnString = rightBtnString;
        this.onClickListener = onClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainView = LayoutInflater.from(context).inflate(R.layout.textview_dialog, null);

        int width = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.9);
        this.setContentView(mainView, new LayoutParams(width, LayoutParams.WRAP_CONTENT));

        TextView btn_left = (TextView) findViewById(R.id.dialogLeftBtn);
        TextView btn_right = (TextView) findViewById(R.id.dialogRightBtn);
        TextView titleText = (TextView) findViewById(R.id.dialogTitle);
        TextView messageText = (TextView) findViewById(R.id.dialogMessage);
        if (title != null) {
            titleText.setVisibility(View.VISIBLE);
            titleText.setText(title);
        } else {
            titleText.setVisibility(View.GONE);
        }
        if (message != null) {
            messageText.setVisibility(View.VISIBLE);
            messageText.setText(message);
        } else {
            messageText.setVisibility(View.GONE);
        }
        if (leftBtnString != null) {
            btn_left.setVisibility(View.VISIBLE);
            btn_left.setText(leftBtnString);
        } else {
            btn_left.setVisibility(View.GONE);
        }
        if (rightBtnString != null) {
            btn_right.setVisibility(View.VISIBLE);
            btn_right.setText(rightBtnString);
        } else {
            btn_right.setVisibility(View.GONE);
        }
        btn_left.setOnClickListener(onClickListener);
        btn_right.setOnClickListener(onClickListener);
    }
}