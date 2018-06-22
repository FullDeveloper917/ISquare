package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Fragments.MeFragments.MyCartFragments.CheckOutFragment;
import com.example.david.isquare.Fragments.MeFragments.MyCartFragments.MyCartFragment;
import com.example.david.isquare.Fragments.MeFragments.NotificationsFragment;
import com.example.david.isquare.Objects.CartUnitItem;
import com.example.david.isquare.Objects.CommonNotification;
import com.example.david.isquare.Objects.FollowNotification;
import com.example.david.isquare.Objects.MomentNotification;
import com.example.david.isquare.Objects.Notification;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.List;

/**
 * Created by David on 10/9/2017.
 */

public class NotificationListAdapter extends ArrayAdapter<Notification> {

    private final Context context;

    private TextView txtDescription;
    private TextView txtMark;
    private TextView txtFollowState;
    private TextView txtIconUser;
    private LinearLayout layoutFollowState;


    private Typeface iconFont;

    public enum RowType {
        COMMON_ITEM, FOLLOW_ITEM, MOMENT_ITEM
    }

    private NotificationsFragment myFragment;

    public void setMyFragment(NotificationsFragment myFragment) {
        this.myFragment = myFragment;
    }

    public NotificationListAdapter(Context context, List<Notification> items) {
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
                view = inflater.inflate(R.layout.list_item_of_common_notification, null);
                txtDescription = view.findViewById(R.id.txtDescription_OneCommonNotification);
                CommonNotification commonNotification = (CommonNotification)getItem(position);
                txtDescription.setText(commonNotification.getDescription());
                break;
            case 1:
                view = inflater.inflate(R.layout.list_item_of_follow_notification, null);
                txtDescription = view.findViewById(R.id.txtDescription_OneFollowNotification);
                txtFollowState = view.findViewById(R.id.txtFollowState_OneFollowNotification);
                txtIconUser = view.findViewById(R.id.txtIconUser_OneFollowNotification);
                layoutFollowState = view.findViewById(R.id.layoutFollowState_OneFollowNotification);
                FollowNotification followNotification = (FollowNotification)getItem(position);
                txtIconUser.setTypeface(iconFont);
                if (followNotification.isFollowed()){
                    txtDescription.setText("Started follow you");
                    txtFollowState.setText("+");
                    txtFollowState.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    layoutFollowState.setBackgroundResource(R.drawable.red_button_border);
                }
                else {
                    txtDescription.setText("Unfollow you");
                    txtFollowState.setText("-");
                    txtFollowState.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    layoutFollowState.setBackgroundResource(R.drawable.blue_button_border);
                }
                break;
            case 2:
                view = inflater.inflate(R.layout.list_item_of_moment_notification, null);
                txtMark = view.findViewById(R.id.txtMark_OneMomentNotification);
                txtMark.setTypeface(iconFont);
                MomentNotification momentNotification = (MomentNotification) getItem(position);
                if (momentNotification.getState() == 0) {
                    txtMark.setText(context.getResources().getString(R.string.fa_heart));
                    txtMark.setTextColor(context.getResources().getColor(R.color.colorMyRed));
                }
                if (momentNotification.getState() == 1) {
                    txtMark.setText(context.getResources().getString(R.string.fa_commenting));
                    txtMark.setTextColor(context.getResources().getColor(R.color.colorMyDarkBlue));
                }
                break;
        }

        return view;
    }
}