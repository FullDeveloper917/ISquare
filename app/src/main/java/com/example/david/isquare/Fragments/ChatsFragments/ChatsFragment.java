package com.example.david.isquare.Fragments.ChatsFragments;

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

import com.example.david.isquare.Adapters.ChatBlockListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.ChatBlock;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ChatsFragment extends Fragment {

    private Button btnMenu;
    private LinearLayout layoutMenu;
    private LinearLayout layoutMenuContacts;
    private LinearLayout layoutMenuGroupChat;
    private LinearLayout layoutMenuSupport;

    private TextView txtIconChats;
    private ListView listViewChatBlocks;
    private ChatBlockListAdapter chatBlockListAdapter;
    private List<ChatBlock> chatBlockList;


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
        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        setInit();
        findViews(view);
        setFormula(view);
        setEvents();
        return view;

    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        chatBlockListAdapter = new ChatBlockListAdapter(myActivity, R.layout.list_item_of_chat_block);
        chatBlockList = new ArrayList<>();
        chatBlockList.add(new ChatBlock("Denis Baks", "Hello, How are you?....", "18:34", false, false));
        chatBlockList.add(new ChatBlock("Denis Baks", "Hello, How are you?....", "18:34", true, false));
        chatBlockList.add(new ChatBlock("Denis Baks", "Hello, How are you?....", "18:34", false, true));
        chatBlockList.add(new ChatBlock("Denis Baks", "Hello, How are you?....", "18:34", true, true));
        chatBlockList.add(new ChatBlock("Busy & Sell in HK, Shatin", "Hello, How are you?....", "18:34", false, true));
        chatBlockList.add(new ChatBlock("Busy & Sell in HK, Shatin", "Hello, How are you?....", "18:34", true, true));
        chatBlockList.add(new ChatBlock("Busy & Sell in HK, Shatin", "Hello, How are you?....", "18:34", false, true));
        chatBlockList.add(new ChatBlock("Denis Baks", "Hello, How are you?....", "18:34", true, true));
        chatBlockList.add(new ChatBlock("Denis Baks", "Hello, How are you?....", "18:34", true, true));
        chatBlockList.add(new ChatBlock("Busy & Sell in HK, Shatin", "Hello, How are you?....", "18:34", false, false));
        chatBlockList.add(new ChatBlock("Denis Baks", "Hello, How are you?....", "18:34", false, true));
        chatBlockList.add(new ChatBlock("Busy & Sell in HK, Shatin", "Hello, How are you?....", "18:34", true, true));
        chatBlockList.add(new ChatBlock("Denis Baks", "Hello, How are you?....", "18:34", true, true));
        chatBlockList.add(new ChatBlock("Denis Baks", "Hello, How are you?....", "18:34", false, false));
        chatBlockList.add(new ChatBlock("Denis Baks", "Hello, How are you?....", "18:34", true, true));
        chatBlockList.add(new ChatBlock("Busy & Sell in HK, Shatin", "Hello, How are you?....", "18:34", true, false));
        chatBlockList.add(new ChatBlock("Busy & Sell in HK, Shatin", "Hello, How are you?....", "18:34", true, false));
        chatBlockList.add(new ChatBlock("Denis Baks", "Hello, How are you?....", "18:34", true, true));
        chatBlockList.add(new ChatBlock("Denis Baks", "Hello, How are you?....", "18:34", false, true));
        chatBlockList.add(new ChatBlock("Busy & Sell in HK, Shatin", "Hello, How are you?....", "18:34", true, true));

        chatBlockListAdapter.setList(chatBlockList);
        chatBlockListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        btnMenu = view.findViewById(R.id.btnMenu_ChatsFrg);
        txtIconChats = view.findViewById(R.id.txtIconChats_ChatsFrg);
        listViewChatBlocks = view.findViewById(R.id.listChatBlocks_ChatsFrg);

        layoutMenu = view.findViewById(R.id.layoutMenu_ChatsFrg);
        layoutMenuContacts = view.findViewById(R.id.layoutMenuContacts_ChatsFrg);
        layoutMenuGroupChat = view.findViewById(R.id.layoutMenuGroupChat_ChatsFrg);
        layoutMenuSupport = view.findViewById(R.id.layoutMenuSupport_ChatsFrg);
    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_ChatsFrg), iconFont);
    }

    private void setEvents(){

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layoutMenu.getVisibility() == View.VISIBLE){
                    layoutMenu.setVisibility(View.GONE);
                }
                else {
                    layoutMenu.setVisibility(View.VISIBLE);
                }
            }
        });

        layoutMenuContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.contactsFragment).commit();
            }
        });

        layoutMenuGroupChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.createGroupChatFragment).commit();
            }
        });

        layoutMenuSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.singleChatFragment).commit();
            }
        });


        listViewChatBlocks.setAdapter(chatBlockListAdapter);
    }

}
