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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Fragments.MomentsFragments.CommentsFragment;
import com.example.david.isquare.Fragments.MomentsFragments.MomentsFragment;
import com.example.david.isquare.Fragments.MomentsFragments.MomentsPartnerFragment;
import com.example.david.isquare.Objects.Moment;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 9/26/2017.
 */

public class MomentsStaredListAdapter extends ArrayAdapter {
    private final Context context;
    private List<Moment> lists = new ArrayList<>();

    private ImageView imgMoment;

    private Button btnMenu;
    private Button btnLove;
    private Button btnComment;
    private Button btnStar;

    private TextView txtIconLikes;
    private LinearLayout layoutPartner;

    private LinearLayout layoutMenu;
    private LinearLayout layoutMenuFollowOrUnfollow;
    private TextView txtIconMenuFollowOrUnfollow;
    private TextView txtMenuFollowOrUnfollow;
    private LinearLayout layoutMenuRemove;

    private MomentsFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(MomentsFragment myFragment) {
        this.myFragment = myFragment;
    }

    public MomentsStaredListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<Moment> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_moments_stared, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);
        FontManager.setFontType(rowView.findViewById(R.id.layoutMain_OneMomentsStared), iconFont);

        findViews(rowView);

        setEvents(rowView, position);

        return rowView;
    }

    private void findViews(View view){
        imgMoment = view.findViewById(R.id.imgMoment_OneMomentsStared);
        btnMenu = view.findViewById(R.id.btnMenu_OneMomentsStared);
        btnLove = view.findViewById(R.id.btnLove_OneMomentsStared);
        btnComment = view.findViewById(R.id.btnComment_OneMomentsStared);
        btnStar = view.findViewById(R.id.btnStar_OneMomentsStared);
        layoutPartner = view.findViewById(R.id.layoutPartner_OneMomentsStared);
        layoutMenu = view.findViewById(R.id.layoutMenu_OneMomentsStared);
        layoutMenuRemove = view.findViewById(R.id.layoutMenuRemove_OneMomentsStared);
        layoutMenuFollowOrUnfollow = view.findViewById(R.id.layoutMenuFollowOrUnfollow_OneMomentsStared);
        txtIconMenuFollowOrUnfollow = view.findViewById(R.id.txtIconMenuFollowOrUnfollow_OneMomentsStared);
        txtMenuFollowOrUnfollow = view.findViewById(R.id.txtMenuFollowOrUnfollow_OneMomentsStared);
    }

    private void setEvents(View view, int position){
        imgMoment.setImageDrawable(lists.get(position).getImageDrawable());
        btnMenu.setTag(R.id.moments_list_position_id, position);
        btnMenu.setTag(R.id.moments_list_menu_layout_id, layoutMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = (int) view.getTag(R.id.moments_list_position_id);
                LinearLayout currentMenu = (LinearLayout) view.getTag(R.id.moments_list_menu_layout_id);
                if (currentMenu.getVisibility() == View.VISIBLE){
                    currentMenu.setVisibility(View.GONE);
                }
                else {
                    currentMenu.setVisibility(View.VISIBLE);
                }
            }
        });

        layoutMenuRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        layoutMenuFollowOrUnfollow.setTag(R.id.moments_list_position_id, position);
        layoutMenuFollowOrUnfollow.setTag(R.id.moments_list_menu_follow_icon_id, txtIconMenuFollowOrUnfollow);
        layoutMenuFollowOrUnfollow.setTag(R.id.moments_list_menu_follow_id, txtMenuFollowOrUnfollow);
        layoutMenuFollowOrUnfollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int i = (int) view.getTag(R.id.moments_list_position_id);
                TextView currentTxtIconMenuFollowOrUnfollow = (TextView) view.getTag(R.id.moments_list_menu_follow_icon_id);
                TextView currentTxtMenuFollowOrUnfollow = (TextView) view.getTag(R.id.moments_list_menu_follow_id);

                if (lists.get(i).isFollowed()){
                    currentTxtIconMenuFollowOrUnfollow.setText(context.getResources().getString(R.string.fa_eye_slash));
                    currentTxtIconMenuFollowOrUnfollow.setTextColor(context.getResources().getColor(R.color.colorMyWhite));
                    currentTxtMenuFollowOrUnfollow.setText(context.getResources().getString(R.string.unfollow));
                    lists.get(i).setFollowed(false);
                }
                else {
                    currentTxtIconMenuFollowOrUnfollow.setText(context.getResources().getString(R.string.fa_eye));
                    currentTxtIconMenuFollowOrUnfollow.setTextColor(context.getResources().getColor(R.color.colorMyRed));
                    currentTxtMenuFollowOrUnfollow.setText(context.getResources().getString(R.string.follow));
                    lists.get(i).setFollowed(true);
                }
            }
        });



        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommentsFragment commentsFragment = myFragment.getMyActivity().commentsFragment;
                myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, commentsFragment).commit();
            }
        });

        layoutPartner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MomentsPartnerFragment momentsPartnerFragment = myFragment.getMyActivity().momentsPartnerFragment;
                myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, momentsPartnerFragment).commit();
            }
        });

        btnStar.setTag(position);
        if (lists.get(position).isStared()){
            btnStar.setText(context.getResources().getString(R.string.fa_star));
            btnStar.setTextColor(context.getResources().getColor(R.color.colorMyRed));
        }
        else{
            btnStar.setText(context.getResources().getString(R.string.fa_star_o));
            btnStar.setTextColor(context.getResources().getColor(R.color.colorMyGray_6));
        }
        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = (int) view.getTag();
                Button btn = (Button) view;
                if (lists.get(i).isStared()){
                    btn.setText(context.getResources().getString(R.string.fa_star_o));
                    btn.setTextColor(context.getResources().getColor(R.color.colorMyGray_6));
                    lists.get(i).setStared(false);
                }
                else{
                    btn.setText(context.getResources().getString(R.string.fa_star));
                    btn.setTextColor(context.getResources().getColor(R.color.colorMyRed));
                    lists.get(i).setStared(true);
                }
            }
        });

        btnLove.setTag(position);
        if (lists.get(position).isLoved()){
            btnLove.setText(context.getResources().getString(R.string.fa_heart));
            btnLove.setTextColor(context.getResources().getColor(R.color.colorMyRed));
        }
        else{
            btnLove.setText(context.getResources().getString(R.string.fa_heart_o));;
            btnLove.setTextColor(context.getResources().getColor(R.color.colorMyGray_6));
        }
        btnLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = (int) view.getTag();
                Button btn = (Button) view;
                if (lists.get(i).isLoved()){
                    btn.setText(context.getResources().getString(R.string.fa_heart_o));
                    btn.setTextColor(context.getResources().getColor(R.color.colorMyGray_6));
                    lists.get(i).setLoved(false);
                }
                else{
                    btn.setText(context.getResources().getString(R.string.fa_heart));
                    btn.setTextColor(context.getResources().getColor(R.color.colorMyRed));
                    lists.get(i).setLoved(true);
                }

            }
        });
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
