package com.example.david.isquare;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class ProfileBlockedActivity extends AppCompatActivity {

    private TextView txtIconRtn;

    private Typeface iconFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_blocked);


        iconFont = FontManager.getTypeface(this, FontManager.FONTAWESOME);
        FontManager.setFontType(findViewById(R.id.layoutMain_ProfileBlocked), iconFont);

        txtIconRtn = (TextView) findViewById(R.id.txtIconRtn_ProfileBlocked);
        txtIconRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileBlockedActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
    }
}
