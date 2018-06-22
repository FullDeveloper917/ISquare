package com.example.david.isquare.Fragments.AdminFragments;

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

import com.example.david.isquare.Adapters.AdminAllMemberListAdapter;
import com.example.david.isquare.Adapters.FollowerListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.ContactHeader;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.Follower;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class AdminAllMembersFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewMembers;
    private AdminAllMemberListAdapter adminAllMemberListAdapter;
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

        View view = inflater.inflate(R.layout.fragment_admin_all_members, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        memberList = new ArrayList<>();
        memberList.add(new ContactHeader("Today (2)"));
        memberList.add(new Follower("Anna Klein"));
        memberList.add(new Follower("Anna Brown"));
        memberList.add(new ContactHeader("Yesterday (2)"));
        memberList.add(new Follower("Anna Klein"));
        memberList.add(new Follower("Anna Brown"));
        memberList.add(new ContactHeader("Last week (4)"));
        memberList.add(new Follower("Anna Klein"));
        memberList.add(new Follower("Anna Brown"));
        memberList.add(new ContactHeader("Latest"));
        memberList.add(new Follower("Anna Klein"));
        memberList.add(new Follower("Anna Brown"));
        adminAllMemberListAdapter = new AdminAllMemberListAdapter(myActivity, memberList);
        adminAllMemberListAdapter.setMyFragment(this);
    }

    private void findViews(View view){
        txtIconRtn = view.findViewById(R.id.txtIconRtn_AdminAllMembersFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_AdminAllMembersFrg);
        listViewMembers = view.findViewById(R.id.listMembers_AdminAllMembersFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.adminFragment).commit();
            }
        });

        listViewMembers.setAdapter(adminAllMemberListAdapter);

    }
}