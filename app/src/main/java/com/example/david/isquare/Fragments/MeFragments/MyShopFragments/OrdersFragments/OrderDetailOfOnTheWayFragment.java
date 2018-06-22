package com.example.david.isquare.Fragments.MeFragments.MyShopFragments.OrdersFragments;

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

public class OrderDetailOfOnTheWayFragment extends Fragment {
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private TextView txtIconStatus;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_detail_of_on_the_way, container, false);

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

        txtIconRtn = view.findViewById(R.id.txtIconRtn_OrderDetailOfOnTheWayFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_OrderDetailOfOnTheWayFrg);
        txtIconStatus = view.findViewById(R.id.txtIconStatus_OrderDetailOfOnTheWayFrg);

    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtIconStatus.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.ordersFragment).commit();
            }
        });

    }
}
