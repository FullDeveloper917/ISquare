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

public class OrderPickUpDialog extends Dialog implements android.view.View.OnClickListener{
    public MainActivity activity;
    public Button btnYes, btnNo;

    public OrderPickUpDialog(MainActivity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_order_pick_up);
        btnYes= (Button) findViewById(R.id.btnYes_OrderPickUpDialog);
        btnNo = (Button) findViewById(R.id.btnNo_OrderPickUpDialog);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNo_OrderPickUpDialog:
                dismiss();
                break;
            case R.id.btnYes_OrderPickUpDialog:
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, activity.myOrdersFragment).commit();
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}