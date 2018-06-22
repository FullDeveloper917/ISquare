package com.example.david.isquare.Fragments.MeFragments.SettingsFragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.StartActivity;
import com.example.david.isquare.Utils.FontManager;

public class SettingsFragment extends Fragment {
    private Button btnSignOut;
    private Button btnGoQR;
    private LinearLayout layoutRtn;
    private TextView txtIconRtn;

    private TextView txtIconPersonalDetails;
    private TextView txtIconPassword;
    private TextView txtIconNewPartner;
    private TextView txtIconMoments;
    private TextView txtIconChats;
    private TextView txtIconInAppVibrate;
    private TextView txtIconOnlyWifi;
    private TextView txtIconHelpFeedback;
    private TextView txtIconUpdates;
    private TextView txtIconCurrency;
    private TextView txtIconRegion;
    private TextView txtIconLanguage;
    private TextView txtIconTextSize;
    private TextView txtSlaveIconHelpFeedback;
    private TextView txtSlaveIconUpdates;

    private ToggleButton tglNewPartner;
    private ToggleButton tglMoments;
    private ToggleButton tglChats;
    private ToggleButton tglInAppVibrate;
    private ToggleButton tglOnlyWifi;

    private LinearLayout layoutPersonalDetail;
    private LinearLayout layoutPassword;
    private LinearLayout layoutHelpFeedback;
    private LinearLayout layoutUpdates;
    private LinearLayout layoutTextSize;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

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

        btnGoQR = view.findViewById(R.id.btnGoQR_SettingsFrg);
        btnSignOut = view.findViewById(R.id.btnSignOut_SettingsFrg);
        txtIconRtn = view.findViewById(R.id.txtIconRtn_SettingsFrg);

        txtIconPersonalDetails = view.findViewById(R.id.txtIconPersonalDetails_SettingsFrg);
        txtIconPassword = view.findViewById(R.id.txtIconPassword_SettingsFrg);
        txtIconNewPartner = view.findViewById(R.id.txtIconNewPartner_SettingsFrg);
        txtIconMoments = view.findViewById(R.id.txtIconMoments_SettingsFrg);
        txtIconChats = view.findViewById(R.id.txtIconChats_SettingsFrg);
        txtIconInAppVibrate = view.findViewById(R.id.txtIconInAppVibrate_SettingsFrg);
        txtIconOnlyWifi = view.findViewById(R.id.txtIconOnlyWifi_SettingsFrg);
        txtIconHelpFeedback = view.findViewById(R.id.txtIconHelpFeedback_SettingsFrg);
        txtIconUpdates = view.findViewById(R.id.txtIconUpdates_SettingsFrg);
        txtIconCurrency = view.findViewById(R.id.txtIconCurrency_SettingsFrg);
        txtIconRegion = view.findViewById(R.id.txtIconRegion_SettingsFrg);
        txtIconLanguage = view.findViewById(R.id.txtIconLanguage_SettingsFrg);
        txtIconTextSize = view.findViewById(R.id.txtIconTextSize_SettingsFrg);
        txtSlaveIconHelpFeedback = view.findViewById(R.id.txtSlaveIconHelpFeedback_SettingsFrg);
        txtSlaveIconUpdates = view.findViewById(R.id.txtSlaveIconUpdates_SettingsFrg);

        tglNewPartner = view.findViewById(R.id.tglNewPartner_SettingFrg);
        tglMoments = view.findViewById(R.id.tglMoments_SettingFrg);
        tglChats = view.findViewById(R.id.tglChats_SettingFrg);
        tglInAppVibrate = view.findViewById(R.id.tglInAppVibrate_SettingFrg);
        tglOnlyWifi = view.findViewById(R.id.tglOnlyWifi_SettingFrg);

        layoutRtn = view.findViewById(R.id.layoutRtn_SettingsFrg);
        layoutPersonalDetail = view.findViewById(R.id.layoutPersonalDetails_SettingsFrg);
        layoutPassword = view.findViewById(R.id.layoutPassword_SettingsFrg);
        layoutHelpFeedback = view.findViewById(R.id.layoutHelpFeedback_SettingsFrg);
        layoutUpdates = view.findViewById(R.id.layoutUpdates_SettingsFrg);
        layoutTextSize= view.findViewById(R.id.layoutTextSize_SettingsFrg);
    }

    private void setFormula(){
        btnGoQR.setTypeface(iconFont);
        txtIconRtn.setTypeface(iconFont);
        txtIconPersonalDetails.setTypeface(iconFont);
        txtIconPassword.setTypeface(iconFont);
        txtIconNewPartner.setTypeface(iconFont);
        txtIconMoments.setTypeface(iconFont);
        txtIconChats.setTypeface(iconFont);
        txtIconInAppVibrate.setTypeface(iconFont);
        txtIconOnlyWifi.setTypeface(iconFont);
        txtIconHelpFeedback.setTypeface(iconFont);
        txtIconUpdates.setTypeface(iconFont);
        txtIconCurrency.setTypeface(iconFont);
        txtIconRegion.setTypeface(iconFont);
        txtIconLanguage.setTypeface(iconFont);
        txtIconTextSize.setTypeface(iconFont);
        txtSlaveIconHelpFeedback.setTypeface(iconFont);
        txtSlaveIconUpdates.setTypeface(iconFont);
    }

    private void setEvents(){
        btnGoQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myQrCodeFragment).commit();
            }
        });

        tglNewPartner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tglNewPartner.isChecked()){
                    txtIconNewPartner.setTextColor(myActivity.getResources().getColor(R.color.colorMyRed));
                }
                else {
                    txtIconNewPartner.setTextColor(myActivity.getResources().getColor(R.color.colorMyGray_4));
                }
            }
        });

        tglMoments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tglMoments.isChecked()){
                    txtIconMoments.setTextColor(myActivity.getResources().getColor(R.color.colorMyRed));
                }
                else {
                    txtIconMoments.setTextColor(myActivity.getResources().getColor(R.color.colorMyGray_4));
                }
            }
        });

        tglChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tglChats.isChecked()){
                    txtIconChats.setTextColor(myActivity.getResources().getColor(R.color.colorMyRed));
                }
                else {
                    txtIconChats.setTextColor(myActivity.getResources().getColor(R.color.colorMyGray_4));
                }
            }
        });

        tglInAppVibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tglInAppVibrate.isChecked()){
                    txtIconInAppVibrate.setTextColor(myActivity.getResources().getColor(R.color.colorMyRed));
                }
                else {
                    txtIconInAppVibrate.setTextColor(myActivity.getResources().getColor(R.color.colorMyGray_4));
                }
            }
        });

        tglOnlyWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tglOnlyWifi.isChecked()){
                    txtIconOnlyWifi.setTextColor(myActivity.getResources().getColor(R.color.colorMyRed));
                }
                else {
                    txtIconOnlyWifi.setTextColor(myActivity.getResources().getColor(R.color.colorMyGray_4));
                }
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.usersFragment).commit();
            }
        });

        layoutPersonalDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.personalDetailsFragment).commit();
            }
        });

        layoutPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.changePasswordFragment).commit();
            }
        });

        layoutHelpFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.singleChatFragment).commit();
            }
        });

        layoutUpdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.updatesFragment).commit();
            }
        });

        layoutTextSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.textSizeFragment).commit();
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myActivity, StartActivity.class);
                startActivity(intent);
                myActivity.finish();
            }
        });

    }
}
