package com.example.david.isquare.Fragments.MeFragments.SettingsFragments;

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

public class PersonalDetailsFragment extends Fragment {

    private Button btnSave;
    private LinearLayout layoutRtn;
    private TextView txtIconRtn;

    private TextView txtIconGivenName;
    private TextView txtIconFamilyName;
    private TextView txtIconNationality;
    private TextView txtIconBirthDay;
    private TextView txtIconEmail;
    private TextView txtIconPhoneNumber;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personal_details, container, false);

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

        btnSave = view.findViewById(R.id.btnSave_PersonalDetailsFrg);
        txtIconRtn = view.findViewById(R.id.txtIconRtn_PersonalDetailsFrg);

        txtIconGivenName = view.findViewById(R.id.txtIconGivenName_PersonalDetailsFrg);
        txtIconFamilyName = view.findViewById(R.id.txtIconFamilyName_PersonalDetailsFrg);
        txtIconNationality = view.findViewById(R.id.txtIconNationality_PersonalDetailsFrg);
        txtIconBirthDay = view.findViewById(R.id.txtIconBirthDay_PersonalDetailsFrg);
        txtIconEmail = view.findViewById(R.id.txtIconEmail_PersonalDetailsFrg);
        txtIconPhoneNumber = view.findViewById(R.id.txtIconPhoneNumber_PersonalDetailsFrg);

        layoutRtn = view.findViewById(R.id.layoutRtn_PersonalDetailsFrg);

    }

    private void setFormula(){
        btnSave.setTypeface(iconFont);
        txtIconRtn.setTypeface(iconFont);
        txtIconGivenName.setTypeface(iconFont);
        txtIconFamilyName.setTypeface(iconFont);
        txtIconNationality.setTypeface(iconFont);
        txtIconBirthDay.setTypeface(iconFont);
        txtIconEmail.setTypeface(iconFont);
        txtIconPhoneNumber.setTypeface(iconFont);
    }

    private void setEvents(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.usersFragment).commit();
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.settingsFragment).commit();
            }
        });

    }
}
