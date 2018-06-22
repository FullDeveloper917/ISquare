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

public class MyWalletFragment extends Fragment {
    private Button btnGoPassword;
    private LinearLayout layoutRtn;
    private TextView txtIconRtn;
    private TextView txtIconBalance;
    private TextView txtIconCommission;
    private TextView txtIconWithdrawal;
    private TextView txtIconDeposit;
    private TextView txtIconTransactions;

    private LinearLayout layoutWithdrawal;
    private LinearLayout layoutDeposit;
    private LinearLayout layoutTransactions;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wallet, container, false);

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

        btnGoPassword = view.findViewById(R.id.btnGoPassword_MyWalletFrg);
        txtIconRtn = view.findViewById(R.id.txtIconRtn_MyWalletFrg);
        txtIconBalance = view.findViewById(R.id.txtIconBalance_MyWalletFrg);
        txtIconCommission = view.findViewById(R.id.txtIconCommission_MyWalletFrg);
        txtIconWithdrawal = view.findViewById(R.id.txtIconWithdrawal_MyWalletFrg);
        txtIconDeposit = view.findViewById(R.id.txtIconDeposit_MyWalletFrg);
        txtIconTransactions = view.findViewById(R.id.txtIconTransactions_MyWalletFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_MyWalletFrg);
        layoutWithdrawal = view.findViewById(R.id.layoutWithdrawal_MyWalletFrg);
        layoutDeposit = view.findViewById(R.id.layoutDeposit_MyWalletFrg);
        layoutTransactions = view.findViewById(R.id.layoutTransactions_MyWalletFrg);
    }

    private void setFormula(){
        btnGoPassword.setTypeface(iconFont);
        txtIconRtn.setTypeface(iconFont);
        txtIconBalance.setTypeface(iconFont);
        txtIconCommission.setTypeface(iconFont);
        txtIconWithdrawal.setTypeface(iconFont);
        txtIconDeposit.setTypeface(iconFont);
        txtIconTransactions.setTypeface(iconFont);
    }

    private void setEvents(){
        btnGoPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.paymentPasswordFragment).commit();
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.usersFragment).commit();
            }
        });

        layoutWithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.withdrawalFragment).commit();
            }
        });

        layoutDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.depositFragment).commit();
            }
        });

        layoutTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.transactionsFragment).commit();
            }
        });
    }
}
