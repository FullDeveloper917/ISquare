package com.example.david.isquare.Fragments.MeFragments.MyMomentsFragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.AddNewPhotoAdapter;
import com.example.david.isquare.Adapters.CafeMondListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.CafeMond;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AddNewTextFragment extends Fragment {
    private Button btnRtn;
    private Button btnNext;

    private TextView txtIconCafeMond;

    private List<CafeMond> cafeMondList;
    private CafeMondListAdapter cafeMondListAdapter;

    private ListView listViewCafeMond;

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

        View view = inflater.inflate(R.layout.fragment_add_new_text, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){

        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);

        cafeMondList = new ArrayList<>();
        cafeMondList.add(new CafeMond());
        cafeMondList.add(new CafeMond());
        cafeMondList.add(new CafeMond());
        cafeMondList.add(new CafeMond());

        cafeMondListAdapter = new CafeMondListAdapter(myActivity, R.layout.list_item_of_cafe_mond);
        cafeMondListAdapter.setList(cafeMondList);

    }

    private void findViews(View view){

        btnRtn = view.findViewById(R.id.btnRtn_AddNewTextFrg);
        btnNext = view.findViewById(R.id.btnNext_AddNewTextFrg);
        txtIconCafeMond = view.findViewById(R.id.txtIconCafeMond_AddNewTextFrg);
        listViewCafeMond = view.findViewById(R.id.listCafeMond_AddTextFrg);

    }

    private void setFormula(){
        btnRtn.setTypeface(iconFont);
        btnNext.setTypeface(iconFont);
        txtIconCafeMond.setTypeface(iconFont);
    }

    private void setEvents(){
        btnRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.addNewPhotoFragment).commit();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.momentsFragment).commit();
            }
        });

        listViewCafeMond.setAdapter(cafeMondListAdapter);
    }
}
