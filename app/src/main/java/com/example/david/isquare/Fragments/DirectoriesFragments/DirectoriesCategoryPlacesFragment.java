package com.example.david.isquare.Fragments.DirectoriesFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.DirectoriesCategoryPlaceListAdapter;
import com.example.david.isquare.Adapters.DirectoriesPlaceListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Place;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class DirectoriesCategoryPlacesFragment extends Fragment {

    private LinearLayout layoutRtn;
    private Button btnStar;

    private ExpandedListView listViewPlaces;

    private List<Place> placeList;

    private DirectoriesCategoryPlaceListAdapter directoriesCategoryPlaceListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_directories_category_places, container, false);

        setInit();
        findViews(view);
        setFormula(view);
        setEvents();
        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);

        placeList = new ArrayList<>();
        placeList.add(new Place(1021, 0.5, "ladies,spa,make-up"));
        placeList.add(new Place(170, 1, "tag or keywords.."));
        placeList.add(new Place(1021, 0.5, "ladies,spa,make-up"));
        placeList.add(new Place(170, 1, "tag or keywords.."));
        placeList.add(new Place(1021, 0.5, "ladies,spa,make-up"));
        placeList.add(new Place(170, 1, "tag or keywords.."));
        placeList.add(new Place(1021, 0.5, "ladies,spa,make-up"));
        placeList.add(new Place(170, 1, "tag or keywords.."));
        placeList.add(new Place(1021, 0.5, "ladies,spa,make-up"));
        placeList.add(new Place(170, 1, "tag or keywords.."));
        placeList.add(new Place(1021, 0.5, "ladies,spa,make-up"));
        placeList.add(new Place(170, 1, "tag or keywords.."));


        directoriesCategoryPlaceListAdapter = new DirectoriesCategoryPlaceListAdapter(myActivity, R.layout.list_item_of_shop);
        directoriesCategoryPlaceListAdapter.setList(placeList);
        directoriesCategoryPlaceListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        layoutRtn = view.findViewById(R.id.layoutRtn_DirectoriesCategoryPlacesFrg);
        btnStar = view.findViewById(R.id.btnStar_DirectoriesCategoryPlacesFrg);
        listViewPlaces = view.findViewById(R.id.listPlaces_DirectoriesCategoryPlacesFrg);
    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_DirectoriesCategoryPlacesFrg), iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.directoriesFragment).commit();
            }
        });

        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.directoriesStaredPlacesFragment).commit();
            }
        });

        listViewPlaces.setAdapter(directoriesCategoryPlaceListAdapter);
    }

}