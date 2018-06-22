package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Dialogs.ChatMemberRemoveDialog;
import com.example.david.isquare.Dialogs.ChatMemberUnBanDialog;
import com.example.david.isquare.Fragments.AdminFragments.AdminMomentsFragment;
import com.example.david.isquare.Fragments.ChatsFragments.GroupChatFragment;
import com.example.david.isquare.Fragments.ChatsFragments.GroupChatMembersFragment;
import com.example.david.isquare.Fragments.MeFragments.MyContactsFragments.ProfileFragment;
import com.example.david.isquare.Fragments.MomentsFragments.CommentsFragment;
import com.example.david.isquare.Fragments.MomentsFragments.MomentsPartnerFragment;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.GroupChatMember;
import com.example.david.isquare.Objects.Moment;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/12/2017.
 */

public class GroupChatMemberListAdapter extends ArrayAdapter {
    private final Context context;
    private List<GroupChatMember> lists = new ArrayList<>();

    private Button btnBaned;
    private LinearLayout layoutOneMember;

    private GroupChatMembersFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(GroupChatMembersFragment myFragment) {
        this.myFragment = myFragment;
    }

    public GroupChatMemberListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<GroupChatMember> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_chat_members, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);
        btnBaned = rowView.findViewById(R.id.btnBaned_OneChatMember);
        btnBaned.setTypeface(iconFont);
        layoutOneMember = rowView.findViewById(R.id.layoutOneMember_OneChatMember);

        if (lists.get(position).isBaned()){
            btnBaned.setText(context.getResources().getString(R.string.fa_ban));
            btnBaned.setTextColor(context.getResources().getColor(R.color.colorMyGray_4));
            btnBaned.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new ChatMemberUnBanDialog(myFragment.getMyActivity()).show();
                }
            });
        }
        else {
            btnBaned.setText(context.getResources().getString(R.string.fa_cog));
            btnBaned.setTextColor(context.getResources().getColor(R.color.colorMyGray_10));
            btnBaned.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new ChatMemberRemoveDialog(myFragment.getMyActivity()).show();
                }
            });
        }

        layoutOneMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileFragment profileFragment = myFragment.getMyActivity().profileFragment;
                myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, profileFragment).commit();
            }
        });

        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}