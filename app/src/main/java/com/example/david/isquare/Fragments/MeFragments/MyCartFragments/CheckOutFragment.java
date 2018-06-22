package com.example.david.isquare.Fragments.MeFragments.MyCartFragments;

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
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.MomentsListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Moment;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class CheckOutFragment extends Fragment {
    private Button btnCheckOut;

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;
    private TextView txtIconAddress;
    private Button btnChangeAddress;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_check_out, container, false);

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

        btnCheckOut = view.findViewById(R.id.btnCheckOut_CheckOutFrg);

        txtIconRtn = view.findViewById(R.id.txtIconRtn_CheckOutFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_CheckOutFrg);
        txtIconAddress = view.findViewById(R.id.txtIconAddress_CheckOutFrg);
        btnChangeAddress = view.findViewById(R.id.btnChangeAddress_CheckOutFrg);

    }

    private void setFormula(){
        txtIconAddress.setTypeface(iconFont);
        btnChangeAddress.setTypeface(iconFont);
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.checkOutProcessingFragment).commit();
            }
        });

        btnChangeAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.changeAddressFragment).commit();
            }
        });
        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myCartFragment).commit();
            }
        });

    }
}
