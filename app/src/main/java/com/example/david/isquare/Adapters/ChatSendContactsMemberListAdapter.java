package com.example.david.isquare.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Fragments.ChatsFragments.ChatSendContactsFragment;
import com.example.david.isquare.Fragments.ChatsFragments.GroupChatAddMembersFragment;
import com.example.david.isquare.Objects.ContactHeader;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.GroupChatMember;
import com.example.david.isquare.R;

import java.util.List;

/**
 * Created by David on 10/9/2017.
 */

public class ChatSendContactsMemberListAdapter extends ArrayAdapter<ContactItem> {

    private final Context context;

    private TextView txtPrefix;
    private CheckBox checkInsert;
    private Button btnBaned;
    private LinearLayout layoutOneMember;

    private ChatSendContactsFragment myFragment;

    public void setMyFragment(ChatSendContactsFragment myFragment) {
        this.myFragment = myFragment;
    }

    public ChatSendContactsMemberListAdapter(Context context, List<ContactItem> items) {
        super(context, 0, items);
        this.context = context;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;

        switch (getItem(position).getViewType()) {
            case 1:
                view = inflater.inflate(R.layout.list_item_of_chat_members, null);
                checkInsert = view.findViewById(R.id.checkInsert_OneChatMember);
                layoutOneMember = view.findViewById(R.id.layoutOneMember_OneChatMember);
                btnBaned = view.findViewById(R.id.btnBaned_OneChatMember);
                btnBaned.setVisibility(View.GONE);
                GroupChatMember groupChatMember = (GroupChatMember) getItem(position);
                if (groupChatMember.isChecked()){
                    checkInsert.setVisibility(View.VISIBLE);
                }

                layoutOneMember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().remove(myFragment).commit();
                    }
                });

                break;
            case 2:
                view = inflater.inflate(R.layout.list_item_of_common_header, null);
                txtPrefix = view.findViewById(R.id.txtPrefix_OneContactHeader);
                ContactHeader contactHeader = (ContactHeader) getItem(position);
                txtPrefix.setText(contactHeader.getPrefix());
                break;
        }
        return view;
    }
}
