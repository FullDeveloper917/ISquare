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

public class TransferChatPasswordDialog extends Dialog implements View.OnClickListener{
    public MainActivity activity;
    public Button btnTransfer, btnCancel;

    public TransferChatPasswordDialog(MainActivity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_transfer_chat_password);
        btnTransfer = (Button) findViewById(R.id.btnTransfer_TransferChatPasswordDialog);
        btnCancel = (Button) findViewById(R.id.btnCancel_TransferChatPasswordDialog);
        btnTransfer.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCancel_TransferChatPasswordDialog:
                dismiss();
                break;
            case R.id.btnTransfer_TransferChatPasswordDialog:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}