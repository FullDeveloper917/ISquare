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

import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.ProductsFragements.EditProductFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.ProductsFragements.ProductsFragment;
import com.example.david.isquare.Fragments.MomentsFragments.CommentsFragment;
import com.example.david.isquare.Objects.Comment;
import com.example.david.isquare.Objects.Product;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/10/2017.
 */

public class CommentListAdapter extends ArrayAdapter {
    private final Context context;
    private List<Comment> lists = new ArrayList<>();

    private CommentsFragment myFragment;

    public void setMyFragment(CommentsFragment myFragment) {
        this.myFragment = myFragment;
    }

    public CommentListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<Comment> lists){
        this.lists = lists;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_comments, parent, false);

        findViews(rowView);

        setFormula();

        setEvents();

        return rowView;
    }

    private void findViews(View rowView){

    }

    private void setFormula(){

    }

    private void setEvents(){

    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
