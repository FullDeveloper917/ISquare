package com.example.david.isquare.Fragments.MeFragments.MyShopFragments.ProductsFragements;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class AddProductFragment extends Fragment {
    private Button btnAddItem;
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;
    private TextView txtIconNew;
    private TextView txtSecondHand;
    private ImageView imgMainImage;
    private ImageView imgFirstImage;
    private ImageView imgSecondImage;

    private RadioButton rdbNew;
    private RadioButton rdbSecondHand;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);

        setInit();

        findViews(view);

        setFormula(view);

        setEvents();

        return view;
    }

    private void setInit() {
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
    }

    private void findViews(View view){

        rdbNew = view.findViewById(R.id.rdbNew_AddProductFrg);
        rdbSecondHand = view.findViewById(R.id.rdbSecondHand_AddProductFrg);
        btnAddItem = view.findViewById(R.id.btnAddItem_AddProductFrg);
        txtIconRtn = view.findViewById(R.id.txtIconRtn_AddProductFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_AddProductFrg);
        txtIconNew = view.findViewById(R.id.txtIconNew_AddProductFrg);
        txtSecondHand = view.findViewById(R.id.txtIconSecondHand_AddProductFrg);
        imgMainImage = view.findViewById(R.id.imgMainImage_AddProductFrg);
        imgFirstImage = view.findViewById(R.id.imgFirstImage_AddProductFrg);
        imgSecondImage = view.findViewById(R.id.imgSecondImage_AddProductFrg);
    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_AddProductFrg), iconFont);
    }

    private void setEvents(){
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.productsFragment).commit();
            }
        });
        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.productsFragment).commit();
            }
        });

        rdbNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdbSecondHand.setChecked(false);
            }
        });

        rdbSecondHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdbNew.setChecked(false);
            }
        });

        imgMainImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().add(R.id.frgMain, myActivity.addProductImageFragment).commit();
            }
        });

        imgFirstImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().add(R.id.frgMain, myActivity.addProductImageFragment).commit();
            }
        });

        imgSecondImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().add(R.id.frgMain, myActivity.addProductImageFragment).commit();
            }
        });

    }
}
