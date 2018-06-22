package com.example.david.isquare.Fragments.MeFragments.MyCartFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.CartListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.CartFooterItem;
import com.example.david.isquare.Objects.CartHeaderItem;
import com.example.david.isquare.Objects.CartProductItem;
import com.example.david.isquare.Objects.CartUnitItem;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class MyCartFragment extends Fragment {
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listCarts;
    private List<CartUnitItem> cartUnitList;
    private CartListAdapter cartListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        cartUnitList = new ArrayList<>();
        cartUnitList.add(new CartHeaderItem());
        cartUnitList.add(new CartProductItem());
        cartUnitList.add(new CartProductItem());
        cartUnitList.add(new CartProductItem());

        cartUnitList.add(new CartHeaderItem());
        cartUnitList.add(new CartProductItem());
        cartUnitList.add(new CartProductItem());
        cartUnitList.add(new CartProductItem());

        cartUnitList.add(new CartHeaderItem());
        cartUnitList.add(new CartProductItem());
        cartUnitList.add(new CartProductItem());
        cartUnitList.add(new CartProductItem());

        cartUnitList.add(new CartFooterItem());

        cartListAdapter = new CartListAdapter(myActivity, cartUnitList);
        cartListAdapter.setMyFragment(this);
    }


    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_MyCartFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_MyCartFrg);
        listCarts = view.findViewById(R.id.listCarts_MyCartFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.usersFragment).commit();
            }
        });

        listCarts.setAdapter(cartListAdapter);
    }
}
