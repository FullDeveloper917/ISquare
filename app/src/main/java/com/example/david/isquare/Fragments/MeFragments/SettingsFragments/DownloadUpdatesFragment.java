package com.example.david.isquare.Fragments.MeFragments.SettingsFragments;

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

public class DownloadUpdatesFragment extends Fragment {
    private LinearLayout layoutRtn;
    private TextView txtIconRtn;

    private TextView txtIconGooglePlay;
    private TextView txtIconDownloadDirectly;
    private TextView txtSlaveIconGooglePlay;
    private TextView txtSlaveIconDownloadDirectly;

    private LinearLayout layoutDownloadDirectly;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_download_updates, container, false);

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

        txtIconRtn = view.findViewById(R.id.txtIconRtn_DownloadUpdatesFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_DownloadUpdatesFrg);

        txtIconGooglePlay = view.findViewById(R.id.txtIconGooglePlay_DownloadUpdatesFrg);
        txtIconDownloadDirectly = view.findViewById(R.id.txtIconDownloadDirectly_DownloadUpdatesFrg);
        txtSlaveIconGooglePlay = view.findViewById(R.id.txtSlaveIconGooglePlay_DownloadUpdatesFrg);
        txtSlaveIconDownloadDirectly = view.findViewById(R.id.txtSlaveIconDownloadDirectly_DownloadUpdatesFrg);
        layoutDownloadDirectly = view.findViewById(R.id.layoutDownloadDirectly_DownloadUpdatesFrg);

    }

    private void setFormula(){

        txtIconRtn.setTypeface(iconFont);
        txtIconGooglePlay.setTypeface(iconFont);
        txtIconDownloadDirectly.setTypeface(iconFont);
        txtSlaveIconGooglePlay.setTypeface(iconFont);
        txtSlaveIconDownloadDirectly.setTypeface(iconFont);

        Animation rotation = AnimationUtils.loadAnimation(myActivity, R.anim.rotate);
        rotation.setFillAfter(true);
        txtSlaveIconGooglePlay.startAnimation(rotation);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.updatesFragment).commit();
            }
        });

    }
}
