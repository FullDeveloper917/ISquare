package com.example.david.isquare.Fragments.AdminFragments.AdminWithdrawalFragments;

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

import com.example.david.isquare.Adapters.AdminChoosePlaceListAdapter;
import com.example.david.isquare.Adapters.AdminWithdrawalListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.AdminPlace;
import com.example.david.isquare.Objects.Withdrawal;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class AdminWithdrawalFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewWithdrawals;
    private AdminWithdrawalListAdapter adminWithdrawalListAdapter;
    private List<Withdrawal> withdrawalList;

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

        View view = inflater.inflate(R.layout.fragment_admin_withdrawal, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        withdrawalList = new ArrayList<>();
        withdrawalList.add(new Withdrawal(false));
        withdrawalList.add(new Withdrawal(true));
        withdrawalList.add(new Withdrawal(false));
        withdrawalList.add(new Withdrawal(true));
        withdrawalList.add(new Withdrawal(false));
        withdrawalList.add(new Withdrawal(true));
        withdrawalList.add(new Withdrawal(false));
        withdrawalList.add(new Withdrawal(true));
        adminWithdrawalListAdapter = new AdminWithdrawalListAdapter(myActivity, R.layout.list_item_of_admin_withdrawal);
        adminWithdrawalListAdapter.setMyFragment(this);
        adminWithdrawalListAdapter.setList(withdrawalList);
    }

    private void findViews(View view){
        txtIconRtn = view.findViewById(R.id.txtIconRtn_AdminWithdrawalFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_AdminWithdrawalFrg);
        listViewWithdrawals = view.findViewById(R.id.listWithdrawal_AdminWithdrawalFrg);
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
        listViewWithdrawals.setAdapter(adminWithdrawalListAdapter);
    }
}