package com.example.david.isquare.Fragments.MeFragments.MyWalletFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class PaymentPasswordFragment extends Fragment {
    private LinearLayout layoutRtn;
    private TextView txtIconRtn;
    private Button btnSave;

    private TextView txtIconYourPassword;
    private TextView txtIconNewPassword;
    private TextView txtIconConfirmPassword;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment_password, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_PaymentPasswordFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_PaymentPasswordFrg);
        btnSave = view.findViewById(R.id.btnSave_PaymentPasswordFrg);

        txtIconYourPassword = view.findViewById(R.id.txtIconYourPassword_PaymentPasswordFrg);
        txtIconNewPassword = view.findViewById(R.id.txtIconNewPassword_PaymentPasswordFrg);
        txtIconConfirmPassword = view.findViewById(R.id.txtIconConfirmPassword_PaymentPasswordFrg);

    }

    private void setFormula(){

        txtIconRtn.setTypeface(iconFont);
        btnSave.setTypeface(iconFont);
        txtIconYourPassword.setTypeface(iconFont);
        txtIconNewPassword.setTypeface(iconFont);
        txtIconConfirmPassword.setTypeface(iconFont);

    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myWalletFragment).commit();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myWalletFragment).commit();
            }
        });

    }
}
