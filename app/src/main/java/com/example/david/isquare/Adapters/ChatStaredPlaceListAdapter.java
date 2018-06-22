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

import com.example.david.isquare.Fragments.ChatsFragments.ChatStaredPlaceFragment;
import com.example.david.isquare.Objects.Place;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 9/26/2017.
 */

public class ChatStaredPlaceListAdapter extends ArrayAdapter{

    private final Context context;
    private List<Place> lists = new ArrayList<>();

    private TextView txtMark;
    private TextView txtComments;
    private TextView txtDescription;
    private TextView txtMaxDistance;
    private LinearLayout layoutOnePlace;

    private ChatStaredPlaceFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(ChatStaredPlaceFragment myFragment) {
        this.myFragment = myFragment;
    }

    public ChatStaredPlaceListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<Place> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_place, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        txtMark = rowView.findViewById(R.id.txtMark_OnePlace);
        txtMark.setTypeface(iconFont);
        txtComments = rowView.findViewById(R.id.txtComments_OnePlace);
        txtComments.setText(lists.get(position).getComments() + "comments");
        txtDescription = rowView.findViewById(R.id.txtDescription_OnePlace);
        txtDescription.setText(lists.get(position).getDescription());
        txtMaxDistance = rowView.findViewById(R.id.txtMaxDistance_OnePlace);
        txtMaxDistance.setText("<" + lists.get(position).getMaxDistance() + "km");

        layoutOnePlace = rowView.findViewById(R.id.layoutOnePlace_OnePlace);

        layoutOnePlace.setOnClickListener(new View.OnClickListener() {
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
