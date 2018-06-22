package com.example.david.isquare.Fragments.MeFragments.MyCartFragments;

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

import com.example.david.isquare.Adapters.ChangeAddressListAdapter;
import com.example.david.isquare.Adapters.MyOrderListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.AddressForChange;
import com.example.david.isquare.Objects.Order;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ChangeAddressFragment extends Fragment {
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewAddresses;
    private List<AddressForChange> addressList;
    private ChangeAddressListAdapter changeAddressListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_change_address, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        addressList = new ArrayList<>();
        addressList.add(new AddressForChange(true));
        addressList.add(new AddressForChange(false));
        addressList.add(new AddressForChange(false));

        changeAddressListAdapter = new ChangeAddressListAdapter(myActivity, R.layout.list_item_of_change_address);
        changeAddressListAdapter.setList(addressList);
        changeAddressListAdapter.setMyFragment(this);
    }


    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_ChangeAddressFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_ChangeAddressFrg);
        listViewAddresses = view.findViewById(R.id.listAddresses_ChangeAddressFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.checkOutFragment).commit();
            }
        });

        listViewAddresses.setAdapter(changeAddressListAdapter);

    }
}
