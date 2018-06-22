package com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Dialogs.OrderPickUpDialog;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class MyOrderDetailOfPickUpFragment extends Fragment {
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private TextView txtIconStatus;

    private Button btnPickedUp;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_order_detail_of_pick_up, container, false);

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

        txtIconRtn = view.findViewById(R.id.txtIconRtn_MyOrderDetailOfPickUpFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_MyOrderDetailOfPickUpFrg);
        txtIconStatus = view.findViewById(R.id.txtIconStatus_MyOrderDetailOfPickUpFrg);

        btnPickedUp = view.findViewById(R.id.btnPickedUp_MyOrderDetailOfPickUpFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtIconStatus.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myOrdersFragment).commit();
            }
        });

        btnPickedUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new OrderPickUpDialog(myActivity).show();
            }
        });
    }
}
