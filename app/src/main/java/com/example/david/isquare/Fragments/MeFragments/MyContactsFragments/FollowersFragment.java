package com.example.david.isquare.Fragments.MeFragments.MyContactsFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.ContactListAdapter;
import com.example.david.isquare.Adapters.FollowerListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.ContactButton;
import com.example.david.isquare.Objects.ContactHeader;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.Follower;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class FollowersFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewFollowers;
    private FollowerListAdapter followerListAdapter;
    private List<ContactItem> followerList;

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

        View view = inflater.inflate(R.layout.fragment_followers, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        followerList = new ArrayList<>();
        followerList.add(new ContactHeader("A"));
        followerList.add(new Follower("Anna Klein"));
        followerList.add(new Follower("Anna Brown"));
        followerList.add(new ContactHeader("B"));
        followerList.add(new Follower("Anna Klein"));
        followerList.add(new Follower("Anna Brown"));
        followerList.add(new ContactHeader("C"));
        followerList.add(new Follower("Anna Klein"));
        followerList.add(new Follower("Anna Brown"));
        followerList.add(new ContactHeader("D"));
        followerList.add(new Follower("Anna Klein"));
        followerList.add(new Follower("Anna Brown"));
        followerListAdapter = new FollowerListAdapter(myActivity, followerList);
        followerListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_FollowersFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_FollowersFrg);
        listViewFollowers = view.findViewById(R.id.listFollowers_FollowersFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.contactsFragment).commit();
            }
        });

        listViewFollowers.setAdapter(followerListAdapter);

    }
}
