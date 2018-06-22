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

public class UpdateDialog extends Dialog implements android.view.View.OnClickListener{
    public MainActivity activity;
    public Button btnLater, btnUpdateNow;

    public UpdateDialog(MainActivity activity) {
        super(activity);
        // TODO Auto-generated constructor stub
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_update);
        btnLater = (Button) findViewById(R.id.btnLater_UpdateDialog);
        btnUpdateNow = (Button) findViewById(R.id.btnUpdateNow_UpdateDialog);
        btnLater.setOnClickListener(this);
        btnUpdateNow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLater_UpdateDialog:
                dismiss();
                break;
            case R.id.btnUpdateNow_UpdateDialog:
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, activity.updatesFragment).commit();
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
