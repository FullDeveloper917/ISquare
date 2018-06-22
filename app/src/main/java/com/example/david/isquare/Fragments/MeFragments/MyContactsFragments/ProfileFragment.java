package com.example.david.isquare.Fragments.MeFragments.MyContactsFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.MomentsGridAdapter;
import com.example.david.isquare.Adapters.MyMomentsListAdapter;
import com.example.david.isquare.Adapters.ProductListAdapter;
import com.example.david.isquare.Adapters.ProfileMomentListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedGridView;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.Fragments.ChatsFragments.ReportMessageFragment;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Moment;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    private Button btnGrid;
    private Button btnList;
    private Button btnMenu;
    private Button btnBookMark;

    private Button btnSetting;
    private Button btnMessage;
    private Button btnVoiceCall;
    private LinearLayout layoutMenu;
    private boolean isFollowed;
    private LinearLayout layoutMenuFollowOrUnfollow;
    private TextView txtIconMenuFollowOrUnfollow;
    private TextView txtMenuFollowOrUnfollow;
    private LinearLayout layoutMenuReport;
    private LinearLayout layoutRtn;

    private ExpandedListView listViewMoments;
    private List<Moment> momentList;
    private ProfileMomentListAdapter productListAdapter;

    private ExpandedGridView gridViewMoments;
    private MomentsGridAdapter momentsGridAdapter;

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

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        setInit();

        findViews(view);

        setFormula(view);

        setEvents();

        return view;
    }

    private void setInit() {
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        isFollowed = true;
        momentList = new ArrayList<>();

        momentList.add(new Moment(myActivity.getResources().getDrawable(R.drawable.list_item_sample_of_moment1)));
        momentList.add(new Moment(myActivity.getResources().getDrawable(R.drawable.raw_1505684833)));
        momentList.add(new Moment(myActivity.getResources().getDrawable(R.drawable.list_item_sample_of_moment1)));
        momentList.add(new Moment(myActivity.getResources().getDrawable(R.drawable.raw_1505684833)));


        productListAdapter = new ProfileMomentListAdapter(myActivity, R.layout.list_item_of_moments);
        productListAdapter.setList(momentList);
        productListAdapter.setMyFragment(this);

        momentsGridAdapter = new MomentsGridAdapter(myActivity);
        momentsGridAdapter.setList(momentList);
    }

    private void findViews(View view){

        btnMessage = view.findViewById(R.id.btnMessage_ProfileFrg);
        btnVoiceCall = view.findViewById(R.id.btnVoiceCall_ProfileFrg);
        btnGrid = view.findViewById(R.id.btnGrid_ProfileFrg);
        btnList = view.findViewById(R.id.btnList_ProfileFrg);
        btnMenu = view.findViewById(R.id.btnMenu_ProfileFrg);
        btnBookMark = view.findViewById(R.id.btnBookMark_ProfileFrg);
        btnSetting = view.findViewById(R.id.btnSetting_ProfileFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_ProfileFrg);

        layoutMenu = view.findViewById(R.id.layoutMenu_ProfileFrg);
        layoutMenuFollowOrUnfollow = view.findViewById(R.id.layoutMenuFollowOrUnfollow_ProfileFrg);
        txtIconMenuFollowOrUnfollow = view.findViewById(R.id.txtIconMenuFollowOrUnfollow_ProfileFrg);
        txtMenuFollowOrUnfollow = view.findViewById(R.id.txtMenuFollowOrUnfollow_ProfileFrg);
        layoutMenuReport = view.findViewById(R.id.layoutMenuReport_ProfileFrg);

        listViewMoments = view.findViewById(R.id.listMoments_ProfileFrg);
        gridViewMoments = view.findViewById(R.id.gridMoments_ProfileFrg);
    }

    private void setFormula(View view){
        FontManager.setFontType(view.findViewById(R.id.layoutMain_ProfileFrg), iconFont);
    }

    private void setEvents(){
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.singleChatFragment).commit();
            }
        });

        btnVoiceCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.singleChatFragment).commit();
            }
        });

        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGrid.setTextColor(getResources().getColor(R.color.colorMyRed));
                btnList.setTextColor(getResources().getColor(R.color.colorMyGray_4));
                gridViewMoments.setVisibility(View.VISIBLE);
                listViewMoments.setVisibility(View.GONE);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGrid.setTextColor(getResources().getColor(R.color.colorMyGray_4));
                btnList.setTextColor(getResources().getColor(R.color.colorMyRed));
                gridViewMoments.setVisibility(View.GONE);
                listViewMoments.setVisibility(View.VISIBLE);
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layoutMenu.getVisibility() == View.VISIBLE){
                    layoutMenu.setVisibility(View.GONE);
                }
                else {
                    layoutMenu.setVisibility(View.VISIBLE);
                }
            }
        });

        layoutMenuFollowOrUnfollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (isFollowed){
                txtIconMenuFollowOrUnfollow.setText(myActivity.getResources().getString(R.string.fa_eye_slash));
                txtIconMenuFollowOrUnfollow.setTextColor(myActivity.getResources().getColor(R.color.colorMyWhite));
                txtMenuFollowOrUnfollow.setText(myActivity.getResources().getString(R.string.unfollow));
            }
            else {
                txtIconMenuFollowOrUnfollow.setText(myActivity.getResources().getString(R.string.fa_eye));
                txtIconMenuFollowOrUnfollow.setTextColor(myActivity.getResources().getColor(R.color.colorMyRed));
                txtMenuFollowOrUnfollow.setText(myActivity.getResources().getString(R.string.follow));
            }
            isFollowed = !isFollowed;
            }
        });

        layoutMenuReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.reportMessageFragment).commit();
            }
        });

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.followersFragment).commit();
            }
        });

        listViewMoments.setAdapter(productListAdapter);
        gridViewMoments.setAdapter(momentsGridAdapter);

    }
}
