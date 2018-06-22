package com.example.david.isquare.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Fragments.ChatsFragments.GroupChatFragment;
import com.example.david.isquare.Fragments.MeFragments.MyContactsFragments.ContactGroupChatsFragment;
import com.example.david.isquare.Objects.ChatGroup;
import com.example.david.isquare.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/9/2017.
 */

public class ContactGroupChatListAdapter extends ArrayAdapter {
    private final Context context;
    private List<ChatGroup> lists = new ArrayList<>();

    private ContactGroupChatsFragment myFragment;

    private TextView txtName;
    private LinearLayout layoutMain;

    public void setMyFragment(ContactGroupChatsFragment  myFragment) {
        this.myFragment = myFragment;
    }

    public ContactGroupChatListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<ChatGroup> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_contact_group_chats, parent, false);

        txtName = rowView.findViewById(R.id.txtName_OneContactGroupChat);
        txtName.setText(lists.get(position).getName());
        layoutMain = rowView.findViewById(R.id.layoutMain_OneContactGroupChat);
        layoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GroupChatFragment groupChatFragment = myFragment.getMyActivity().groupChatFragment;
                myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, groupChatFragment).commit();
            }
        });

        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
