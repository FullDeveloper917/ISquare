package com.example.david.isquare.Fragments.MeFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.CartListAdapter;
import com.example.david.isquare.Adapters.NotificationListAdapter;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.CartFooterItem;
import com.example.david.isquare.Objects.CartHeaderItem;
import com.example.david.isquare.Objects.CartProductItem;
import com.example.david.isquare.Objects.CartUnitItem;
import com.example.david.isquare.Objects.CommonNotification;
import com.example.david.isquare.Objects.FollowNotification;
import com.example.david.isquare.Objects.MomentNotification;
import com.example.david.isquare.Objects.Notification;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;


public class NotificationsFragment extends Fragment {
    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ListView listViewNotifications;
    private List<Notification> notificationList;
    private NotificationListAdapter notificationListAdapter;

    private Typeface iconFont;

    private MainActivity myActivity;

    public MainActivity getMyActivity() {
        return myActivity;
    }

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit() {
        myActivity.layoutControlTab.setVisibility(View.VISIBLE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        notificationList = new ArrayList<>();
        notificationList.add(new MomentNotification(0));
        notificationList.add(new CommonNotification("New partner registered"));
        notificationList.add(new MomentNotification(1));
        notificationList.add(new FollowNotification(true));
        notificationList.add(new MomentNotification(0));
        notificationList.add(new CommonNotification("New contact is waiting"));
        notificationList.add(new MomentNotification(0));
        notificationList.add(new FollowNotification(false));

        notificationListAdapter = new NotificationListAdapter(myActivity, notificationList);
        notificationListAdapter.setMyFragment(this);
    }


    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_NotificationsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_NotificationsFrg);
        listViewNotifications = view.findViewById(R.id.listNotifications_NotificationsFrg);
    }

    private void setFormula(){
        txtIconRtn.setTypeface(iconFont);
    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.usersFragment).commit();
            }
        });

        listViewNotifications.setAdapter(notificationListAdapter);
    }
}
