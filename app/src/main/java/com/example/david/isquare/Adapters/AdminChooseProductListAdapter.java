package com.example.david.isquare.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.david.isquare.Fragments.AdminFragments.AdminShopsFragments.AdminShopsDesignChooseProductFragment;
import com.example.david.isquare.Objects.AdminProduct;
import com.example.david.isquare.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/9/2017.
 */

public class AdminChooseProductListAdapter extends ArrayAdapter {
    private final Context context;
    private List<AdminProduct> lists = new ArrayList<>();

    private AdminShopsDesignChooseProductFragment myFragment;

    private TextView txtName;
    private Button btnTrash;

    public void setMyFragment(AdminShopsDesignChooseProductFragment myFragment) {
        this.myFragment = myFragment;
    }

    public AdminChooseProductListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<AdminProduct> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_admin_products, parent, false);

        btnTrash = rowView.findViewById(R.id.btnTrash_OneAdminProducts);
        btnTrash.setVisibility(View.GONE);
        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
