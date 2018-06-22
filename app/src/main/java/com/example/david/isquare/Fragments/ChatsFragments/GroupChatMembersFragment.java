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
import android.widget.TextView;

import com.example.david.isquare.Adapters.CartListAdapter;
import com.example.david.isquare.Adapters.GroupChatMemberListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.CartFooterItem;
import com.example.david.isquare.Objects.CartHeaderItem;
import com.example.david.isquare.Objects.CartProductItem;
import com.example.david.isquare.Objects.CartUnitItem;
import com.example.david.isquare.Objects.GroupChatMember;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class GroupChatMembersFragment  extends Fragment {
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private Button btnNewMember;

    private ListView listViewMembers;
    private List<GroupChatMember> memberList;
    private GroupChatMemberListAdapter groupChatMemberListAdapter;

    private Typeface iconFont;

    private MainActivity myActivity;

    public MainActivity getMyActivity() {
        return myActivity;
    }

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group_chat_members, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        memberList = new ArrayList<>();
        memberList.add(new GroupChatMember(true, false));
        memberList.add(new GroupChatMember(false, false));
        memberList.add(new GroupChatMember(true, false));
        memberList.add(new GroupChatMember(false, false));
        memberList.add(new GroupChatMember(true, false));
        memberList.add(new GroupChatMember(false, false));
        memberList.add(new GroupChatMember(true, false));
        memberList.add(new GroupChatMember(false, false));
        memberList.add(new GroupChatMember(true, false));
        memberList.add(new GroupChatMember(false, false));
        memberList.add(new GroupChatMember(true, false));
        memberList.add(new GroupChatMember(false, false));

        groupChatMemberListAdapter = new GroupChatMemberListAdapter(myActivity, R.layout.list_item_of_chat_members);
        groupChatMemberListAdapter.setList(memberList);
        groupChatMemberListAdapter.setMyFragment(this);
    }


    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_GroupChatMembersFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_GroupChatMembersFrg);
        btnNewMember = view.findViewById(R.id.btnNewMember_GroupChatMembersFrg);
        listViewMembers = view.findViewById(R.id.listMembers_GroupChatMembersFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        btnNewMember.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.chatsFragment).commit();
            }
        });

        btnNewMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.groupChatAddMembersFragment).commit();
            }
        });


        listViewMembers.setAdapter(groupChatMemberListAdapter);
    }
}
