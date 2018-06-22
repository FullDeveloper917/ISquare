package com.example.david.isquare.Fragments.MeFragments.AddressFragments;

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

public class NewAddressFragment extends Fragment {
    private Button btnSave;
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private TextView txtIconRegion;
    private TextView txtIconCity;
    private TextView txtIconFullAddress;
    private TextView txtIconPhoneNumber;
    private TextView txtIconName;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_address, container, false);

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

        btnSave = view.findViewById(R.id.btnSave_NewAddressFrg);
        txtIconRtn = view.findViewById(R.id.txtIconRtn_NewAddressFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_NewAddressFrg);
        txtIconRegion = view.findViewById(R.id.txtIconRegion_NewAddressFrg);
        txtIconCity = view.findViewById(R.id.txtIconCity_NewAddressFrg);
        txtIconFullAddress = view.findViewById(R.id.txtIconFullAddress_NewAddressFrg);
        txtIconPhoneNumber = view.findViewById(R.id.txtIconPhoneNumber_NewAddressFrg);
        txtIconName = view.findViewById(R.id.txtIconName_NewAddressFrg);
    }

    private void setFormula(){
        btnSave.setTypeface(iconFont);
        txtIconRtn.setTypeface(iconFont);
        txtIconRegion.setTypeface(iconFont);
        txtIconCity.setTypeface(iconFont);
        txtIconFullAddress.setTypeface(iconFont);
        txtIconPhoneNumber.setTypeface(iconFont);
        txtIconName.setTypeface(iconFont);
    }

    private void setEvents(){
        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.addressFragment).commit();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.addressFragment).commit();
            }
        });

    }
}
