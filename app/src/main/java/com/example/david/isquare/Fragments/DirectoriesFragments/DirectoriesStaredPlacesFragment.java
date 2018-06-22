package com.example.david.isquare.Fragments.DirectoriesFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.david.isquare.Adapters.DirectoriesStaredPlaceListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Place;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class DirectoriesStaredPlacesFragment extends Fragment {

    private LinearLayout layoutRtn;

    private ListView listViewPlaces;
    private List<Place> placeList;
    private DirectoriesStaredPlaceListAdapter directoriesStaredPlaceListAdapter;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_directories_stared_places, container, false);

        setInit();

        findViews(view);

        setFormula(view);

        setEvents();

        return view;
    }

    private void setInit() {
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

        directoriesStaredPlaceListAdapter = new DirectoriesStaredPlaceListAdapter(myActivity, R.layout.list_item_of_place);
        directoriesStaredPlaceListAdapter.setList(placeList);
        directoriesStaredPlaceListAdapter.setMyFragment(this);
    }

    private void findViews(View view) {

        layoutRtn = view.findViewById(R.id.layoutRtn_DirectoriesStaredPlacesFrg);
        listViewPlaces = view.findViewById(R.id.listPlaces_DirectoriesStaredPlacesFrg);
    }

    private void setFormula(View view) {
        FontManager.setFontType(view.findViewById(R.id.layoutRtn_DirectoriesStaredPlacesFrg), iconFont);
    }

    private void setEvents() {
        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.directoriesFragment).commit();
            }
        });

        listViewPlaces.setAdapter(directoriesStaredPlaceListAdapter);

    }
}