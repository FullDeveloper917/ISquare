package com.example.david.isquare.Fragments.MeFragments.MyWalletFragments;

import android.graphics.Typeface;
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

public class WithdrawalFragment extends Fragment {
    private Button btnSendRequest;
    private LinearLayout layoutRtn;
    private TextView txtIconRtn;
    private TextView txtIconAmount;
    private TextView txtIconRegion;
    private TextView txtIconBankName;
    private TextView txtIconBankAddress;
    private TextView txtIconSwift;
    private TextView txtIconAccountNumber;
    private TextView txtIconFirstName;
    private TextView txtIconGivenName;
    private TextView txtIconPhoneNumber;
    private TextView txtIconEmail;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_withdrawal, container, false);

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

        btnSendRequest = view.findViewById(R.id.btnSendRequest_WithdrawalFrg);
        txtIconRtn = view.findViewById(R.id.txtIconRtn_WithdrawalFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_WithdrawalFrg);
        txtIconAmount = view.findViewById(R.id.txtIconAmount_WithdrawalFrg);
        txtIconRegion = view.findViewById(R.id.txtIconRegion_WithdrawalFrg);
        txtIconBankName = view.findViewById(R.id.txtIconBankName_WithdrawalFrg);
        txtIconBankAddress = view.findViewById(R.id.txtIconBankAddress_WithdrawalFrg);
        txtIconSwift = view.findViewById(R.id.txtIconSwift_WithdrawalFrg);
        txtIconAccountNumber = view.findViewById(R.id.txtIconAccountNumber_WithdrawalFrg);
        txtIconFirstName = view.findViewById(R.id.txtIconFirstName_WithdrawalFrg);
        txtIconGivenName = view.findViewById(R.id.txtIconGivenName_WithdrawalFrg);
        txtIconPhoneNumber = view.findViewById(R.id.txtIconPhoneNumber_WithdrawalFrg);
        txtIconEmail = view.findViewById(R.id.txtIconEmail_WithdrawalFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtIconAmount.setTypeface(iconFont);
        txtIconRegion.setTypeface(iconFont);
        txtIconBankName.setTypeface(iconFont);
        txtIconBankAddress.setTypeface(iconFont);
        txtIconSwift.setTypeface(iconFont);
        txtIconAccountNumber.setTypeface(iconFont);
        txtIconFirstName.setTypeface(iconFont);
        txtIconGivenName.setTypeface(iconFont);
        txtIconPhoneNumber.setTypeface(iconFont);
        txtIconEmail.setTypeface(iconFont);
    }

    private void setEvents(){
        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.processingFragment).commit();
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myWalletFragment).commit();
            }
        });

    }
}
