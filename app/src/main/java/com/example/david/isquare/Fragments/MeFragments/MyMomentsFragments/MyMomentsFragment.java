package com.example.david.isquare.Fragments.MeFragments.MyMomentsFragments;

import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.ImageAdapter;
import com.example.david.isquare.Adapters.MomentsGridAdapter;
import com.example.david.isquare.Adapters.MomentsListAdapter;
import com.example.david.isquare.Adapters.MyMomentsListAdapter;
import com.example.david.isquare.Adapters.MyMomentsStaredListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Moment;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class  MyMomentsFragment extends Fragment {
    private Button btnGrid;
    private Button btnList;
    private Button btnStared;
    private Button btnAdd;

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewMoments;
    private List<Moment> myMomentList;
    private List<Moment> staredMomentList;
    private MyMomentsListAdapter myMomentsListAdapter;
    private MyMomentsStaredListAdapter myMomentsStaredListAdapter;

    private GridView gridViewMoments;
    private MomentsGridAdapter momentsGridAdapter;

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

        View view = inflater.inflate(R.layout.fragment_my_moments, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        myMomentList = new ArrayList<>();
        myMomentList.add(new Moment(false, false, myActivity.getResources().getDrawable(R.drawable.list_item_sample_of_moment1)));
        myMomentList.add(new Moment(true, false, myActivity.getResources().getDrawable(R.drawable.raw_1505684833)));
        myMomentList.add(new Moment(true, false, myActivity.getResources().getDrawable(R.drawable.raw_1505829892)));
        myMomentList.add(new Moment(true, false, myActivity.getResources().getDrawable(R.drawable.raw_1505684833)));
        myMomentList.add(new Moment(true, false, myActivity.getResources().getDrawable(R.drawable.raw_1505829908)));
        myMomentsListAdapter = new MyMomentsListAdapter(myActivity, R.layout.list_item_of_moments);
        myMomentsListAdapter.setList(myMomentList);
        myMomentsListAdapter.setMyFragment(this);

        staredMomentList = new ArrayList<>();
        staredMomentList.add(new Moment(true, false, myActivity.getResources().getDrawable(R.drawable.list_item_sample_of_moment1)));
        staredMomentList.add(new Moment(true, false, myActivity.getResources().getDrawable(R.drawable.raw_1505684833)));
        myMomentsStaredListAdapter = new MyMomentsStaredListAdapter(myActivity, R.layout.list_item_of_moments);
        myMomentsStaredListAdapter.setList(staredMomentList);
        myMomentsStaredListAdapter.setMyFragment(this);

        momentsGridAdapter = new MomentsGridAdapter(myActivity);
        momentsGridAdapter.setList(myMomentList);
    }

    private void findViews(View view){

        btnGrid = view.findViewById(R.id.btnGrid_MyMomentsFrg);
        btnList = view.findViewById(R.id.btnList_MyMomentsFrg);
        btnStared = view.findViewById(R.id.btnStared_MyMomentsFrg);
        btnAdd = view.findViewById(R.id.btnAdd_MyMomentsFrg);

        txtIconRtn = view.findViewById(R.id.txtIconRtn_MyMomentsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_MyMomentsFrg);

        listViewMoments = view.findViewById(R.id.listMoments_MyMomentsFrg);
        gridViewMoments = view.findViewById(R.id.gridMoments_MyMomentsFrg);
    }

    private void setFormula(){
        btnGrid.setTypeface(iconFont);
        btnList.setTypeface(iconFont);
        btnStared.setTypeface(iconFont);
        btnAdd.setTypeface(iconFont);
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGrid.setTextColor(getResources().getColor(R.color.colorMyRed));
                btnList.setTextColor(getResources().getColor(R.color.colorMyGray_4));
                btnStared.setTextColor(getResources().getColor(R.color.colorMyGray_4));
                gridViewMoments.setVisibility(View.VISIBLE);
                listViewMoments.setVisibility(View.GONE);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGrid.setTextColor(getResources().getColor(R.color.colorMyGray_4));
                btnList.setTextColor(getResources().getColor(R.color.colorMyRed));
                btnStared.setTextColor(getResources().getColor(R.color.colorMyGray_4));
                gridViewMoments.setVisibility(View.GONE);
                listViewMoments.setVisibility(View.VISIBLE);
                listViewMoments.setAdapter(myMomentsListAdapter);
            }
        });

        btnStared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGrid.setTextColor(getResources().getColor(R.color.colorMyGray_4));
                btnList.setTextColor(getResources().getColor(R.color.colorMyGray_4));
                btnStared.setTextColor(getResources().getColor(R.color.colorMyRed));
                gridViewMoments.setVisibility(View.GONE);
                listViewMoments.setVisibility(View.VISIBLE);
                listViewMoments.setAdapter(myMomentsStaredListAdapter);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.addNewPhotoFragment).commit();
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.usersFragment).commit();
            }
        });

        listViewMoments.setAdapter(myMomentsListAdapter);
        gridViewMoments.setAdapter(momentsGridAdapter);
    }
}
