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

import com.example.david.isquare.Adapters.PlaceReviewListAdapter;
import com.example.david.isquare.Adapters.ReviewListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Review;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class PlaceReviewsFragment extends Fragment {
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;
    private Button btnAdd;

    private ListView listViewReviews;
    private List<Review> reviewList;
    private PlaceReviewListAdapter reviewListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_place_reviews, container, false);

        setInit();

        findViews(view);

        setFormula(view);

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        reviewList = new ArrayList<>();

        reviewList.add(new Review("Interesting book", 0.0, ""));
        reviewList.add(new Review("Interesting book", 0.0, ""));

        reviewListAdapter = new PlaceReviewListAdapter(myActivity, R.layout.list_item_of_reviews);
        reviewListAdapter.setList(reviewList);
        reviewListAdapter.setMyFragment(this);
    }


    private void findViews(View view){
        layoutRtn = view.findViewById(R.id.layoutRtn_PlaceReviewsFrg);
        btnAdd = view.findViewById(R.id.btnAdd_PlaceReviewsFrg);
        listViewReviews = view.findViewById(R.id.listReviews_PlaceReviewsFrg);

    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_PlaceReviewsFrg), iconFont);
    }

    private void setEvents(){

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.placeLeaveReviewFragment).commit();
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.placeDetailsFragment).commit();
            }
        });

        listViewReviews.setAdapter(reviewListAdapter);

    }
}
