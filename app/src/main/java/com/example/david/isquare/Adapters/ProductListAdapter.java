package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.ProductsFragements.EditProductFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.ProductsFragements.ProductsFragment;
import com.example.david.isquare.Objects.Product;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 9/27/2017.
 */

public class ProductListAdapter extends ArrayAdapter{
    private final Context context;
    private List<Product> lists = new ArrayList<>();

    private Button btnEdit;
    private LinearLayout layoutOneProduct;

    private ProductsFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(ProductsFragment myFragment) {
        this.myFragment = myFragment;
    }

    public ProductListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<Product> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_products, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        findViews(rowView);

        setFormula();

        setEvents();

        return rowView;
    }

    private void findViews(View rowView){
        btnEdit = rowView.findViewById(R.id.btnEdit_OneProduct);
        layoutOneProduct = rowView.findViewById(R.id.layoutOneProduct_OneProduct);
    }

    private void setFormula(){
        btnEdit.setTypeface(iconFont);
    }

    private void setEvents(){
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditProductFragment editProductFragment = myFragment.getMyActivity().editProductFragment;
                myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, editProductFragment).commit();
            }
        });
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
