package com.example.david.isquare.Fragments.MeFragments.MyCartFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;

public class CheckOutProcessingFragment extends Fragment {
    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_out_processing, container, false);

        myActivity.layoutControlTab.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myOrdersFragment).commit();
            }

        }, 2000);


        return view;
    }
}
