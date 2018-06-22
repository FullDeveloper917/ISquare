package com.example.david.isquare.Fragments.AdminFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.AdminMomentListAdapter;
import com.example.david.isquare.Adapters.PartnerMomentsListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Moment;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class AdminMomentsFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewMoments;
    private List<Moment> momentList;
    private AdminMomentListAdapter momentsListAdapter;

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

        View view = inflater.inflate(R.layout.fragment_admin_moments, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        momentList = new ArrayList<>();
        momentList.add(new Moment(myActivity.getResources().getDrawable(R.drawable.list_item_sample_of_moment1)));
        momentList.add(new Moment(myActivity.getResources().getDrawable(R.drawable.raw_1505684833)));
        momentList.add(new Moment(myActivity.getResources().getDrawable(R.drawable.raw_1505829892)));
        momentsListAdapter = new AdminMomentListAdapter(myActivity, R.layout.list_item_of_moments);
        momentsListAdapter.setList(momentList);
        momentsListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_AdminMomentsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_AdminMomentsFrg);

        listViewMoments = view.findViewById(R.id.listMoments_AdminMomentsFrg);
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

        listViewMoments.setAdapter(momentsListAdapter);

    }
}
