package com.example.david.isquare.Fragments.MeFragments.MyShopFragments.OrdersFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.OrderListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Order;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class OrdersFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewOrders;
    private List<Order> orderList;
    private OrderListAdapter orderListAdapter;

    private Typeface iconFont;

    private MainActivity myActivity;

    public MainActivity getMyActivity() {
        return myActivity;
    }

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_orders, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        orderList = new ArrayList<>();
        orderList.add(new Order("12/05/2017", 0));
        orderList.add(new Order("12/05/2017", 1));
        orderList.add(new Order("12/05/2017", 2));
        orderList.add(new Order("12/05/2017", 3));
        orderList.add(new Order("12/05/2017", 4));

        orderListAdapter = new OrderListAdapter(myActivity, R.layout.list_item_of_orders);
        orderListAdapter.setList(orderList);
        orderListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_OrdersFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_OrdersFrg);
        listViewOrders = view.findViewById(R.id.listOrders_OrdersFrg);

    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myShopFragment).commit();
            }
        });

        listViewOrders.setAdapter(orderListAdapter);

    }
}
