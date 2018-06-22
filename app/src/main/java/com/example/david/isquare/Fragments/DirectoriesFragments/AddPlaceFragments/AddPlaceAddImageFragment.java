package com.example.david.isquare.Fragments.DirectoriesFragments.AddPlaceFragments;

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
import android.widget.Button;

import com.example.david.isquare.Adapters.AddNewPhotoAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AddPlaceAddImageFragment extends Fragment {

    private Button btnRtn;
    private Button btnNext;
    //    private GridView gridPhotos;
    private List<Bitmap> bitmapList;

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

        View view = inflater.inflate(R.layout.fragment_add_place_add_image, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        bitmapList = new ArrayList<>();
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        try {
            for(int i = 0; i < 12; i++) {
                bitmapList.add(BitmapFactory.decodeResource(getResources(), R.drawable.list_item_sample_of_moment1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findViews(View view){

        btnRtn = view.findViewById(R.id.btnRtn_AddPlaceAddImageFrg);
        btnNext = view.findViewById(R.id.btnNext_AddPlaceAddImageFrg);
//        gridPhotos = view.findViewById(R.id.gridPhotos_AddNewPhotoFrg);
    }

    private void setFormula(){
        btnRtn.setTypeface(iconFont);
        btnNext.setTypeface(iconFont);
    }

    private void setEvents(){
        btnRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.addPlaceSecondFragment).commit();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.addPlaceSecondFragment).commit();
            }
        });

//        AddNewPhotoAdapter addNewPhotoAdapter = new AddNewPhotoAdapter(myActivity, bitmapList);
//        addNewPhotoAdapter.setMyFragment(this);
//        gridPhotos.setAdapter(addNewPhotoAdapter);
    }

    private Bitmap urlImageToBitmap(String imageUrl) throws Exception {
        Bitmap result = null;
        URL url = new URL(imageUrl);
        if(url != null) {
            result = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }
        return result;
    }
}
