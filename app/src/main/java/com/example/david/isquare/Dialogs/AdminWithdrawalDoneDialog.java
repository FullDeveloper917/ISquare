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

public class AdminWithdrawalDoneDialog extends Dialog implements View.OnClickListener{
    public MainActivity activity;
    public Button btnYes, btnNo;

    public AdminWithdrawalDoneDialog(MainActivity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_admin_withdrawal_done);
        btnYes= (Button) findViewById(R.id.btnYes_AdminWithdrawalDoneDialog);
        btnNo = (Button) findViewById(R.id.btnNo_AdminWithdrawalDoneDialog);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNo_AdminWithdrawalDoneDialog:
                dismiss();
                break;
            case R.id.btnYes_AdminWithdrawalDoneDialog:
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, activity.adminWithdrawalFragment).commit();
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}