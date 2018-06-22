package com.example.david.isquare.Fragments.ChatsFragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.david.isquare.Adapters.ImageAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ChatSendPhotoFragment extends Fragment {

    private Button btnRtn;
    private Button btnNext;
    private ImageView imgSelected;
    private ImageAdapter gridPhotosAdapter;
    private GridView gridPhotos;

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

        View view = inflater.inflate(R.layout.fragment_chat_send_photo, container, false);

        setInit();

        findViews(view);

        setFormula(view);

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);

        gridPhotosAdapter = new ImageAdapter(myActivity);
        gridPhotosAdapter.setItemList(myActivity.galleryImageUris);
    }

    private void findViews(View view){

        btnRtn = view.findViewById(R.id.btnRtn_ChatSendPhotoFrg);
        btnNext = view.findViewById(R.id.btnNext_ChatSendPhotoFrg);
        imgSelected = view.findViewById(R.id.imgSelected_ChatSendPhotoFrg);
        gridPhotos = view.findViewById(R.id.gridPhotos_ChatSendPhotoFrg);
    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_ChatSendPhotoFrg), iconFont);
    }

    private void setEvents(){
        btnRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().remove(ChatSendPhotoFragment.this).commit();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().remove(ChatSendPhotoFragment.this).commit();
            }
        });

        imgSelected.setImageBitmap(decodeSampledBitmapFromUri(myActivity.galleryImageUris.get(0), myActivity.screenWidth, myActivity.convertSpToPixels(360)));


        gridPhotos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView currentImageView = (ImageView) view;
                try {
                    imgSelected.setImageDrawable(currentImageView.getDrawable());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        gridPhotos.setAdapter(gridPhotosAdapter);
        imgSelected.setImageBitmap(decodeSampledBitmapFromUri(myActivity.galleryImageUris.get(0), myActivity.screenWidth, myActivity.convertSpToPixels(360)));

        gridPhotos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView currentImageView = (ImageView) view;
                try {
                    imgSelected.setImageDrawable(currentImageView.getDrawable());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) {

        Bitmap bm = null;
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(path, options);

        return bm;
    }

    public int calculateInSampleSize(

            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float)height / (float)reqHeight);
            } else {
                inSampleSize = Math.round((float)width / (float)reqWidth);
            }
        }

        return inSampleSize;
    }
}
