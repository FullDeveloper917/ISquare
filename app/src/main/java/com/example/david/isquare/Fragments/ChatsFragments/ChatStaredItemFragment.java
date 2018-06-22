package com.example.david.isquare.Fragments.ChatsFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.ChatStaredItemListAdapter;
import com.example.david.isquare.Adapters.StaredShopListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Shop;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ChatStaredItemFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewStaredShops;

    private List<Shop> staredShopList;

    private ChatStaredItemListAdapter chatStaredItemListAdapter;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    public MainActivity getMyActivity() {
        return myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat_stared_item, container, false);

        setInit();
        findViews(view);
        setFormula();
        setEvents();
        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        staredShopList = new ArrayList<>();
        staredShopList.add(new Shop());
        staredShopList.add(new Shop());
        staredShopList.add(new Shop());
        staredShopList.add(new Shop());

        chatStaredItemListAdapter = new ChatStaredItemListAdapter(myActivity, R.layout.list_item_of_shop);
        chatStaredItemListAdapter.setList(staredShopList);
        chatStaredItemListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_ChatStaredItemFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_ChatStaredItemFrg);

        listViewStaredShops = view.findViewById(R.id.listStaredShops_ChatStaredItemFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().remove(ChatStaredItemFragment.this).commit();
            }
        });

        listViewStaredShops.setAdapter(chatStaredItemListAdapter);
    }
}
