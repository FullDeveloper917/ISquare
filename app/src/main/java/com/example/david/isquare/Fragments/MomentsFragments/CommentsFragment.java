package com.example.david.isquare.Fragments.MomentsFragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.isquare.Adapters.CommentListAdapter;
import com.example.david.isquare.Adapters.MomentsListAdapter;
import com.example.david.isquare.Adapters.PartnerMomentsListAdapter;
import com.example.david.isquare.CustomizedViews.ExpandedListView;
import com.example.david.isquare.MainActivity;
import com.example.david.isquare.Objects.Comment;
import com.example.david.isquare.Objects.Moment;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

public class CommentsFragment extends Fragment {

    private TextView txtIconRtn;
    private LinearLayout layoutRtn;

    private ExpandedListView listViewComments;
    private List<Comment> commentList;
    private CommentListAdapter commentListAdapter;

    private TextView txtIconInputMessage;
    private Button btnInputMessage;

    private Typeface iconFont;

    private MainActivity myActivity;

    public void setMyActivity(MainActivity myActivity) {
        this.myActivity = myActivity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_comments, container, false);

        setInit();

        findViews(view);

        setFormula();

        setEvents();

        return view;
    }

    private void setInit(){
        myActivity.layoutControlTab.setVisibility(View.GONE);
        iconFont = FontManager.getTypeface(myActivity, FontManager.FONTAWESOME);
        commentList = new ArrayList<>();
        commentList.add(new Comment());
        commentList.add(new Comment());
        commentList.add(new Comment());
        commentList.add(new Comment());
        commentList.add(new Comment());
        commentList.add(new Comment());
        commentList.add(new Comment());
        commentList.add(new Comment());
        commentList.add(new Comment());
        commentList.add(new Comment());
        commentListAdapter = new CommentListAdapter(myActivity, R.layout.list_item_of_comments);
        commentListAdapter.setList(commentList);
        commentListAdapter.setMyFragment(this);
    }

    private void findViews(View view){

        txtIconRtn = view.findViewById(R.id.txtIconRtn_CommentsFrg);
        layoutRtn = view.findViewById(R.id.layoutRtn_CommentsFrg);
        listViewComments = view.findViewById(R.id.listComments_CommentsFrg);
        txtIconInputMessage = view.findViewById(R.id.txtIconInputMessage_CommentsFrg);
        btnInputMessage = view.findViewById(R.id.btnInputMessage_CommentsFrg);

    }

    private void setFormula(){

        txtIconRtn.setTypeface(iconFont);
        txtIconInputMessage.setTypeface(iconFont);
        btnInputMessage.setTypeface(iconFont);

    }

    private void setEvents(){

        layoutRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, myActivity.momentsFragment).commit();
            }
        });

        listViewComments.setAdapter(commentListAdapter);

    }

}
