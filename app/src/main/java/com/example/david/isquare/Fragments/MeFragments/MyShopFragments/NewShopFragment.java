package com.example.david.isquare.Fragments.MeFragments.MyShopFragments;

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

public class NewShopFragment extends Fragment {

    private Button btnStart;
    private TextView txtIconRtn;

    private LinearLayout layoutRtn;

    private TextView txtIconRegion;
    private TextView txtIconState;
    private TextView txtIconDelivery;
    private TextView txtIconAddress;
    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_shop, container, false);

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

        btnStart = view.findViewById(R.id.btnStart_NewShopFrg);
        txtIconRtn = view.findViewById(R.id.txtIconRtn_NewShopFrg);
        txtIconRegion = view.findViewById(R.id.txtIconRegion_NewShopFrg);
        txtIconState = view.findViewById(R.id.txtIconState_NewShopFrg);
        txtIconDelivery = view.findViewById(R.id.txtIconDelivery_NewShopFrg);
        txtIconAddress = view.findViewById(R.id.txtIconAddress_NewShopFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_NewShopFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtIconRegion.setTypeface(iconFont);
        txtIconState.setTypeface(iconFont);
        txtIconDelivery.setTypeface(iconFont);
        txtIconAddress.setTypeface(iconFont);
    }

    private void setEvents(){
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myShopFragment).commit();
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.usersFragment).commit();
            }
        });

    }

}
