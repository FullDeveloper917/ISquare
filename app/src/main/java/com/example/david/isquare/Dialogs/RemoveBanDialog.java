package com.example.david.isquare.Dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;

/**
 * Created by David on 10/11/2017.
 */

public class RemoveBanDialog extends Dialog implements android.view.View.OnClickListener{
    public MainActivity activity;
    public Button btnYes, btnNo;

    public RemoveBanDialog(MainActivity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_remove_ban);
        btnYes= (Button) findViewById(R.id.btnYes_RemoveBanDialog);
        btnNo = (Button) findViewById(R.id.btnNo_RemoveBanDialog);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnYes_RemoveBanDialog:
                dismiss();
                break;
            case R.id.btnNo_RemoveBanDialog:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}