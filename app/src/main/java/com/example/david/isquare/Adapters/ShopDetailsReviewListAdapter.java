package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.ReviewsFragment;
import com.example.david.isquare.Fragments.ShopFragments.ShopDetailsReviewFragment;
import com.example.david.isquare.Objects.Review;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/11/2017.
 */

public class ShopDetailsReviewListAdapter extends ArrayAdapter {

    private final Context context;
    private List<Review> lists = new ArrayList<>();

    private TextView txtStarMark;

    private ShopDetailsReviewFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(ShopDetailsReviewFragment myFragment) {
        this.myFragment = myFragment;
    }

    public ShopDetailsReviewListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<Review> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_reviews, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        txtStarMark = rowView.findViewById(R.id.txtStarMark_OneReview);

        txtStarMark.setTypeface(iconFont);
        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}