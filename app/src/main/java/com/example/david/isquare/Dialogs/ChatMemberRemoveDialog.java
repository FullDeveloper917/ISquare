package com.example.david.isquare.Dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;

/**
 * Created by David on 10/13/2017.
 */

public class ChatMemberRemoveDialog extends Dialog implements View.OnClickListener{
    public MainActivity activity;
    public Button btnBan, btnCancel;

    public ChatMemberRemoveDialog(MainActivity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_chat_member_remove);
        btnBan= (Button) findViewById(R.id.btnBan_ChatMemberRemoveDialog);
        btnCancel = (Button) findViewById(R.id.btnCancel_ChatMemberRemoveDialog);
        btnBan.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCancel_ChatMemberRemoveDialog:
                dismiss();
                break;
            case R.id.btnBan_ChatMemberRemoveDialog:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}