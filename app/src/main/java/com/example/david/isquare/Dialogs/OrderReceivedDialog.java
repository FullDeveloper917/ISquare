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

public class OrderReceivedDialog extends Dialog implements android.view.View.OnClickListener{
    public MainActivity activity;
    public Button btnYes, btnNo;

    public OrderReceivedDialog(MainActivity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_order_received);
        btnYes= (Button) findViewById(R.id.btnYes_OrderReceivedDialog);
        btnNo = (Button) findViewById(R.id.btnNo_OrderReceivedDialog);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNo_OrderReceivedDialog:
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, activity.myOrderDetailOfReceivedFragment).commit();
                dismiss();
                break;
            case R.id.btnYes_OrderReceivedDialog:
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, activity.myOrderFirstReviewFragment).commit();
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
