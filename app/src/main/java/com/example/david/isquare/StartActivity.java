package com.example.david.isquare;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.reflect.Method;

import de.hdodenhof.circleimageview.CircleImageView;

public class StartActivity extends BaseActivity {

    private Button btnSignUp;
    private Button btnSignIn;
    private CircleImageView btnEnglish;
    private CircleImageView btnChinese;
    private ImageView imgMark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        tryToRequestMarshmallowExternalStoragePermission();
        setInit();
        findViews();
        setEvents();
    }

    private void setInit(){
        cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);

        if (cursor != null) {
            new Thread() {
                public void run() {
                    try {
                        cursor.moveToFirst();
                        for (int i = 0; i < cursor.getCount(); i++) {
                            cursor.moveToPosition(i);
                            galleryImageUris.add(cursor.getString(1));
                        }

                    } catch (Exception e) {
                    }
                }
            }.start();
        }
    }

    private void findViews(){
        btnSignUp = (Button) findViewById(R.id.btnSignUp_Start);
        btnSignIn = (Button) findViewById(R.id.btnSignIn_Start);

        btnEnglish = (CircleImageView) findViewById(R.id.btnEnglish);
        btnChinese = (CircleImageView) findViewById(R.id.btnChinese);

        imgMark = (ImageView) findViewById(R.id.imgMark);
        Animation animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        Animation animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        imgMark.startAnimation(animZoomIn);

    }

    private void setEvents(){
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, SignUpActivity.class);
                startActivity(intent);

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnEnglish.setImageDrawable(getResources().getDrawable(R.drawable.language_icon_en_transparent));
                btnChinese.setImageDrawable(getResources().getDrawable(R.drawable.language_icon_ch));
                btnSignUp.setText(getResources().getString(R.string.sign_up));
                btnSignIn.setText(getResources().getString(R.string.sign_in));
            }
        });

        btnChinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnEnglish.setImageDrawable(getResources().getDrawable(R.drawable.language_icon_en));
                btnChinese.setImageDrawable(getResources().getDrawable(R.drawable.language_icon_ch_transparent));
                btnSignUp.setText(getResources().getString(R.string.sign_up_ch));
                btnSignIn.setText(getResources().getString(R.string.sign_in_ch));
            }
        });


    }


}
