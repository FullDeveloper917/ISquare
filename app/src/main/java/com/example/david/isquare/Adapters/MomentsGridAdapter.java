package com.example.david.isquare.Adapters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.david.isquare.Objects.Moment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/16/2017.
 */

public class MomentsGridAdapter extends BaseAdapter {

    private Activity activity;
    List<Moment> lists = new ArrayList<Moment>();

    public MomentsGridAdapter(Activity activity) {
        this.activity = activity;
    }



    public void setList(List<Moment> lists) {
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;
        int screenWidth = displayMetrics.widthPixels;
        int cellImageSize = screenWidth / 3 - 3;

        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(activity);
            imageView.setLayoutParams(new GridView.LayoutParams(cellImageSize, cellImageSize));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageDrawable(lists.get(position).getImageDrawable());
        return imageView;
    }
}