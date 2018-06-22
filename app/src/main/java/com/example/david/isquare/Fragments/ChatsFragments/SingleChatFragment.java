package com.example.david.isquare.Fragments.ChatsFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.CartListAdapter;
import com.example.david.isquare.Adapters.ChatBlockListAdapter;
import com.example.david.isquare.Adapters.SingleChatListAdapter;
import com.example.david.isquare.Dialogs.TransferChatAmountDialog;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.CartFooterItem;
import com.example.david.isquare.Objects.CartHeaderItem;
import com.example.david.isquare.Objects.CartProductItem;
import com.example.david.isquare.Objects.CartUnitItem;
import com.example.david.isquare.Objects.ChatBlock;
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

public class SingleChatFragment extends Fragment {
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private Button btnSetting;
    private Button btnAdd;
    private Button btnSend;
    private EditText edtTypeMessage;
    private LinearLayout layoutAddContents;

    private LinearLayout layoutAlbum;
    private LinearLayout layoutContact;
    private LinearLayout layoutItem;
    private LinearLayout layoutPlace;
    private LinearLayout layoutTransfer;
    private LinearLayout layoutCall;

    private ListView listChats;
    private List<ChatContent> chatContentListList;
    private SingleChatListAdapter singleChatListAdapter;

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
        View view = inflater.inflate(R.layout.fragment_single_chat, container, false);

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
        chatContentListList.add(new ChatTextContent(false));
        chatContentListList.add(new ChatVoiceContent(true));
        chatContentListList.add(new ChatImageContent(true));
        chatContentListList.add(new ChatContactContent(true));
        chatContentListList.add(new ChatItemContent(true));
        chatContentListList.add(new ChatLocationContent(true));
        chatContentListList.add(new ChatTransferContent(true, false));
        chatContentListList.add(new ChatTransferContent(false, true));
        chatContentListList.add(new ChatShareLocationContent(true));
        chatContentListList.add(new ChatGroupContent(false));

        singleChatListAdapter = new SingleChatListAdapter(myActivity, chatContentListList);
        singleChatListAdapter.setMyFragment(this);

    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_SingleChatFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_SingleChatFrg);
        btnSetting = view.findViewById(R.id.btnSetting_SingleChatFrg);
        btnAdd = view.findViewById(R.id.btnAdd_SingleChatFrg);
        btnSend = view.findViewById(R.id.btnSend_SingleChatFrg);
        edtTypeMessage = view.findViewById(R.id.edtTypeMessage_SingleChatFrg);
        layoutAddContents = view.findViewById(R.id.layoutAddContents_SingleChatFrg);
        listChats = view.findViewById(R.id.listChats_SingleChatFrg);

        layoutAlbum = view.findViewById(R.id.layoutAlbum_SingleChatFrg);
        layoutContact = view.findViewById(R.id.layoutContact_SingleChatFrg);
        layoutItem = view.findViewById(R.id.layoutItem_SingleChatFrg);
        layoutPlace = view.findViewById(R.id.layoutPlace_SingleChatFrg);
        layoutTransfer = view.findViewById(R.id.layoutTransfer_SingleChatFrg);
        layoutCall = view.findViewById(R.id.layoutCall_SingleChatFrg);
    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_SingleChatFrg), iconFont);
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

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.singleChatSettingsFragment).commit();
            }
        });

        listChats.setAdapter(singleChatListAdapter);

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

        edtTypeMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0){
                    btnSend.setText(myActivity.getResources().getString(R.string.fa_volume_up));
                }
                else {
                    btnSend.setText(myActivity.getResources().getString(R.string.fa_paper_plane));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}

