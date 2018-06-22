package com.example.david.isquare.Fragments.AdminFragments.AdminWithdrawalFragments;

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

import com.example.david.isquare.Dialogs.AdminWithdrawalDoneDialog;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class AdminWithdrawalDetailFragment extends Fragment {
    private Button btnDone;
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
        View view = inflater.inflate(R.layout.fragment_admin_withdrawal_detail, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
    }

    private void findViews(View view){

        btnDone = view.findViewById(R.id.btnDone_AdminWithdrawalDetailFrg);
        txtIconRtn = view.findViewById(R.id.txtIconRtn_AdminWithdrawalDetailFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_AdminWithdrawalDetailFrg);
        txtIconAmount = view.findViewById(R.id.txtIconAmount_AdminWithdrawalDetailFrg);
        txtIconRegion = view.findViewById(R.id.txtIconRegion_AdminWithdrawalDetailFrg);
        txtIconBankName = view.findViewById(R.id.txtIconBankName_AdminWithdrawalDetailFrg);
        txtIconBankAddress = view.findViewById(R.id.txtIconBankAddress_AdminWithdrawalDetailFrg);
        txtIconSwift = view.findViewById(R.id.txtIconSwift_AdminWithdrawalDetailFrg);
        txtIconAccountNumber = view.findViewById(R.id.txtIconAccountNumber_AdminWithdrawalDetailFrg);
        txtIconFirstName = view.findViewById(R.id.txtIconFirstName_AdminWithdrawalDetailFrg);
        txtIconGivenName = view.findViewById(R.id.txtIconGivenName_AdminWithdrawalDetailFrg);
        txtIconPhoneNumber = view.findViewById(R.id.txtIconPhoneNumber_AdminWithdrawalDetailFrg);
        txtIconEmail = view.findViewById(R.id.txtIconEmail_AdminWithdrawalDetailFrg);
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
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AdminWithdrawalDoneDialog(myActivity).show();
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminWithdrawalFragment).commit();
            }
        });

    }
}

