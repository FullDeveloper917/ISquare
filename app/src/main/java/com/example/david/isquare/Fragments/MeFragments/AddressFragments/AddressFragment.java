package com.example.david.isquare.Fragments.MeFragments.AddressFragments;

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

import com.example.david.isquare.Adapters.AddressListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.HomeAddress;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class AddressFragment extends Fragment {
    private Button btnAdd;
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewAddresses;
    private List<HomeAddress> addressList;
    private AddressListAdapter addressListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_address, container, false);

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
    }

    private void findViews(View view){

        btnAdd = view.findViewById(R.id.btnAdd_AddressFrg);
        txtIconRtn = view.findViewById(R.id.txtIconRtn_AddressFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_AddressFrg);
        listViewAddresses = view.findViewById(R.id.listAddresses_AddressFrg);
    }

    private void setFormula(){
        btnAdd.setTypeface(iconFont);
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){
        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.usersFragment).commit();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.newAddressFragment).commit();
            }
        });

        addressList.add(new HomeAddress());
        addressList.add(new HomeAddress());
        addressList.add(new HomeAddress());

        addressListAdapter = new AddressListAdapter(myActivity, R.layout.list_item_of_address);
        addressListAdapter.setList(addressList);
        addressListAdapter.setMyFragment(this);

        listViewAddresses.setAdapter(addressListAdapter);

    }

}
