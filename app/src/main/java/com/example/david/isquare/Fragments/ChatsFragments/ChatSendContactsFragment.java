package com.example.david.isquare.Fragments.ChatsFragments;

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

import com.example.david.isquare.Adapters.ChatSendContactsMemberListAdapter;
import com.example.david.isquare.Adapters.ContactGroupChatListAdapter;
import com.example.david.isquare.Adapters.GroupChatAddMemberListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.ContactHeader;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.GroupChatMember;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ChatSendContactsFragment extends Fragment {

    private LinearLayout layoutRtn;

    private ListView listViewMembers;
    private ChatSendContactsMemberListAdapter chatSendContactsMemberListAdapter;
    private List<ContactItem> memberList;

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

        View view = inflater.inflate(R.layout.fragment_chat_send_contacts, container, false);

        setInit();

        findViews(view);

        setFormula(view);

        setEvents();

        return view;
    }

    private void setInit(){
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        memberList = new ArrayList<>();
        memberList.add(new ContactHeader("A"));
        memberList.add(new GroupChatMember(false, true));
        memberList.add(new GroupChatMember(false, false));
        memberList.add(new ContactHeader("B"));
        memberList.add(new GroupChatMember(false, false));
        memberList.add(new GroupChatMember(false, true));
        memberList.add(new ContactHeader("C"));
        memberList.add(new GroupChatMember(false, true));
        memberList.add(new GroupChatMember(false, true));
        memberList.add(new ContactHeader("D"));
        memberList.add(new GroupChatMember(false, false));
        memberList.add(new GroupChatMember(false, true));

        chatSendContactsMemberListAdapter = new ChatSendContactsMemberListAdapter(myActivity, memberList);
        chatSendContactsMemberListAdapter.setMyFragment(this);
    }

    private void findViews(View view){
        layoutRtn = view.findViewById(R.id.layoutRtn_ChatSendContactsFrg);
        listViewMembers = view.findViewById(R.id.listMembers_ChatSendContactsFrg);
    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_ChatSendContactsFrg), iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().remove(ChatSendContactsFragment.this).commit();
            }
        });

        listViewMembers.setAdapter(chatSendContactsMemberListAdapter);

    }
}
