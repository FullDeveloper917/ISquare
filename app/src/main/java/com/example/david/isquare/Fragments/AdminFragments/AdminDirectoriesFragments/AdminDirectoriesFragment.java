package com.example.david.isquare.Fragments.AdminFragments.AdminDirectoriesFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.AdminAllMemberListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.ContactHeader;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.Follower;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class AdminDirectoriesFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;
    private TextView txtIconFirstLink;
    private TextView txtIconSecondLink;
    private LinearLayout layoutFirstLink;
    private LinearLayout layoutSecondLink;
    private ImageView imgFirst;
    private ImageView imgSecond;

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

        View view = inflater.inflate(R.layout.fragment_admin_directories, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
    }

    private void findViews(View view){
        txtIconRtn = view.findViewById(R.id.txtIconRtn_AdminDirectoriesFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_AdminDirectoriesFrg);
        txtIconFirstLink = view.findViewById(R.id.txtIconFirstLink_AdminDirectoriesFrg);
        txtIconSecondLink = view.findViewById(R.id.txtIconSecondLink_AdminDirectoriesFrg);
        layoutFirstLink = view.findViewById(R.id.layoutFirstLink_AdminDirectoriesFrg);
        layoutSecondLink = view.findViewById(R.id.layoutSecondLink_AdminDirectoriesFrg);
        imgFirst = view.findViewById(R.id.imgFirst_AdminDirectoriesFrg);
        imgSecond = view.findViewById(R.id.imgSecond_AdminDirectoriesFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtIconFirstLink.setTypeface(iconFont);
        txtIconSecondLink.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminFragment).commit();
            }
        });

        imgFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminDirectoriesChoosePhotoFragment).commit();
            }
        });

        imgSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminDirectoriesChoosePhotoFragment).commit();
            }
        });

        layoutFirstLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminDirectoriesChoosePlaceFragment).commit();
            }
        });

        layoutSecondLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminDirectoriesChoosePlaceFragment).commit();
            }
        });

    }
}