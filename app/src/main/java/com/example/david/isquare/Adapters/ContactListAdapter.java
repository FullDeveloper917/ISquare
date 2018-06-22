package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Fragments.MeFragments.MyContactsFragments.ContactGroupChatsFragment;
import com.example.david.isquare.Fragments.MeFragments.MyContactsFragments.ContactsFragment;
import com.example.david.isquare.Fragments.MeFragments.MyContactsFragments.FollowersFragment;
import com.example.david.isquare.Fragments.MeFragments.MyContactsFragments.ProfileFragment;
import com.example.david.isquare.Objects.ContactHeader;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.Follower;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.List;

/**
 * Created by David on 10/9/2017.
 */

public class ContactListAdapter extends ArrayAdapter<ContactItem> {

    private final Context context;

    private TextView txtPrefix;
    private TextView txtName;
    private TextView txtBtn;
    private TextView txtIconBtn;
    private LinearLayout layoutBtn;
    private LinearLayout layoutPartner;

    private Typeface iconFont;

    public enum RowType {
        EXTRA_ITEM, LIST_ITEM, HEADER_ITEM
    }

    private ContactsFragment myFragment;

    public void setMyFragment(ContactsFragment myFragment) {
        this.myFragment = myFragment;
    }

    public ContactListAdapter(Context context, List<ContactItem> items) {
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
                view = inflater.inflate(R.layout.list_item_of_contact_button, null);
                txtBtn = view.findViewById(R.id.txtFollowers_OneContactButton);
                txtIconBtn = view.findViewById(R.id.txtIconFollowers_OneContactButton);
                txtIconBtn.setTypeface(iconFont);
                layoutBtn = view.findViewById(R.id.layoutFollowers_OneContactButton);
                if (position == 0) {
                    txtIconBtn.setText(context.getResources().getString(R.string.fa_user));
                    txtBtn.setText(context.getResources().getString(R.string.followers));
                    layoutBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            FollowersFragment followersFragment = myFragment.getMyActivity().followersFragment;
                            myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, followersFragment).commit();
                        }
                    });
                }
                else {
                    txtIconBtn.setText(context.getResources().getString(R.string.fa_users));
                    txtBtn.setText(context.getResources().getString(R.string.group_chats));
                    layoutBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ContactGroupChatsFragment contactGroupChatsFragment = myFragment.getMyActivity().contactGroupChatsFragment;
                            myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, contactGroupChatsFragment).commit();
                        }
                    });
                }
                break;
            case 1:
                view = inflater.inflate(R.layout.list_item_of_contacts_body, null);
                txtName = view.findViewById(R.id.txtName_OneFollower);
                Follower follower = (Follower) getItem(position);
                txtName.setText(follower.getName());
                layoutPartner = view.findViewById(R.id.layoutPartner_OneFollower);
                layoutPartner.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ProfileFragment profileFragment = myFragment.getMyActivity().profileFragment;
                        myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, profileFragment).commit();
                    }
                });
                break;
            case 2:
                view = inflater.inflate(R.layout.list_item_of_common_header, null);
                txtPrefix = view.findViewById(R.id.txtPrefix_OneContactHeader);
                if (position == 2) {
                    LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) txtPrefix.getLayoutParams();
                    lp.setMargins(convertSpToPixels(10), convertSpToPixels(20), 0, 0);
                    txtPrefix.setLayoutParams(lp);
                }
                ContactHeader contactHeader = (ContactHeader) getItem(position);
                txtPrefix.setText(contactHeader.getPrefix());
                break;
        }

        return view;
    }

    public int convertSpToPixels(float sp) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
        return px;
    }

}
