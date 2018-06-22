package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.david.isquare.Fragments.MeFragments.MyMomentsFragments.AddNewPhotoFragment;

import java.util.List;

/**
 * Created by David on 10/7/2017.
 */

public class AddNewPhotoAdapter extends BaseAdapter {
    private Context context;
    private List<Bitmap> bitmapList;

    private AddNewPhotoFragment myFragment;

    public void setMyFragment(AddNewPhotoFragment myFragment) {
        this.myFragment = myFragment;
    }

    public AddNewPhotoAdapter(Context context, List<Bitmap> bitmapList) {
        this.context = context;
        this.bitmapList = bitmapList;
    }

    public int getCount() {
        return this.bitmapList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {

            int imageViewSize;
//            if (position == 0)
//                imageViewSize = myFragment.getMyActivity().screenWidth;
//            else
                imageViewSize = myFragment.getMyActivity().screenWidth / 4 - 3;

            imageView = new ImageView(this.context);
            imageView.setLayoutParams(new GridView.LayoutParams(imageViewSize, imageViewSize));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap(this.bitmapList.get(position));
        return imageView;
    }
}
