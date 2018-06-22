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

import com.example.david.isquare.Fragments.ChatsFragments.ChatStaredItemFragment;
import com.example.david.isquare.Objects.Shop;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/11/2017.
 */

public class ChatStaredItemListAdapter extends ArrayAdapter {

    private final Context context;
    private List<Shop> lists = new ArrayList<>();

    private Button btnStar;
    private TextView txtMark;
    private LinearLayout layoutOneShop;

    private ChatStaredItemFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(ChatStaredItemFragment myFragment) {
        this.myFragment = myFragment;
    }

    public ChatStaredItemListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<Shop> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_shop, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        txtMark = rowView.findViewById(R.id.txtMark_OneShop);
        txtMark.setTypeface(iconFont);

        layoutOneShop = rowView.findViewById(R.id.layoutOneShop_OneShop);
        layoutOneShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().remove(myFragment).commit();
            }
        });
        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}