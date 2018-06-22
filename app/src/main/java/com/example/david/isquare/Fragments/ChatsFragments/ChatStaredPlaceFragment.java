package com.example.david.isquare.Fragments.ChatsFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.david.isquare.Adapters.ChatStaredPlaceListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Place;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ChatStaredPlaceFragment extends Fragment {

    private LinearLayout layoutRtn;

    private ListView listViewPlaces;
    private List<Place> placeList;
    private ChatStaredPlaceListAdapter chatStaredPlaceListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_chat_stared_place, container, false);

        setInit();

        findViews(view);

        setFormula(view);

        setEvents();

        return view;
    }

    private void setInit() {
        myActivity.layoutControlTab.setVisibility(View.GONE);
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

        chatStaredPlaceListAdapter = new ChatStaredPlaceListAdapter(myActivity, R.layout.list_item_of_place);
        chatStaredPlaceListAdapter.setList(placeList);
        chatStaredPlaceListAdapter.setMyFragment(this);
    }

    private void findViews(View view) {

        layoutRtn = view.findViewById(R.id.layoutRtn_ChatStaredPlacesFrg);
        listViewPlaces = view.findViewById(R.id.listPlaces_ChatStaredPlacesFrg);
    }

    private void setFormula(View view) {
        FontManager.setFontType(view.findViewById(R.id.layoutRtn_ChatStaredPlacesFrg), iconFont);
    }

    private void setEvents() {
        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().remove(ChatStaredPlaceFragment.this).commit();
            }
        });

        listViewPlaces.setAdapter(chatStaredPlaceListAdapter);

    }
}
