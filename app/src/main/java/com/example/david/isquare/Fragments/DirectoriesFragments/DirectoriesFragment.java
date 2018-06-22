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

import com.example.david.isquare.Adapters.DirectoriesPlaceListAdapter;
import com.example.david.isquare.Adapters.ShopListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Place;
import com.example.david.isquare.Objects.Shop;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class DirectoriesFragment extends Fragment {

    private Button btnStar;

    private LinearLayout layoutFirstMenuButton;
    private LinearLayout layoutSecondMenuButton;
    private LinearLayout layoutThirdMenuButton;
    private LinearLayout layoutFirstMenuMainMenu;

    private ExpandedListView listViewPlaces;
    private ListView listSubMenu;
    private DrawerLayout drawerLayoutFirst;
    private LinearLayout layoutFirstMenu;
    private boolean allMenuOpened;

    private List<Place> placeList;

    private List<String> subMenuList;
    private ArrayAdapter<String> subMenuListAdapter;

    private DirectoriesPlaceListAdapter directoriesPlaceListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_directories, container, false);

        setInit();
        findViews(view);
        setFormula(view);
        setEvents();
        return view;
    }

    private void setInit(){
        allMenuOpened = false;
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);

        subMenuList = new ArrayList<>();
        for (String s: myActivity.getResources().getStringArray(R.array.directories_first_menu_shops_sub_menus)){
            subMenuList.add(s);
        }

        subMenuListAdapter = new ArrayAdapter<String>(myActivity, android.R.layout.simple_list_item_1, subMenuList){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView=(TextView) view.findViewById(android.R.id.text1);
                textView.setHeight(convertSpToPixels(50) + 2);

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity)
                    }
                });
                return view;
            }
        };

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


        directoriesPlaceListAdapter = new DirectoriesPlaceListAdapter(myActivity, R.layout.list_item_of_shop);
        directoriesPlaceListAdapter.setList(placeList);
        directoriesPlaceListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        myActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;
        int screenWidth = displayMetrics.widthPixels;

        btnStar = view.findViewById(R.id.btnStar_DirectoriesFrg);

        layoutFirstMenuButton = view.findViewById(R.id.layoutFirstMenuButton_DirectoriesFrg);
        layoutSecondMenuButton = view.findViewById(R.id.layoutSecondMenuButton_DirectoriesFrg);
        layoutThirdMenuButton = view.findViewById(R.id.layoutThirdMenuButton_DirectoriesFrg);

        layoutFirstMenuMainMenu = view.findViewById(R.id.layoutFirstMenuMainMenu_DirectoriesFrg);

        listViewPlaces = view.findViewById(R.id.listPlaces_DirectoriesFrg);
        listSubMenu = view.findViewById(R.id.listSubMenu_DirectoriesFrg);
        drawerLayoutFirst = view.findViewById(R.id.drawerLayoutFirst_DirectoriesFrg);
        layoutFirstMenu = view.findViewById(R.id.layoutFirstMenu_DirectoriesFrg);
        layoutFirstMenu.getLayoutParams().width = screenWidth;
    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_DirectoriesFrg), iconFont);
        drawerLayoutFirst.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    private void setEvents(){

        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.directoriesStaredPlacesFragment).commit();
            }
        });

        layoutFirstMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allMenuOpened)
                    drawerLayoutFirst.closeDrawer(layoutFirstMenu);
                else
                    drawerLayoutFirst.openDrawer(layoutFirstMenu);
                allMenuOpened = !allMenuOpened;
            }
        });

        layoutFirstMenuMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.directoriesCategoryPlacesFragment).commit();
            }
        });

        listViewPlaces.setAdapter(directoriesPlaceListAdapter);
        listSubMenu.setAdapter(subMenuListAdapter);
    }

    public int convertSpToPixels(float sp) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, myActivity.getResources().getDisplayMetrics());
        return px;
    }

}