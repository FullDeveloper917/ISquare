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
import android.widget.TextView;

import com.example.david.isquare.Fragments.MeFragments.AddressFragments.AddressFragment;
import com.example.david.isquare.Fragments.MeFragments.AddressFragments.EditAddressFragment;
import com.example.david.isquare.Objects.HomeAddress;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/4/2017.
 */

public class AddressListAdapter extends ArrayAdapter {

    private final Context context;
    private List<HomeAddress> lists = new ArrayList<>();

    private TextView txtIconAddress;
    private Button btnEdit;
    private LinearLayout layoutOneAddress;

    private AddressFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(AddressFragment myFragment) {
        this.myFragment = myFragment;
    }

    public AddressListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<HomeAddress> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_address, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        txtIconAddress = rowView.findViewById(R.id.txtIconAddress_OneAddress);
        btnEdit = rowView.findViewById(R.id.btnEdit_OneAddress);
        layoutOneAddress = rowView.findViewById(R.id.layoutOneAddress_OneAddress);

        txtIconAddress.setTypeface(iconFont);
        btnEdit.setTypeface(iconFont);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditAddressFragment editAddressFragment = myFragment.getMyActivity().editAddressFragment;
                myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, editAddressFragment).commit();
            }
        });

        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
