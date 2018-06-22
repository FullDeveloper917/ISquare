package com.example.david.isquare.Fragments.MeFragments.MyShopFragments.OrdersFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class OrderDetailOfProcessingDeliveryFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private Button btnGoComments;
    private TextView txtIconStatus;
    private TextView txtIconExpressCompanyName;
    private TextView txtTrackingNumber;
    private TextView txtConfirmTrackingNumber;

    private Button btnConfirm;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_detail_of_processing_delivery, container, false);

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

        txtIconRtn = view.findViewById(R.id.txtIconRtn_OrderDetailOfProcessingDeliveryFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_OrderDetailOfProcessingDeliveryFrg);
        txtIconStatus = view.findViewById(R.id.txtIconStatus_OrderDetailOfProcessingDeliveryFrg);
        btnGoComments = view.findViewById(R.id.btnGoComments_OrderDetailOfProcessingDeliveryFrg);
        txtIconExpressCompanyName = view.findViewById(R.id.txtIconExpressCompanyName_OrderDetailOfProcessingDeliveryFrg);
        txtTrackingNumber = view.findViewById(R.id.txtIconTrackingNumber_OrderDetailOfProcessingDeliveryFrg);
        txtConfirmTrackingNumber = view.findViewById(R.id.txtIconConfirmTrackingNumber_OrderDetailOfProcessingDeliveryFrg);
        btnConfirm = view.findViewById(R.id.btnConfirm_OrderDetailOfProcessingDeliveryFrg);

    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtIconStatus.setTypeface(iconFont);
        btnGoComments.setTypeface(iconFont);
        txtIconExpressCompanyName.setTypeface(iconFont);
        txtTrackingNumber.setTypeface(iconFont);
        txtConfirmTrackingNumber.setTypeface(iconFont);

        Animation rotation = AnimationUtils.loadAnimation(myActivity, R.anim.rotate);
        rotation.setFillAfter(true);
        txtIconStatus.startAnimation(rotation);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.ordersFragment).commit();
            }
        });

        btnGoComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.singleChatFragment).commit();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.orderDetailOfOnTheWayFragment).commit();
            }
        });
    }
}
