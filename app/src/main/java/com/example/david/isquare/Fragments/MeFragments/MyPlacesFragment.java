package com.example.david.isquare.Fragments.MeFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.MyPlaceListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.MyPlace;
import com.example.david.isquare.Objects.Place;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;


public class MyPlacesFragment extends Fragment {

    private Button btnAdd;
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewMyPlaces;
    private List<Place> myPlaceList;
    private MyPlaceListAdapter myPlaceListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_my_places, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);

        myPlaceList = new ArrayList<>();
        myPlaceList.add(new Place(1021, 1, ""));
        myPlaceList.add(new Place(1021, 1, ""));
        myPlaceList.add(new Place(1021, 1, ""));
        myPlaceList.add(new Place(1021, 1, ""));
        myPlaceList.add(new Place(1021, 1, ""));
        myPlaceList.add(new Place(1021, 1, ""));
        myPlaceList.add(new Place(1021, 1, ""));
        myPlaceList.add(new Place(1021, 1, ""));
        myPlaceList.add(new Place(1021, 1, ""));
        myPlaceList.add(new Place(1021, 1, ""));


        myPlaceListAdapter = new MyPlaceListAdapter(myActivity, R.layout.list_item_of_my_places);
        myPlaceListAdapter.setList(myPlaceList);
        myPlaceListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        btnAdd = view.findViewById(R.id.btnAdd_MyPlacesFrg);
        txtIconRtn = view.findViewById(R.id.txtIconRtn_MyPlacesFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_MyPlacesFrg);
        listViewMyPlaces = view.findViewById(R.id.listPlaces_MyPlacesFrg);
    }

    private void setFormula(){
        btnAdd.setTypeface(iconFont);
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){
        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.usersFragment).commit();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.addPlaceFirstFragment).commit();
            }
        });

        listViewMyPlaces.setAdapter(myPlaceListAdapter);

    }


}
