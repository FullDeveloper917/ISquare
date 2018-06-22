package com.example.david.isquare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Dialogs.UpdateDialog;

public class SignInActivity extends BaseActivity{

    private TextView txtIconRtn;
    private TextView txtIconMyId;
    private TextView txtIconPassword;
    private EditText edtMyId;
    private EditText edtPassword;
    private Button btnSignIn;
    private LinearLayout layoutRtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        findViews();
        setFormula();
        setEvents();
    }

    private void findViews(){

        txtIconRtn = (TextView) findViewById(R.id.txtIconRtn_SignIn);
        txtIconMyId = (TextView) findViewById(R.id.txtIconMyId_SignIn);
        txtIconPassword = (TextView) findViewById(R.id.txtIconPassword_SignIn);
        edtMyId = (EditText) findViewById(R.id.edtMyId_SignIn);
        edtPassword = (EditText) findViewById(R.id.edtPassword_SignIn);
        btnSignIn = (Button) findViewById(R.id.btnSignIn_SignIn);
        layoutRtn = (LinearLayout) findViewById(R.id.layoutRtn_SignIn);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtIconMyId.setTypeface(iconFont);
        txtIconPassword.setTypeface(iconFont);
    }

    private void setEvents(){
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
