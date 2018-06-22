package com.example.david.isquare.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.david.isquare.Fragments.AdminFragments.AdminDirectoriesFragments.AdminDirectoriesChoosePlaceFragment;
import com.example.david.isquare.Objects.AdminPlace;
import com.example.david.isquare.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/9/2017.
 */

public class AdminChoosePlaceListAdapter extends ArrayAdapter {
    private final Context context;
    private List<AdminPlace> lists = new ArrayList<>();

    private AdminDirectoriesChoosePlaceFragment myFragment;

    private TextView txtName;

    public void setMyFragment(AdminDirectoriesChoosePlaceFragment myFragment) {
        this.myFragment = myFragment;
    }

    public AdminChoosePlaceListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<AdminPlace> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_admin_choose_place, parent, false);

        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
