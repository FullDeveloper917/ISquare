package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Fragments.ChatsFragments.CreateGroupChatFragment;
import com.example.david.isquare.Fragments.ChatsFragments.GroupChatAddMembersFragment;
import com.example.david.isquare.Fragments.MeFragments.MyContactsFragments.ContactGroupChatsFragment;
import com.example.david.isquare.Objects.ContactHeader;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.GroupChatMember;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.List;

/**
 * Created by David on 10/9/2017.
 */

public class CreateGroupChatMemberListAdapter extends ArrayAdapter<ContactItem> {

    private final Context context;

    private TextView txtIconInfo;
    private TextView txtPrefix;
    private CheckBox checkInsert;
    private Button btnBaned;
    private LinearLayout layoutOneMember;

    private Typeface iconFont;

    private CreateGroupChatFragment myFragment;

    public void setMyFragment(CreateGroupChatFragment myFragment) {
        this.myFragment = myFragment;
    }

    public CreateGroupChatMemberListAdapter(Context context, List<ContactItem> items) {
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
                view = inflater.inflate(R.layout.list_item_of_create_group_chat_name, null);
                txtIconInfo = view.findViewById(R.id.txtIconInfo_CreateGroupChatFrg);
                txtIconInfo.setTypeface(iconFont);
                break;
            case 1:
                view = inflater.inflate(R.layout.list_item_of_chat_members, null);
                checkInsert = view.findViewById(R.id.checkInsert_OneChatMember);
                btnBaned = view.findViewById(R.id.btnBaned_OneChatMember);
                btnBaned.setVisibility(View.GONE);
                GroupChatMember groupChatMember = (GroupChatMember) getItem(position);
                if (groupChatMember.isChecked()){
                    checkInsert.setVisibility(View.VISIBLE);
                }
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
