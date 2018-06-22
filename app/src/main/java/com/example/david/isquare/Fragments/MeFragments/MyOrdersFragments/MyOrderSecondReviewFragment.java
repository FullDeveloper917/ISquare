package com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments;

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
import android.widget.TextView;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class MyOrderSecondReviewFragment extends Fragment {
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private TextView txtStarMark;
    private Button btnPostAll;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_order_second_review, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_MyOrderSecondReviewFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_MyOrderSecondReviewFrg);
        txtStarMark = view.findViewById(R.id.txtStarMark_MyOrderSecondReviewFrg);
        btnPostAll = view.findViewById(R.id.btnPostAll_MyOrderSecondReviewFrg);

    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtStarMark.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myOrderFirstReviewFragment).commit();
            }
        });

        btnPostAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myOrderThanksFragment).commit();
            }
        });

    }
}
