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

import com.example.david.isquare.Adapters.GroupChatListAdapter;
import com.example.david.isquare.Adapters.SingleChatListAdapter;
import com.example.david.isquare.Dialogs.TransferChatAmountDialog;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.ChatContactContent;
import com.example.david.isquare.Objects.ChatContent;
import com.example.david.isquare.Objects.ChatGroupContent;
import com.example.david.isquare.Objects.ChatImageContent;
import com.example.david.isquare.Objects.ChatItemContent;
import com.example.david.isquare.Objects.ChatLocationContent;
import com.example.david.isquare.Objects.ChatShareLocationContent;
import com.example.david.isquare.Objects.ChatTextContent;
import com.example.david.isquare.Objects.ChatTransferContent;
import com.example.david.isquare.Objects.ChatVoiceContent;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class GroupChatFragment extends Fragment {
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private Button btnMembers;
    private Button btnSetting;
    private Button btnAdd;
    private Button btnInputVoice;
    private TextView txtIconMessage;
    private LinearLayout layoutAddContents;
    private TextView txtIconAlbum;
    private TextView txtIconContact;
    private TextView txtIconItem;
    private TextView txtIconPlace;
    private TextView txtIconTransfer;
    private TextView txtIconCall;

    private ListView listChats;
    private List<ChatContent> chatContentListList;
    private GroupChatListAdapter groupChatListAdapter;

    private LinearLayout layoutAlbum;
    private LinearLayout layoutContact;
    private LinearLayout layoutItem;
    private LinearLayout layoutPlace;
    private LinearLayout layoutTransfer;
    private LinearLayout layoutCall;

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
        View view = inflater.inflate(R.layout.fragment_group_chat, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        chatContentListList = new ArrayList<>();
        chatContentListList.add(new ChatTextContent(false));
        chatContentListList.add(new ChatTextContent(true));
        chatContentListList.add(new ChatImageContent(true));
        chatContentListList.add(new ChatVoiceContent(false));
        chatContentListList.add(new ChatTextContent(false));
        chatContentListList.add(new ChatTextContent(true));
        chatContentListList.add(new ChatImageContent(true));
        chatContentListList.add(new ChatVoiceContent(false));
        chatContentListList.add(new ChatImageContent(true));
        chatContentListList.add(new ChatVoiceContent(false));
        groupChatListAdapter = new GroupChatListAdapter(myActivity, chatContentListList);
        groupChatListAdapter.setMyFragment(this);

    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_GroupChatFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_GroupChatFrg);
        btnMembers = view.findViewById(R.id.btnMembers_GroupChatFrg);
        btnSetting = view.findViewById(R.id.btnSetting_GroupChatFrg);
        txtIconMessage = view.findViewById(R.id.txtIconMessage_GroupChatFrg);
        btnAdd = view.findViewById(R.id.btnAdd_GroupChatFrg);
        btnInputVoice = view.findViewById(R.id.btnInputVoice_GroupChatFrg);
        layoutAddContents = view.findViewById(R.id.layoutAddContents_GroupChatFrg);
        txtIconAlbum = view.findViewById(R.id.txtIconAlbum_GroupChatFrg);
        txtIconContact = view.findViewById(R.id.txtIconContact_GroupChatFrg);
        txtIconItem = view.findViewById(R.id.txtIconItem_GroupChatFrg);
        txtIconPlace = view.findViewById(R.id.txtIconPlace_GroupChatFrg);
        txtIconTransfer = view.findViewById(R.id.txtIconTransfer_GroupChatFrg);
        txtIconCall = view.findViewById(R.id.txtIconCall_GroupChatFrg);
        listChats = view.findViewById(R.id.listChats_GroupChatFrg);

        layoutAlbum = view.findViewById(R.id.layoutAlbum_GroupChatFrg);
        layoutContact = view.findViewById(R.id.layoutContact_GroupChatFrg);
        layoutItem = view.findViewById(R.id.layoutItem_GroupChatFrg);
        layoutPlace = view.findViewById(R.id.layoutPlace_GroupChatFrg);
        layoutTransfer = view.findViewById(R.id.layoutTransfer_GroupChatFrg);
        layoutCall = view.findViewById(R.id.layoutCall_GroupChatFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
        btnMembers.setTypeface(iconFont);
        btnSetting.setTypeface(iconFont);
        txtIconMessage.setTypeface(iconFont);
        btnAdd.setTypeface(iconFont);
        btnInputVoice.setTypeface(iconFont);
        txtIconAlbum.setTypeface(iconFont);
        txtIconContact.setTypeface(iconFont);
        txtIconItem.setTypeface(iconFont);
        txtIconPlace.setTypeface(iconFont);
        txtIconTransfer.setTypeface(iconFont);
        txtIconCall.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.chatsFragment).commit();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layoutAddContents.getVisibility() == View.VISIBLE){
                    layoutAddContents.setVisibility(View.GONE);
                    btnAdd.setText(myActivity.getResources().getString(R.string.fa_plus));
                    btnAdd.setTextColor(myActivity.getResources().getColor(R.color.colorMyGray_10));
                }
                else {
                    layoutAddContents.setVisibility(View.VISIBLE);
                    btnAdd.setText(myActivity.getResources().getString(R.string.fa_times));
                    btnAdd.setTextColor(myActivity.getResources().getColor(R.color.colorMyGray_6));
                }
            }
        });

        btnMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.groupChatMembersFragment).commit();
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.groupChatSettingsFragment).commit();
            }
        });

        listChats.setAdapter(groupChatListAdapter);

        layoutAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().add(R.id.frgMain, myActivity.chatSendPhotoFragment).commit();
            }
        });

        layoutContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().add(R.id.frgMain, myActivity.chatSendContactsFragment).commit();
            }
        });

        layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().add(R.id.frgMain, myActivity.chatStaredItemFragment).commit();
            }
        });

        layoutPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().add(R.id.frgMain, myActivity.chatStaredPlaceFragment).commit();
            }
        });

        layoutTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TransferChatAmountDialog(myActivity).show();
            }
        });

        layoutCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}