package com.example.david.isquare.Fragments.MomentsFragments;

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

import com.example.david.isquare.Adapters.MomentsListAdapter;
import com.example.david.isquare.Adapters.PartnerMomentsListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Moment;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class MomentsPartnerFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;
    private Button btnInfo;

    private ListView listViewMoments;
    private List<Moment> momentList;
    private PartnerMomentsListAdapter momentsListAdapter;

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

        View view = inflater.inflate(R.layout.fragment_moments_partner, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        momentList = new ArrayList<>();
        momentList.add(new Moment(myActivity.getResources().getDrawable(R.drawable.list_item_sample_of_moment1)));
        momentList.add(new Moment(myActivity.getResources().getDrawable(R.drawable.raw_1505684833)));
        momentList.add(new Moment(myActivity.getResources().getDrawable(R.drawable.raw_1505829892)));
        momentList.add(new Moment(myActivity.getResources().getDrawable(R.drawable.raw_1505684833)));
        momentList.add(new Moment(myActivity.getResources().getDrawable(R.drawable.raw_1505829908)));
        momentsListAdapter = new PartnerMomentsListAdapter(myActivity, R.layout.list_item_of_moments);
        momentsListAdapter.setList(momentList);
        momentsListAdapter.setMyFragment(this);

    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_MomentsPartnerFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_MomentsPartnerFrg);
        btnInfo = view.findViewById(R.id.btnInfo_MomentsPartnerFrg);

        listViewMoments = view.findViewById(R.id.listMoments_MomentsPartnerFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        btnInfo.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.momentsFragment).commit();
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.addNewPhotoFragment).commit();
            }
        });

        listViewMoments.setAdapter(momentsListAdapter);

    }
}
