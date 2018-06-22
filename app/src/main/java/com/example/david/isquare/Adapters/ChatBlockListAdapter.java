package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Fragments.ChatsFragments.ChatsFragment;
import com.example.david.isquare.Fragments.ChatsFragments.GroupChatFragment;
import com.example.david.isquare.Fragments.ChatsFragments.SingleChatFragment;
import com.example.david.isquare.Objects.ChatBlock;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 9/27/2017.
 */

public class ChatBlockListAdapter extends ArrayAdapter{
    private final Context context;
    private List<ChatBlock> lists = new ArrayList<>();

    private TextView txtIsGrouped;
    private TextView txtIsLocked;
    private LinearLayout layoutChatBlock;

    private ChatsFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(ChatsFragment myFragment) {
        this.myFragment = myFragment;
    }

    public ChatBlockListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<ChatBlock> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_chat_block, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        txtIsLocked = rowView.findViewById(R.id.txtIsLocked_OneChatBlock);
        txtIsGrouped = rowView.findViewById(R.id.txtIsGrouped_OneChatBlock);
        layoutChatBlock = rowView.findViewById(R.id.layoutChatBlock_OneChatBlock);

        txtIsLocked.setTypeface(iconFont);
        txtIsGrouped.setTypeface(iconFont);

        if (!lists.get(position).isLocked()) {
            txtIsLocked.setText("");

            if (lists.get(position).isGrouped()) {
                layoutChatBlock.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        GroupChatFragment groupChatFragment = myFragment.getMyActivity().groupChatFragment;
                        myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, groupChatFragment).commit();
                    }
                });
            }
            else {
                layoutChatBlock.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SingleChatFragment singleChatFragment = myFragment.getMyActivity().singleChatFragment;
                        myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, singleChatFragment).commit();
                    }
                });
                txtIsGrouped.setText("");
            }

        }
        else {
            if (lists.get(position).isGrouped()) {
                txtIsLocked.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        GroupChatFragment groupChatFragment = myFragment.getMyActivity().groupChatFragment;
                        myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, groupChatFragment).commit();
                    }
                });
            }
            else {
                txtIsLocked.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SingleChatFragment singleChatFragment = myFragment.getMyActivity().singleChatFragment;
                        myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, singleChatFragment).commit();
                    }
                });
            }
        }

        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
