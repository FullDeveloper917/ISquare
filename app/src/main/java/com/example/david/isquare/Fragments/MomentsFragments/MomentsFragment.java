package com.example.david.isquare.Fragments.MomentsFragments;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.MomentsFollowingListAdapter;
import com.example.david.isquare.Adapters.MomentsListAdapter;
import com.example.david.isquare.Adapters.MomentsStaredListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Moment;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;


public class MomentsFragment extends Fragment {

    private Button btnAll;
    private Button btnFollowed;
    private Button btnStared;
    private Button btnAdd;
    private TextView txtIconMoments;

    private ListView listViewMoments;
    private List<Moment> momentList;
    private List<Moment> momentStaredList;
    private MomentsListAdapter momentsListAdapter;
    private MomentsFollowingListAdapter momentsFollowingListAdapter;
    private MomentsStaredListAdapter momentsStaredListAdapter;

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

        View view = inflater.inflate(R.layout.fragment_moments, container, false);

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
        momentsListAdapter = new MomentsListAdapter(myActivity, R.layout.list_item_of_moments);
        momentsListAdapter.setList(momentList);
        momentsListAdapter.setMyFragment(this);

        momentsFollowingListAdapter = new MomentsFollowingListAdapter(myActivity, R.layout.list_item_of_moments_following);
        momentsFollowingListAdapter.setList(momentList);
        momentsFollowingListAdapter.setMyFragment(this);

        momentStaredList = new ArrayList<>();
        momentStaredList.add(new Moment(true, false, myActivity.getResources().getDrawable(R.drawable.list_item_sample_of_moment1)));
        momentStaredList.add(new Moment(true, false, myActivity.getResources().getDrawable(R.drawable.raw_1505684833)));
        momentsStaredListAdapter = new MomentsStaredListAdapter(myActivity, R.layout.list_item_of_moments_stared);
        momentsStaredListAdapter.setList(momentStaredList);
        momentsStaredListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        btnAll = view.findViewById(R.id.btnAll_MomentsFrg);
        btnFollowed = view.findViewById(R.id.btnFollowed_MomentsFrg);
        btnStared = view.findViewById(R.id.btnStared_MomentsFrg);
        btnAdd = view.findViewById(R.id.btnAdd_MomentsFrg);

        txtIconMoments = view.findViewById(R.id.txtIconMoments_MomentsFrg);

        listViewMoments = view.findViewById(R.id.listMoments_MomentsFrg);
    }

    private void setFormula(){
        btnAll.setTypeface(iconFont);
        btnFollowed.setTypeface(iconFont);
        btnStared.setTypeface(iconFont);
        btnAdd.setTypeface(iconFont);
        txtIconMoments.setTypeface(iconFont);
    }

    private void setEvents(){
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAll.setTextColor(getResources().getColor(R.color.colorMyRed));
                btnFollowed.setTextColor(getResources().getColor(R.color.colorMyGray_6));
                btnStared.setTextColor(getResources().getColor(R.color.colorMyGray_6));
                listViewMoments.setAdapter(momentsListAdapter);
            }
        });

        btnFollowed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAll.setTextColor(getResources().getColor(R.color.colorMyGray_6));
                btnFollowed.setTextColor(getResources().getColor(R.color.colorMyRed));
                btnStared.setTextColor(getResources().getColor(R.color.colorMyGray_6));
                listViewMoments.setAdapter(momentsFollowingListAdapter);
            }
        });

        btnStared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAll.setTextColor(getResources().getColor(R.color.colorMyGray_6));
                btnFollowed.setTextColor(getResources().getColor(R.color.colorMyGray_6));
                btnStared.setTextColor(getResources().getColor(R.color.colorMyRed));
                listViewMoments.setAdapter(momentsStaredListAdapter);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.addNewPhotoFragment).commit();
            }
        });

        listViewMoments.setAdapter(momentsListAdapter);

    }

}
