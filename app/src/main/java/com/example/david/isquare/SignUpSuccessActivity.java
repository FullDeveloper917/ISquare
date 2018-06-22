package com.example.david.isquare;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.david.isquare.Utils.FontManager;

public class SignUpSuccessActivity extends AppCompatActivity {

    private Button btnStart;

    private Typeface iconFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_success);

        iconFont = FontManager.getTypeface(this, FontManager.FONTAWESOME);
        FontManager.setFontType(findViewById(R.id.layoutMain_SignUpSuccess), iconFont);

        btnStart = (Button) findViewById(R.id.btnStart_SignUpSuccess);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpSuccessActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
