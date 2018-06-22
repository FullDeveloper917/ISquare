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
import com.example.david.isquare.Fragments.MeFragments.MyCartFragments.ChangeAddressFragment;
import com.example.david.isquare.Fragments.MeFragments.MyCartFragments.CheckOutFragment;
import com.example.david.isquare.Objects.AddressForChange;
import com.example.david.isquare.Objects.HomeAddress;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/6/2017.
 */

public class ChangeAddressListAdapter extends ArrayAdapter {

    private final Context context;
    private List<AddressForChange> lists = new ArrayList<>();

    private TextView txtIconAddress;
    private TextView txtIconChecked;
    private LinearLayout layoutChangeAddress;

    private ChangeAddressFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(ChangeAddressFragment myFragment) {
        this.myFragment = myFragment;
    }

    public ChangeAddressListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<AddressForChange> lists) {
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_change_address, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        txtIconAddress = rowView.findViewById(R.id.txtIconAddress_OneAddressForChange);
        txtIconChecked = rowView.findViewById(R.id.txtIconChecked_OneAddressForChange);
        layoutChangeAddress = rowView.findViewById(R.id.layoutChangeAddress_OneAddressForChange);

        txtIconAddress.setTypeface(iconFont);
        txtIconChecked.setTypeface(iconFont);

        if (lists.get(position).isChecked()) {
            txtIconAddress.setTextColor(context.getResources().getColor(R.color.colorMyRed));
            txtIconChecked.setTextColor(context.getResources().getColor(R.color.colorMyRed));
            txtIconChecked.setText(context.getResources().getString(R.string.fa_check));
        } else {
            txtIconAddress.setTextColor(context.getResources().getColor(R.color.colorMyGray_10));
            txtIconChecked.setTextColor(context.getResources().getColor(R.color.colorMyGray_10));
            txtIconChecked.setText("");

            layoutChangeAddress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CheckOutFragment checkOutFragment = myFragment.getMyActivity().checkOutFragment;
                    myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, checkOutFragment).commit();
                }
            });
        }



        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}