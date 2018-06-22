package com.example.david.isquare;


import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.example.david.isquare.Utils.FontManager;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 9/25/2017.
 */


public class BaseActivity extends AppCompatActivity {

    private static final int BUILD_VERSION_CODES_M = 23;
    public static Cursor cursor;
    public static List<String> galleryImageUris = new ArrayList<>();

    public int screenHeight, screenWidth;

    public Typeface iconFont;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;
    }

    public void tryToRequestMarshmallowExternalStoragePermission() {

        if (Build.VERSION.SDK_INT < 23) return;

        final Method checkSelfPermissionMethod = getCheckSelfPermissionMethod();

        if (checkSelfPermissionMethod == null) return;

        try {

            final Integer permissionCheckResult = (Integer) checkSelfPermissionMethod.invoke(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) return;

            final Method requestPermissionsMethod = getRequestPermissionsMethod();
            if (requestPermissionsMethod == null) return;

            requestPermissionsMethod.invoke(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private Method getCheckSelfPermissionMethod() {
        try {
            return Activity.class.getMethod("checkSelfPermission", String.class);
        } catch (Exception e) {
            return null;
        }
    }

    private Method getRequestPermissionsMethod() {
        try {
            final Class[] parameterTypes = {String[].class, int.class};

            return Activity.class.getMethod("requestPermissions", parameterTypes);

        } catch (Exception e) {
            return null;
        }
    }

    public int convertSpToPixels(float sp) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResources().getDisplayMetrics());
        return px;
    }

}
