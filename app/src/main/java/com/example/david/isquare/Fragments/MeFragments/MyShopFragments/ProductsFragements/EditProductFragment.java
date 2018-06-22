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
import android.widget.TextView;

import com.example.david.isquare.Dialogs.ProductItemDeleteDialog;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class EditProductFragment extends Fragment {
    private TextView txtIconRtn;
    private Button btnDelete;
    private Button btnSave;
    private LinearLayout layoutRtn;

    private ImageView imgMainImage;
    private ImageView imgFirstImage;
    private ImageView imgSecondImage;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_product, container, false);

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

        txtIconRtn = view.findViewById(R.id.txtIconRtn_EditProductFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_EditProductFrg);
        btnDelete = view.findViewById(R.id.btnDelete_EditProductFrg);
        btnSave = view.findViewById(R.id.btnSave_EditProductFrg);
        imgMainImage = view.findViewById(R.id.imgMainImage_EditProductFrg);
        imgFirstImage = view.findViewById(R.id.imgFirstImage_EditProductFrg);
        imgSecondImage = view.findViewById(R.id.imgSecondImage_EditProductFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        btnDelete.setTypeface(iconFont);
        btnSave.setTypeface(iconFont);
    }

    private void setEvents(){
        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.productsFragment).commit();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ProductItemDeleteDialog(myActivity).show();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.productsFragment).commit();
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
