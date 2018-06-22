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
import android.widget.TextView;

import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

public class GroupChatSettingsFragment extends Fragment {
    private LinearLayout layoutRtn;
    private TextView txtIconRtn;

    private TextView txtIconName;
    private TextView txtIconMute;
    private TextView txtIconStickOnTop;
    private TextView txtIconOnlyAdmin;
    
    private Button btnLeaveGroupChat;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group_chat_settings, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_GroupChatSettingsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_GroupChatSettingsFrg);

        txtIconName = view.findViewById(R.id.txtIconName_GroupChatSettingsFrg);
        txtIconMute = view.findViewById(R.id.txtIconMute_GroupChatSettingsFrg);
        txtIconStickOnTop = view.findViewById(R.id.txtIconStickyOnTop_GroupChatSettingsFrg);
        txtIconOnlyAdmin = view.findViewById(R.id.txtIconOnlyAdmin_GroupChatSettingsFrg);
        btnLeaveGroupChat = view.findViewById(R.id.btnLeaveGroupChat_GroupChatSettingsFrg);

    }

    private void setFormula(){

        txtIconRtn.setTypeface(iconFont);
        txtIconName.setTypeface(iconFont);
        txtIconMute.setTypeface(iconFont);
        txtIconStickOnTop.setTypeface(iconFont);
        txtIconOnlyAdmin.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.groupChatFragment).commit();
            }
        });

        btnLeaveGroupChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.chatsFragment).commit();
            }
        });
    }
}