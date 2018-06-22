package com.example.david.isquare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Utils.FontManager;

public class SignUpActivity extends BaseActivity {

    private TextView txtIconRtn;
    private TextView txtIconRegion;
    private TextView txtIconPartnerId;
    private TextView txtIconGivenName;
    private TextView txtIconFamilyName;
    private TextView txtIconEmail;
    private TextView txtIconPhoneNumber;
    private TextView txtIconPassword;
    private TextView txtIconConfirmPassword;

    private EditText edtPartnerId;
    private EditText edtGivenName;
    private EditText edtFamilyName;
    private EditText edtEmail;
    private EditText edtPhoneNumber;
    private EditText edtPassword;
    private EditText edtConfirmPassword;

    private Button btnSignUp;

    private LinearLayout layoutRtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        findViews();
        setFormula();
        setEvents();
    }

    private void findViews(){
        txtIconRtn = (TextView) findViewById(R.id.txtIconRtn_SignUp);
        txtIconRegion = (TextView) findViewById(R.id.txtIconRegion_SignUp);
        txtIconPartnerId = (TextView) findViewById(R.id.txtIconPartnerId_SignUp);
        txtIconGivenName = (TextView) findViewById(R.id.txtIconGivenName_SignUp);
        txtIconFamilyName = (TextView) findViewById(R.id.txtIconFamilyName_SignUp);
        txtIconEmail = (TextView) findViewById(R.id.txtIconEmail_SignUp);
        txtIconPhoneNumber = (TextView) findViewById(R.id.txtIconPhoneNumber_SignUp);
        txtIconPassword = (TextView) findViewById(R.id.txtIconPassword_SignUp);
        txtIconConfirmPassword = (TextView) findViewById(R.id.txtIconConfirmPassword_SignUp);

        edtPartnerId = (EditText) findViewById(R.id.edtPartnerId_SignUp);
        edtGivenName = (EditText) findViewById(R.id.edtGivenName_SignUp);
        edtFamilyName = (EditText) findViewById(R.id.edtFamilyName_SignUp);
        edtEmail = (EditText) findViewById(R.id.edtEmail_SignUp);
        edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber_SignUp);
        edtPassword = (EditText) findViewById(R.id.edtPassword_SignUp);
        edtConfirmPassword = (EditText) findViewById(R.id.edtConfirmPassword_SignUp);

        btnSignUp = (Button) findViewById(R.id.btnSignUp_SignUp);
        layoutRtn = (LinearLayout) findViewById(R.id.layoutRtn_SignUp);
    }

    private void setFormula(){
        FontManager.setFontType(findViewById(R.id.layoutMain_SignUp), iconFont);
    }

    private void setEvents(){
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, SignUpSuccessActivity.class);
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
