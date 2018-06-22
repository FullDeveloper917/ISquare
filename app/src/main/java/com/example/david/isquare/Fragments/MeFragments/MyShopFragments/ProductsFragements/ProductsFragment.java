package com.example.david.isquare.Fragments.MeFragments.MyShopFragments.ProductsFragements;

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

import com.example.david.isquare.Adapters.ProductListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Product;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ProductsFragment extends Fragment {

    private Button btnAdd;
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewProducts;
    private List<Product> productList;
    private ProductListAdapter productListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_products, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        productList = new ArrayList<>();
    }

    private void findViews(View view){

        btnAdd = view.findViewById(R.id.btnAdd_ProductsFrg);
        txtIconRtn = view.findViewById(R.id.txtIconRtn_ProductsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_ProductsFrg);
        listViewProducts = view.findViewById(R.id.listProducts_ProductsFrg);
    }

    private void setFormula(){
        btnAdd.setTypeface(iconFont);
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.addProductFragment).commit();
            }
        });
        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myShopFragment).commit();
            }
        });


        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));
        productList.add(new Product("Armelle #102", 50, 0.0, ""));

        productListAdapter = new ProductListAdapter(myActivity, R.layout.list_item_of_products);
        productListAdapter.setList(productList);
        productListAdapter.setMyFragment(this);

        listViewProducts.setAdapter(productListAdapter);

    }
}
