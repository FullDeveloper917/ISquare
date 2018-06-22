package com.example.david.isquare.Fragments.DirectoriesFragments;

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

import com.example.david.isquare.Adapters.PartnerMomentsListAdapter;
import com.example.david.isquare.Adapters.PlaceMomentsListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Moment;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class PlaceMomentsFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;
    private Button btnInfo;

    private ListView listViewMoments;
    private List<Moment> momentList;
    private PlaceMomentsListAdapter momentsListAdapter;

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

        View view = inflater.inflate(R.layout.fragment_place_moments, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        momentList = new ArrayList<>();
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_PlaceMomentsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_PlaceMomentsFrg);
        listViewMoments = view.findViewById(R.id.listMoments_PlaceMomentsFrg);

    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.placeDetailsFragment).commit();
            }
        });

        momentList.add(new Moment(true, false, myActivity.getResources().getDrawable(R.drawable.raw_1505684833)));
        momentList.add(new Moment(true, false, myActivity.getResources().getDrawable(R.drawable.raw_1505684833)));
        momentList.add(new Moment(true, false, myActivity.getResources().getDrawable(R.drawable.raw_1505684833)));
        momentsListAdapter = new PlaceMomentsListAdapter(myActivity, R.layout.list_item_of_moments);
        momentsListAdapter.setList(momentList);
        momentsListAdapter.setMyFragment(this);

        listViewMoments.setAdapter(momentsListAdapter);

    }
}
