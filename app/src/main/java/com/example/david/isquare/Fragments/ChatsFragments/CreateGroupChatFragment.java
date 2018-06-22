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
import android.widget.ListView;

import com.example.david.isquare.Adapters.CreateGroupChatMemberListAdapter;
import com.example.david.isquare.Adapters.GroupChatAddMemberListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.ContactHeader;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.ContactSearchView;
import com.example.david.isquare.Objects.GroupChatMember;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class CreateGroupChatFragment extends Fragment {

    private Button btnRtn;
    private Button btnNext;

    private ListView listViewMembers;
    private CreateGroupChatMemberListAdapter createGroupChatMemberListAdapter;
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

        View view = inflater.inflate(R.layout.fragment_create_group_chat, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        memberList = new ArrayList<>();
        memberList.add(new ContactSearchView());
        memberList.add(new ContactHeader("A"));
        memberList.add(new GroupChatMember(false, true));
        memberList.add(new GroupChatMember(false, true));
        memberList.add(new ContactHeader("B"));
        memberList.add(new GroupChatMember(false, true));
        memberList.add(new GroupChatMember(false, true));
        memberList.add(new ContactHeader("C"));
        memberList.add(new GroupChatMember(false, true));
        memberList.add(new GroupChatMember(false, true));
        memberList.add(new ContactHeader("D"));
        memberList.add(new GroupChatMember(false, true));
        memberList.add(new GroupChatMember(false, true));

        createGroupChatMemberListAdapter = new CreateGroupChatMemberListAdapter(myActivity, memberList);
        createGroupChatMemberListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        btnRtn = view.findViewById(R.id.btnRtn_CreateGroupChatFrg);
        btnNext = view.findViewById(R.id.btnNext_CreateGroupChatFrg);
        listViewMembers = view.findViewById(R.id.listMembers_CreateGroupChatFrg);
    }

    private void setFormula(){
        btnRtn.setTypeface(iconFont);
        btnNext.setTypeface(iconFont);
    }

    private void setEvents(){

        btnRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.chatsFragment).commit();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.groupChatFragment).commit();
            }
        });

        listViewMembers.setAdapter(createGroupChatMemberListAdapter);

    }
}
