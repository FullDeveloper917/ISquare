package com.example.david.isquare.Fragments.AdminFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.AdminAllMemberListAdapter;
import com.example.david.isquare.Adapters.AdminProductListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.AdminProduct;
import com.example.david.isquare.Objects.AdminProductHeader;
import com.example.david.isquare.Objects.AdminProductInterface;
import com.example.david.isquare.Objects.ContactHeader;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.Follower;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class AdminProductsFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewProducts;
    private AdminProductListAdapter adminProductListAdapter;
    private List<AdminProductInterface> productList;

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

        View view = inflater.inflate(R.layout.fragment_admin_products, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        productList = new ArrayList<>();
        productList.add(new AdminProductHeader("Today (2)"));
        productList.add(new AdminProduct("Anna Klein"));
        productList.add(new AdminProduct("Anna Klein"));
        productList.add(new AdminProduct("Anna Klein"));
        productList.add(new AdminProductHeader("Yesterday (2)"));
        productList.add(new AdminProduct("Anna Klein"));
        productList.add(new AdminProduct("Anna Klein"));
        productList.add(new AdminProduct("Anna Klein"));
        productList.add(new AdminProductHeader("Last week (2)"));
        productList.add(new AdminProduct("Anna Klein"));
        productList.add(new AdminProduct("Anna Klein"));
        productList.add(new AdminProduct("Anna Klein"));
        adminProductListAdapter = new AdminProductListAdapter(myActivity, productList);
        adminProductListAdapter.setMyFragment(this);
    }

    private void findViews(View view){
        txtIconRtn = view.findViewById(R.id.txtIconRtn_AdminProductsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_AdminProductsFrg);
        listViewProducts = view.findViewById(R.id.listProducts_AdminProductsFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminFragment).commit();
            }
        });

        listViewProducts.setAdapter(adminProductListAdapter);
    }
}
