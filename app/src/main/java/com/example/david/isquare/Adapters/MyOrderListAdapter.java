package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments.MyOrderDetailOfOnTheWayFragment;
import com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments.MyOrderDetailOfPickUpFragment;
import com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments.MyOrderDetailOfProcessingFragment;
import com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments.MyOrderDetailOfReceivedFragment;
import com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments.MyOrdersFragment;
import com.example.david.isquare.Objects.Order;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/2/2017.
 */

public class MyOrderListAdapter extends ArrayAdapter {
    private final Context context;
    private List<Order> lists = new ArrayList<>();

    private TextView txtStatus;
    private TextView txtIconStatus;
    private LinearLayout layoutEntire;

    private MyOrdersFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(MyOrdersFragment myFragment) {
        this.myFragment = myFragment;
    }

    public MyOrderListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<Order> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_orders, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        txtStatus = rowView.findViewById(R.id.txtStatus_OneOrder);
        txtIconStatus = rowView.findViewById(R.id.txtIconStatus_OneOrder);
        layoutEntire = rowView.findViewById(R.id.layoutEntire_OneOrder);
        layoutEntire.setTag(position);

        txtIconStatus.setTypeface(iconFont);

        switch (lists.get(position).getStatus()){
            case 0:
                txtStatus.setText("Status: Processing" );
                txtIconStatus.setText(context.getString(R.string.fa_spinner));

                Animation rotation = AnimationUtils.loadAnimation(myFragment.getMyActivity(), R.anim.rotate);
                rotation.setFillAfter(true);
                txtIconStatus.startAnimation(rotation);

                break;
            case 1:
                txtStatus.setText("Status: On the way" );
                txtIconStatus.setText(context.getString(R.string.fa_truck));
                break;
            case 2:
                txtStatus.setText("Status: Delivered" );
                txtIconStatus.setText(context.getString(R.string.fa_check_circle));
                txtIconStatus.setTextColor(context.getResources().getColor(R.color.colorMyGray_4));
                break;
            case 3:
                txtStatus.setText("Status: Ready for pick up" );
                txtIconStatus.setText(context.getString(R.string.fa_child));
                break;
        }

        layoutEntire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = (int) view.getTag();
                switch (lists.get(i).getStatus()){
                    case 0:
                        MyOrderDetailOfProcessingFragment myOrderDetailOfProcessingFragment = myFragment.getMyActivity().myOrderDetailOfProcessingFragment;
                        myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myOrderDetailOfProcessingFragment).commit();
                        break;
                    case 1:
                        MyOrderDetailOfOnTheWayFragment myOrderDetailOfOnTheWayFragment = myFragment.getMyActivity().myOrderDetailOfOnTheWayFragment;
                        myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myOrderDetailOfOnTheWayFragment).commit();
                        break;
                    case 2:
                        MyOrderDetailOfReceivedFragment myOrderDetailOfReceivedFragment = myFragment.getMyActivity().myOrderDetailOfReceivedFragment;
                        myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myOrderDetailOfReceivedFragment).commit();
                        break;
                    case 3:
                        MyOrderDetailOfPickUpFragment myOrderDetailOfPickUpFragment = myFragment.getMyActivity().myOrderDetailOfPickUpFragment;
                        myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myOrderDetailOfPickUpFragment).commit();
                        break;
                }
            }
        });


        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
