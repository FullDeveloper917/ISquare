package com.example.david.isquare.Fragments.ShopFragments;

import android.graphics.Typeface;
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

import com.example.david.isquare.Adapters.ShopListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Shop;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;


public class ShopFragment extends Fragment {

    private Button btnCart;
    private Button btnSearch;
    private Button btnStar;

    private TextView txtSubIconFirst;
    private TextView txtSubIconSecond;

    private LinearLayout layoutFirstMenuButton;
    private LinearLayout layoutSecondMenuButton;
    private LinearLayout layoutThirdMenuButton;

    private ExpandedListView listViewLatestAdded;
    private ExpandedListView listViewBestSellers;
    private List<Shop> latestAddedList;
    private List<Shop> bestSellersList;
    
    private DrawerLayout drawerLayout;
    private LinearLayout layoutFirstMenu;
    private boolean firstMenuOpened;
    private ListView listFirstSubMenu;
    private List<String> firstSubMenuList;
    private ArrayAdapter<String> firstSubMenuListAdapter;

    private LinearLayout layoutSecondMenu;
    private boolean secondMenuOpened;
    private ListView listSecondSubMenu;
    private List<String> secondSubMenuList;
    private ArrayAdapter<String> secondSubMenuListAdapter;

    private ShopListAdapter latestAddedListAdapter;
    private ShopListAdapter bestSellersListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        setInit();
        findViews(view);
        setFormula(view);
        setEvents();
        return view;
    }

    private void setInit(){
        firstMenuOpened = false;
        secondMenuOpened = false;
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);

        firstSubMenuList = new ArrayList<>();
        for (String s: myActivity.getResources().getStringArray(R.array.shop_first_menu_dish_sub_menus)){
            firstSubMenuList.add(s);
        }

        secondSubMenuList = new ArrayList<>();
        for (String s: myActivity.getResources().getStringArray(R.array.china_cities)){
            secondSubMenuList.add(s);
        }

        firstSubMenuListAdapter = new ArrayAdapter<String>(myActivity, android.R.layout.simple_list_item_1, firstSubMenuList){

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

        secondSubMenuListAdapter = new ArrayAdapter<String>(myActivity, android.R.layout.simple_list_item_1, secondSubMenuList){

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

        latestAddedList = new ArrayList<>();
        latestAddedList.add(new Shop());
        latestAddedList.add(new Shop());
        latestAddedList.add(new Shop());
        latestAddedList.add(new Shop());
        latestAddedList.add(new Shop());

        bestSellersList = new ArrayList<>();
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());
        bestSellersList.add(new Shop());

        latestAddedListAdapter = new ShopListAdapter(myActivity, R.layout.list_item_of_shop);
        latestAddedListAdapter.setList(latestAddedList);
        latestAddedListAdapter.setMyFragment(this);
        bestSellersListAdapter = new ShopListAdapter(myActivity, R.layout.list_item_of_shop);
        bestSellersListAdapter.setList(bestSellersList);
        bestSellersListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        myActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;
        int screenWidth = displayMetrics.widthPixels;

        btnCart = view.findViewById(R.id.btnCart_ShopFrg);
        btnSearch = view.findViewById(R.id.btnSearch_ShopFrg);
        btnStar = view.findViewById(R.id.btnStar_ShopFrg);

        layoutFirstMenuButton = view.findViewById(R.id.layoutFirstMenuButton_ShopFrg);
        layoutSecondMenuButton = view.findViewById(R.id.layoutSecondMenuButton_ShopFrg);
        layoutThirdMenuButton = view.findViewById(R.id.layoutThirdMenuButton_ShopFrg);

        listViewLatestAdded = view.findViewById(R.id.listLatestAdded_ShopFrg);
        listViewBestSellers = view.findViewById(R.id.listBestSellers_ShopFrg);
        
        drawerLayout = view.findViewById(R.id.drawerLayout_ShopFrg);
        txtSubIconFirst = view.findViewById(R.id.txtSubIconFirst_ShopFrg);
        txtSubIconSecond = view.findViewById(R.id.txtSubIconSecond_ShopFrg);
        listFirstSubMenu = view.findViewById(R.id.listFirstSubMenu_ShopFrg);        
        layoutFirstMenu = view.findViewById(R.id.layoutFirstMenu_ShopFrg);
        layoutFirstMenu.getLayoutParams().width = screenWidth;

        listSecondSubMenu = view.findViewById(R.id.listSecondSubMenu_ShopFrg);
        layoutSecondMenu = view.findViewById(R.id.layoutSecondMenu_ShopFrg);
        layoutSecondMenu.getLayoutParams().width = screenWidth;
    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_ShopFrg), iconFont);
    }

    private void setEvents(){

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.myCartFragment).commit();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.shopSearchFragment).commit();
            }
        });

        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.staredShopFragment).commit();
            }
        });

        layoutFirstMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstMenuOpened) {
                    drawerLayout.closeDrawer(layoutFirstMenu);
                    txtSubIconFirst.setTextColor(myActivity.getResources().getColor(R.color.colorMyDarkBlue));
                }
                else {
                    drawerLayout.openDrawer(layoutFirstMenu);
                    drawerLayout.closeDrawer(layoutSecondMenu);
                    txtSubIconFirst.setTextColor(myActivity.getResources().getColor(R.color.colorMyRed));
                    secondMenuOpened = false;
                }
                firstMenuOpened = !firstMenuOpened;
            }
        });

        layoutSecondMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secondMenuOpened) {
                    drawerLayout.closeDrawer(layoutSecondMenu);
                    txtSubIconSecond.setTextColor(myActivity.getResources().getColor(R.color.colorMyDarkBlue));
                }
                else {
                    drawerLayout.openDrawer(layoutSecondMenu);
                    drawerLayout.closeDrawer(layoutFirstMenu);
                    txtSubIconSecond.setTextColor(myActivity.getResources().getColor(R.color.colorMyRed));
                    firstMenuOpened = false;
                }
                secondMenuOpened = !secondMenuOpened;
            }
        });

        listViewLatestAdded.setAdapter(latestAddedListAdapter);
        listViewBestSellers.setAdapter(bestSellersListAdapter);
        listFirstSubMenu.setAdapter(firstSubMenuListAdapter);
        listSecondSubMenu.setAdapter(secondSubMenuListAdapter);
    }

    public int convertSpToPixels(float sp) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, myActivity.getResources().getDisplayMetrics());
        return px;
    }

}
