package com.example.david.isquare.Fragments.MeFragments.MyContactsFragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Adapters.ContactGroupChatListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.ChatGroup;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ContactGroupChatsFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ExpandedListView listViewChatGroup;
    private ContactGroupChatListAdapter contactGroupChatListAdapter;
    private List<ChatGroup> chatGroupList;

    private TextView txtIconSearch;

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

        View view = inflater.inflate(R.layout.fragment_contact_group_chats, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        chatGroupList = new ArrayList<>();
        chatGroupList.add(new ChatGroup("Buy & Sale in Guangzhou"));
        chatGroupList.add(new ChatGroup("Rent apartment in HK"));
        chatGroupList.add(new ChatGroup("学习英文"));
        contactGroupChatListAdapter = new ContactGroupChatListAdapter(myActivity, R.layout.list_item_of_contact_group_chats);
        contactGroupChatListAdapter.setList(chatGroupList);
        contactGroupChatListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_ContactGroupChatsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_ContactGroupChatsFrg);
        listViewChatGroup = view.findViewById(R.id.listChatGroups_ContactGroupChatsFrg);
        txtIconSearch = view.findViewById(R.id.txtIconSearch_ContactGroupChatsFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        txtIconSearch.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.contactsFragment).commit();
            }
        });

        listViewChatGroup.setAdapter(contactGroupChatListAdapter);

    }
}
