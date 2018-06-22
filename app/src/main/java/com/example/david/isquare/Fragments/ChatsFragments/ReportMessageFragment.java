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

import com.example.david.isquare.Adapters.ReportMessageListAdapter;
import com.example.david.isquare.Adapters.SingleChatListAdapter;
import com.example.david.isquare.Dialogs.ReportMessageDeleteMomentDialog;
import com.example.david.isquare.Dialogs.TransferChatAmountDialog;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.ChatContactContent;
import com.example.david.isquare.Objects.ChatContent;
import com.example.david.isquare.Objects.ChatGroupContent;
import com.example.david.isquare.Objects.ChatImageContent;
import com.example.david.isquare.Objects.ChatItemContent;
import com.example.david.isquare.Objects.ChatLocationContent;
import com.example.david.isquare.Objects.ChatMoment;
import com.example.david.isquare.Objects.ChatShareLocationContent;
import com.example.david.isquare.Objects.ChatTextContent;
import com.example.david.isquare.Objects.ChatTransferContent;
import com.example.david.isquare.Objects.ChatVoiceContent;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ReportMessageFragment extends Fragment {

    private LinearLayout layoutRtn;

    private Button btnSetting;
    private Button btnAdd;
    private Button btnInputVoice;
    private LinearLayout layoutAddContents;

    private LinearLayout layoutAttach;
    private LinearLayout layoutAlbum;
    private LinearLayout layoutContact;
    private LinearLayout layoutItem;
    private LinearLayout layoutPlace;
    private LinearLayout layoutTransfer;
    private LinearLayout layoutCall;

    private ListView listChats;
    private List<ChatContent> chatContentListList;
    private ReportMessageListAdapter reportMessageListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_report_message, container, false);

        setInit();

        findViews(view);

        setFormula(view);

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        chatContentListList = new ArrayList<>();
        chatContentListList.add(new ChatTextContent(false, "I would like to report for this profile, Pay attention to it"));
        chatContentListList.add(new ChatMoment());

        reportMessageListAdapter = new ReportMessageListAdapter(myActivity, chatContentListList);
        reportMessageListAdapter.setMyFragment(this);

    }

    private void findViews(View view){

        layoutRtn = view.findViewById(R.id.layoutRtn_ReportMessageFrg);
        btnSetting = view.findViewById(R.id.btnSetting_ReportMessageFrg);
        btnAdd = view.findViewById(R.id.btnAdd_ReportMessageFrg);
        btnInputVoice = view.findViewById(R.id.btnInputVoice_ReportMessageFrg);
        layoutAddContents = view.findViewById(R.id.layoutAddContents_ReportMessageFrg);
        listChats = view.findViewById(R.id.listChats_ReportMessageFrg);

        layoutAttach = view.findViewById(R.id.layoutAttach_ReportMessageFrg);
        layoutAlbum = view.findViewById(R.id.layoutAlbum_ReportMessageFrg);
        layoutContact = view.findViewById(R.id.layoutContact_ReportMessageFrg);
        layoutItem = view.findViewById(R.id.layoutItem_ReportMessageFrg);
        layoutPlace = view.findViewById(R.id.layoutPlace_ReportMessageFrg);
        layoutTransfer = view.findViewById(R.id.layoutTransfer_ReportMessageFrg);
        layoutCall = view.findViewById(R.id.layoutCall_ReportMessageFrg);
    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_ReportMessageFrg), iconFont);
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
                    layoutAttach.setBackgroundColor(myActivity.getResources().getColor(R.color.colorMyTransparent));
                }
                else {
                    layoutAddContents.setVisibility(View.VISIBLE);
                    btnAdd.setText(myActivity.getResources().getString(R.string.fa_times));
                    btnAdd.setTextColor(myActivity.getResources().getColor(R.color.colorMyGray_6));
                    layoutAttach.setBackgroundColor(myActivity.getResources().getColor(R.color.colorMyGray_5));
                }
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.singleChatSettingsFragment).commit();
            }
        });

        listChats.setAdapter(reportMessageListAdapter);

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