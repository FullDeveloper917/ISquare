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
import android.widget.TextView;

import com.example.david.isquare.Fragments.ChatsFragments.ChatsFragment;
import com.example.david.isquare.Fragments.MeFragments.MyCartFragments.CheckOutFragment;
import com.example.david.isquare.Fragments.MeFragments.MyCartFragments.MyCartFragment;
import com.example.david.isquare.Fragments.MeFragments.MyMomentsFragments.AddNewTextFragment;
import com.example.david.isquare.Objects.CafeMond;
import com.example.david.isquare.Objects.CartUnitItem;
import com.example.david.isquare.Objects.ChatBlock;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/8/2017.
 */

public class CafeMondListAdapter extends ArrayAdapter{
    private final Context context;
    private List<CafeMond> lists = new ArrayList<>();

    private TextView txtIcon;

    private ChatsFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(ChatsFragment myFragment) {
        this.myFragment = myFragment;
    }

    public CafeMondListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<CafeMond> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_cafe_mond, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        txtIcon = rowView.findViewById(R.id.txtIcon_OneCafeMond);
        txtIcon.setTypeface(iconFont);

        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}

