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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Dialogs.AdminWithdrawalDoneDialog;
import com.example.david.isquare.Fragments.DirectoriesFragments.EditPlaceFragments.EditPlaceFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.PlaceDetailsFragment;
import com.example.david.isquare.Fragments.MeFragments.MyPlacesFragment;
import com.example.david.isquare.Objects.MyPlace;
import com.example.david.isquare.Objects.Place;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 9/27/2017.
 */

public class MyPlaceListAdapter extends ArrayAdapter {

    private final Context context;
    private List<Place> lists = new ArrayList<>();

    private TextView txtFiveStar;
    private Button btnEdit;
    private ImageView imgPlace;
    private LinearLayout layoutMain;

    private MyPlacesFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(MyPlacesFragment myFragment) {
        this.myFragment = myFragment;
    }

    public MyPlaceListAdapter(@NonNull Context context, @LayoutRes int resource) {
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
        View view = inflater.inflate(R.layout.list_item_of_my_places, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        setInit(view);
        findViews(view);
        setFormula(view);

        switch (position){
            case 0:
                imgPlace.setImageDrawable(context.getResources().getDrawable(R.drawable.raw_1505561088));
                break;
            case 1:
                imgPlace.setImageDrawable(context.getResources().getDrawable(R.drawable.raw_1505556528));
                break;
            case 2:
                imgPlace.setImageDrawable(context.getResources().getDrawable(R.drawable.raw_1505556536));
                break;
            case 3:
                imgPlace.setImageDrawable(context.getResources().getDrawable(R.drawable.raw_1505556544));
                break;
            default:
                break;
        }


        setEvents(view, position);

        return view;
    }

    private void setInit(View view){
        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);
    }

    private void findViews(View view){
        txtFiveStar = view.findViewById(R.id.txtFiveStar_OneMyPlace);
        btnEdit = view.findViewById(R.id.btnEdit_OneMyPlace);
        imgPlace = view.findViewById(R.id.imgPlace_OneMyPlace);
        layoutMain = view.findViewById(R.id.layoutMain_OneMyPlace);
    }

    private void setFormula(View view){
        txtFiveStar.setTypeface(iconFont);
        btnEdit.setTypeface(iconFont);
    }

    private void setEvents(View view, int position){
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditPlaceFragment editPlaceFragment = myFragment.getMyActivity().editPlaceFragment;
                myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, editPlaceFragment).commit();
            }
        });

        layoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlaceDetailsFragment placeDetailsFragment = myFragment.getMyActivity().placeDetailsFragment;
                myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, placeDetailsFragment).commit();
            }
        });
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
