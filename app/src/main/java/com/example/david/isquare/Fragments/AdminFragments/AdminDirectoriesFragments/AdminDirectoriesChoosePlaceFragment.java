package com.example.david.isquare.Fragments.AdminFragments.AdminDirectoriesFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Adapters.AdminChoosePlaceListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.AdminPlace;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class AdminDirectoriesChoosePlaceFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;
    private TextView txtIconSearch;

    private ExpandedListView listViewPlaces;
    private AdminChoosePlaceListAdapter adminChoosePlaceListAdapter;
    private List<AdminPlace> placeList;

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

        View view = inflater.inflate(R.layout.fragment_admin_directories_choose_place, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        placeList = new ArrayList<>();
        placeList.add(new AdminPlace(false));
        placeList.add(new AdminPlace(false));
        placeList.add(new AdminPlace(false));
        placeList.add(new AdminPlace(false));
        adminChoosePlaceListAdapter = new AdminChoosePlaceListAdapter(myActivity, R.layout.list_item_of_admin_choose_place);
        adminChoosePlaceListAdapter.setMyFragment(this);
        adminChoosePlaceListAdapter.setList(placeList);
    }

    private void findViews(View view){
        txtIconRtn = view.findViewById(R.id.txtIconRtn_AdminDirectoriesChoosePlaceFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_AdminDirectoriesChoosePlaceFrg);
        txtIconSearch = view.findViewById(R.id.txtIconSearch_AdminDirectoriesChoosePlaceFrg);
        listViewPlaces = view.findViewById(R.id.listPlaces_AdminDirectoriesChoosePlaceFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtIconSearch.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminDirectoriesFragment).commit();
            }
        });

        listViewPlaces.setAdapter(adminChoosePlaceListAdapter);
    }
}
