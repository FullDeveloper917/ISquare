package com.example.david.isquare.Fragments.DirectoriesFragments.AddPlaceFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class AddPlaceSecondFragment extends Fragment {

    private Button btnSendRequest;
    private LinearLayout layoutRtn;
    private ImageView imgMain;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    public MainActivity getMyActivity() {
        return myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_place_second, container, false);

        setInit();
        findViews(view);
        setFormula(view);
        setEvents();
        return view;
    }

    private void setInit(){

        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);

    }

    private void findViews(View view){

        layoutRtn = view.findViewById(R.id.layoutRtn_AddPlaceSecondFrg);
        btnSendRequest = view.findViewById(R.id.btnSendRequest_AddPlaceSecondFrg);
        imgMain = view.findViewById(R.id.imgMain_AddPlaceAddImageFrg);
    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_AddPlaceSecondFrg), iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myPlacesFragment).commit();
            }
        });

        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.placeRequestSentFragment).commit();
            }
        });

        imgMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.addPlaceAddImageFragment).commit();
            }
        });
    }
}