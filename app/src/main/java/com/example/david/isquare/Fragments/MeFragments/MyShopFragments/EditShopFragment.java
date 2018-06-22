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

public class EditShopFragment extends Fragment {

    private Button btnSave;
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
        View view = inflater.inflate(R.layout.fragment_edit_shop, container, false);

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

        btnSave = view.findViewById(R.id.btnSave_EditShopFrg);
        txtIconRtn = view.findViewById(R.id.txtIconRtn_EditShopFrg);
        txtIconRegion = view.findViewById(R.id.txtIconRegion_EditShopFrg);
        txtIconState = view.findViewById(R.id.txtIconState_EditShopFrg);
        txtIconDelivery = view.findViewById(R.id.txtIconDelivery_EditShopFrg);
        txtIconAddress = view.findViewById(R.id.txtIconAddress_EditShopFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_EditShopFrg);
    }

    private void setFormula(){
        btnSave.setTypeface(iconFont);
        txtIconRtn.setTypeface(iconFont);
        txtIconRegion.setTypeface(iconFont);
        txtIconState.setTypeface(iconFont);
        txtIconDelivery.setTypeface(iconFont);
        txtIconAddress.setTypeface(iconFont);
    }

    private void setEvents(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myShopFragment).commit();
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myShopFragment).commit();
            }
        });

    }

}
