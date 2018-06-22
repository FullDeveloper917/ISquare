package com.example.david.isquare.Fragments.MeFragments.MyShopFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.ReviewListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Review;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ReviewsFragment extends Fragment {
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewReviews;
    private List<Review> reviewList;
    private ReviewListAdapter reviewListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_reviews, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        reviewList = new ArrayList<>();
        reviewList.add(new Review("Interesting book", 0.0, ""));
        reviewList.add(new Review("Interesting book", 0.0, ""));
        reviewList.add(new Review("Interesting book", 0.0, ""));
        reviewList.add(new Review("Interesting book", 0.0, ""));
        reviewList.add(new Review("Interesting book", 0.0, ""));
        reviewList.add(new Review("Interesting book", 0.0, ""));
        reviewList.add(new Review("Interesting book", 0.0, ""));
        reviewList.add(new Review("Interesting book", 0.0, ""));

        reviewListAdapter = new ReviewListAdapter(myActivity, R.layout.list_item_of_reviews);
        reviewListAdapter.setList(reviewList);
        reviewListAdapter.setMyFragment(this);
    }


    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_ReviewsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_ReviewsFrg);
        listViewReviews = view.findViewById(R.id.listReviews_ReviewsFrg);

    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myShopFragment).commit();
            }
        });

        listViewReviews.setAdapter(reviewListAdapter);

    }
}
