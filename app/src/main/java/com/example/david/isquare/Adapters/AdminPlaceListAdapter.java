package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.david.isquare.Dialogs.AdminProductItemDeleteDialog;
import com.example.david.isquare.Fragments.AdminFragments.AdminPlacesFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminProductsFragment;
import com.example.david.isquare.Objects.AdminPlace;
import com.example.david.isquare.Objects.AdminPlaceHeader;
import com.example.david.isquare.Objects.AdminPlaceInterface;
import com.example.david.isquare.Objects.AdminProductHeader;
import com.example.david.isquare.Objects.AdminProductInterface;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.List;

/**
 * Created by David on 10/12/2017.
 */

public class AdminPlaceListAdapter extends ArrayAdapter<AdminPlaceInterface> {

    private final Context context;

    private TextView txtPrefix;
    private TextView txtChecked;
    private Button btnAccept;


    private Typeface iconFont;

    private AdminPlacesFragment myFragment;

    public void setMyFragment(AdminPlacesFragment myFragment) {
        this.myFragment = myFragment;
    }

    public AdminPlaceListAdapter(Context context, List<AdminPlaceInterface> items) {
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
                view = inflater.inflate(R.layout.list_item_of_admin_places, null);
                txtChecked = view.findViewById(R.id.txtChecked_OneAdminPlaces);
                txtChecked.setTypeface(iconFont);
                btnAccept = view.findViewById(R.id.btnAccept_OneAdminPlaces);
                btnAccept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myFragment.getMyActivity().profileFragment).commit();
                    }
                });

                AdminPlace adminPlace = (AdminPlace) getItem(position);
                if (adminPlace.isChecked()){
                    txtChecked.setVisibility(View.VISIBLE);
                    btnAccept.setVisibility(View.GONE);
                }
                else {
                    txtChecked.setVisibility(View.GONE);
                    btnAccept.setVisibility(View.VISIBLE);
                }
                break;
            case 1:
                view = inflater.inflate(R.layout.list_item_of_common_header, null);
                txtPrefix = view.findViewById(R.id.txtPrefix_OneContactHeader);
                AdminPlaceHeader adminPlaceHeader = (AdminPlaceHeader) getItem(position);
                txtPrefix.setText(adminPlaceHeader.getPrefix());
                break;
        }

        return view;
    }

}
