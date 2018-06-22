package com.example.david.isquare.Fragments.MeFragments.MyWalletFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class TransactionsFragment extends Fragment {

    private LinearLayout layoutRtn;
    private TextView txtIconRtn;
    private TextView txtIconWithdrawal;
    private TextView txtIconDeposit;
    private TextView txtSlaveIconWithdrawal;
    private TextView txtSlaveIconDeposit;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transactions, container, false);

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

        txtIconRtn = view.findViewById(R.id.txtIconRtn_TransactionsFrg);
        txtIconWithdrawal = view.findViewById(R.id.txtIconWithdrawal_TransactionsFrg);
        txtIconDeposit = view.findViewById(R.id.txtIconDeposit_TransactionsFrg);
        txtSlaveIconWithdrawal = view.findViewById(R.id.txtSlaveIconWithdrawal_TransactionsFrg);
        txtSlaveIconDeposit = view.findViewById(R.id.txtSlaveIconDeposit_TransactionsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_TransactionsFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtIconWithdrawal.setTypeface(iconFont);
        txtIconDeposit.setTypeface(iconFont);
        txtSlaveIconWithdrawal.setTypeface(iconFont);
        txtSlaveIconDeposit.setTypeface(iconFont);

        Animation rotation = AnimationUtils.loadAnimation(myActivity, R.anim.rotate);
        rotation.setFillAfter(true);
        txtSlaveIconWithdrawal.startAnimation(rotation);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myWalletFragment).commit();
            }
        });


    }
}
