package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Dialogs.ReportMessageBlockProfileDialog;
import com.example.david.isquare.Dialogs.ReportMessageDeleteMomentDialog;
import com.example.david.isquare.Fragments.ChatsFragments.GroupChatFragment;
import com.example.david.isquare.Fragments.ChatsFragments.ReportMessageFragment;
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

import java.util.List;

/**
 * Created by David on 10/12/2017.
 */

public class ReportMessageListAdapter extends ArrayAdapter<ChatContent> {

    private final Context context;

    private Typeface iconFont;

    private ReportMessageFragment myFragment;

    public enum RowType {
        TEXT, VOICE, IMAGE, CONTACT, ITEM, LOCATION, TRANSFER, SHARE_LOCATION, GROUP
    }

    public void setMyFragment(ReportMessageFragment myFragment) {
        this.myFragment = myFragment;
    }

    public ReportMessageListAdapter(Context context, List<ChatContent> items) {
        super(context, 0, items);
        this.context = context;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        switch (getItem(position).getViewType()) {
            case 0:
                ChatTextContent chatTextContent = (ChatTextContent) getItem(position);
                TextView txtMessage;
                if (chatTextContent.isSending()){
                    view = inflater.inflate(R.layout.list_item_of_chat_text_sender, null);
                    txtMessage = view.findViewById(R.id.txtMessage_ChatTextSender);
                }
                else {
                    view = inflater.inflate(R.layout.list_item_of_chat_text_receiver, null);
                    txtMessage = view.findViewById(R.id.txtMessage_ChatTextReceiver);
                }
                txtMessage.setText(chatTextContent.getContent());
                break;
            case 1:
                ChatVoiceContent chatVoiceContent = (ChatVoiceContent) getItem(position);
                TextView txtIconVoice;
                if (chatVoiceContent.isSending()){
                    view = inflater.inflate(R.layout.list_item_of_chat_voice_sender, null);
                    txtIconVoice = view.findViewById(R.id.txtIconVoice_ChatVoiceSender);
                }
                else {
                    view = inflater.inflate(R.layout.list_item_of_chat_voice_receiver, null);
                    txtIconVoice = view.findViewById(R.id.txtIconVoice_ChatVoiceReceiver);
                }
                txtIconVoice.setTypeface(iconFont);
                break;
            case 2:
                ChatImageContent chatImageContent = (ChatImageContent) getItem(position);
                if (chatImageContent.isSending()){
                    view = inflater.inflate(R.layout.list_item_of_chat_image_sender, null);
                }
                else {
                    view = inflater.inflate(R.layout.list_item_of_chat_image_receiver, null);
                }
                break;

            case 3:
                ChatContactContent chatContactContent = (ChatContactContent) getItem(position);
                if (chatContactContent.isSending()){
                    view = inflater.inflate(R.layout.list_item_of_chat_contact_sender, null);
                }
                else {
                    view = inflater.inflate(R.layout.list_item_of_chat_contact_receiver, null);
                }
                break;

            case 4:
                ChatItemContent chatItemContent = (ChatItemContent) getItem(position);
                TextView txtItemMark;
                if (chatItemContent.isSending()){
                    view = inflater.inflate(R.layout.list_item_of_chat_item_sender, null);
                    txtItemMark = view.findViewById(R.id.txtMark_ChatItemSender);
                }
                else {
                    view = inflater.inflate(R.layout.list_item_of_chat_item_receiver, null);
                    txtItemMark = view.findViewById(R.id.txtMark_ChatItemReceiver);
                }
                txtItemMark.setTypeface(iconFont);
                break;

            case 5:
                ChatLocationContent chatLocationContent = (ChatLocationContent) getItem(position);
                TextView txtLocationMark;
                if (chatLocationContent.isSending()){
                    view = inflater.inflate(R.layout.list_item_of_chat_location_sender, null);
                    txtLocationMark = view.findViewById(R.id.txtMark_ChatLocationSender);
                }
                else {
                    view = inflater.inflate(R.layout.list_item_of_chat_location_receiver, null);
                    txtLocationMark = view.findViewById(R.id.txtMark_ChatLocationReceiver);
                }
                txtLocationMark.setTypeface(iconFont);
                break;

            case 6:
                ChatTransferContent chatTransferContent = (ChatTransferContent) getItem(position);
                TextView txtIconTransfer;
                if (chatTransferContent.isSending()){
                    view = inflater.inflate(R.layout.list_item_of_chat_transfer_sender, null);
                    txtIconTransfer = view.findViewById(R.id.txtIconTransfer_ChatTransferSender);
                }
                else {
                    view = inflater.inflate(R.layout.list_item_of_chat_transfer_receiver, null);
                    txtIconTransfer = view.findViewById(R.id.txtIconTransfer_ChatTransferReceiver);
                }

                txtIconTransfer.setTypeface(iconFont);
                if (chatTransferContent.isDone()) {
                    txtIconTransfer.setText(context.getResources().getString(R.string.fa_check_circle));
                    txtIconTransfer.setTextColor(context.getResources().getColor(R.color.colorMyRed));
                }
                else {
                    txtIconTransfer.setText(context.getResources().getString(R.string.fa_exchange));
                    txtIconTransfer.setTextColor(context.getResources().getColor(R.color.colorMyDarkBlue));
                }
                break;

            case 7:
                ChatShareLocationContent chatShareLocationContent = (ChatShareLocationContent) getItem(position);
                TextView txtIconShareLocation;
                if (chatShareLocationContent.isSending()){
                    view = inflater.inflate(R.layout.list_item_of_chat_share_location_sender, null);
                    txtIconShareLocation = view.findViewById(R.id.txtIconShareLocation_ChatShareLocationSender);
                }
                else {
                    view = inflater.inflate(R.layout.list_item_of_chat_share_location_receiver, null);
                    txtIconShareLocation = view.findViewById(R.id.txtIconShareLocation_ChatShareLocationReceiver);
                }
                txtIconShareLocation.setTypeface(iconFont);
                break;

            case 8:
                ChatGroupContent chatGroupContent = (ChatGroupContent) getItem(position);
                TextView txtIconUsers;
                if (chatGroupContent.isSending()){
                    view = inflater.inflate(R.layout.list_item_of_chat_group_sender, null);
                    txtIconUsers = view.findViewById(R.id.txtIconUsers_ChatGroupSender);
                }
                else {
                    view = inflater.inflate(R.layout.list_item_of_chat_group_receiver, null);
                    txtIconUsers = view.findViewById(R.id.txtIconUsers_ChatGroupReceiver);
                }
                txtIconUsers.setTypeface(iconFont);
                break;

            case 9:
                ChatMoment chatMoment = (ChatMoment) getItem(position);
                view = inflater.inflate(R.layout.list_item_of_chat_moment, null);

                FontManager.setFontType(view.findViewById(R.id.layoutMain_OneChatMoment), iconFont);

                LinearLayout layoutMenu = view.findViewById(R.id.layoutMenu_OneChatMoment);
                LinearLayout layoutMenuDelete = view.findViewById(R.id.layoutMenuDelete_OneChatMoment);
                LinearLayout layoutMenuBlockProfile = view.findViewById(R.id.layoutMenuBlockProfile_OneChatMoment);

                layoutMenuDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new ReportMessageDeleteMomentDialog(myFragment.getMyActivity()).show();
                    }
                });

                layoutMenuBlockProfile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new ReportMessageBlockProfileDialog(myFragment.getMyActivity()).show();
                    }
                });

                Button btnMenu = view.findViewById(R.id.btnMenu_OneChatMoment);
                btnMenu.setTag(R.id.moments_list_position_id, position);
                btnMenu.setTag(R.id.moments_list_menu_layout_id, position);
                btnMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LinearLayout currentMenu = (LinearLayout) view.getTag();
                        if (currentMenu.getVisibility() == View.GONE) {
                            currentMenu.setVisibility(View.VISIBLE);
                        }
                        else {
                            currentMenu.setVisibility(View.GONE);
                        }
                    }
                });

                break;
        }
        return view;
    }

    public int convertSpToPixels(float sp) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
        return px;
    }
}