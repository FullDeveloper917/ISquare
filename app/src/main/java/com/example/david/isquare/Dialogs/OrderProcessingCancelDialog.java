package com.example.david.isquare.Dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;

/**
 * Created by David on 10/5/2017.
 */

public class OrderProcessingCancelDialog extends Dialog implements android.view.View.OnClickListener{
    public MainActivity activity;
    public Button btnYes, btnNo;

    public OrderProcessingCancelDialog(MainActivity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_order_processing_cancel);
        btnYes= (Button) findViewById(R.id.btnYes_OrderProcessingCancelDialog);
        btnNo = (Button) findViewById(R.id.btnNo_OrderProcessingCancelDialog);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNo_OrderProcessingCancelDialog:
                dismiss();
                break;
            case R.id.btnYes_OrderProcessingCancelDialog:
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, activity.myOrdersFragment).commit();
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}