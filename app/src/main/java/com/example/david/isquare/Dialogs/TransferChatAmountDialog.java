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

public class TransferChatAmountDialog extends Dialog implements View.OnClickListener{
    public MainActivity activity;
    public Button btnOk, btnCancel;

    public TransferChatAmountDialog(MainActivity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_transfer_chat_amount);
        btnOk = (Button) findViewById(R.id.btnOk_TransferChatAmountDialog);
        btnCancel = (Button) findViewById(R.id.btnCancel_TransferChatAmountDialog);
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCancel_TransferChatAmountDialog:
                dismiss();
                break;
            case R.id.btnOk_TransferChatAmountDialog:
                new TransferChatPasswordDialog(activity).show();
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}