package com.example.david.isquare.Fragments.MeFragments.MyContactsFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.ContactListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.ContactButton;
import com.example.david.isquare.Objects.ContactHeader;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.Follower;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ContactsFragment  extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;
    private ListView listViewFollowers;
    private ContactListAdapter contactListAdapter;
    private List<ContactItem> contactItemList;

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

        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        contactItemList = new ArrayList<>();
        contactItemList.add(new ContactButton());
        contactItemList.add(new ContactButton());
        contactItemList.add(new ContactHeader("A"));
        contactItemList.add(new Follower("Anna Klein"));
        contactItemList.add(new Follower("Anna Brown"));
        contactItemList.add(new ContactHeader("B"));
        contactItemList.add(new Follower("Anna Klein"));
        contactItemList.add(new Follower("Anna Brown"));
        contactItemList.add(new ContactHeader("C"));
        contactItemList.add(new Follower("Anna Klein"));
        contactItemList.add(new Follower("Anna Brown"));
        contactItemList.add(new ContactHeader("D"));
        contactItemList.add(new Follower("Anna Klein"));
        contactItemList.add(new Follower("Anna Brown"));
        contactListAdapter = new ContactListAdapter(myActivity, contactItemList);
        contactListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_ContactsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_ContactsFrg);
        listViewFollowers = view.findViewById(R.id.listFollowers_ContactsFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.usersFragment).commit();
            }
        });

        listViewFollowers.setAdapter(contactListAdapter);

    }
}
