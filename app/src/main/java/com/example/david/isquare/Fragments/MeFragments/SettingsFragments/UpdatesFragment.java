package com.example.david.isquare.Fragments.MeFragments.SettingsFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class UpdatesFragment extends Fragment {
    private LinearLayout layoutRtn;
    private TextView txtIconRtn;

    private TextView txtIconOnlyWifi;
    private TextView txtIconAutomaticallyUpdate;
    private TextView txtIconUpdateNow;
    private TextView txtSlaveIconUpdateNow;

    private LinearLayout layoutUpdateNow;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_updates, container, false);

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

        txtIconRtn = view.findViewById(R.id.txtIconRtn_UpdatesFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_UpdatesFrg);

        txtIconOnlyWifi = view.findViewById(R.id.txtIconOnlyWifi_UpdatesFrg);
        txtIconAutomaticallyUpdate = view.findViewById(R.id.txtIconAutomaticallyUpdate_UpdatesFrg);
        txtIconUpdateNow = view.findViewById(R.id.txtIconUpdateNow_UpdatesFrg);
        txtSlaveIconUpdateNow = view.findViewById(R.id.txtSlaveIconUpdateNow_UpdatesFrg);
        layoutUpdateNow = view.findViewById(R.id.layoutUpdateNow_UpdatesFrg);

    }

    private void setFormula(){

        txtIconRtn.setTypeface(iconFont);
        txtIconOnlyWifi.setTypeface(iconFont);
        txtIconAutomaticallyUpdate.setTypeface(iconFont);
        txtIconUpdateNow.setTypeface(iconFont);
        txtSlaveIconUpdateNow.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.usersFragment).commit();
            }
        });

        layoutUpdateNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.downloadUpdatesFragment).commit();
            }
        });

    }
}
