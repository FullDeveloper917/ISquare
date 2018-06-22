package com.example.david.isquare.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Fragments.AdminFragments.AdminAllMembersFragment;
import com.example.david.isquare.Fragments.MeFragments.MyContactsFragments.ProfileFragment;
import com.example.david.isquare.Objects.ContactHeader;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.Follower;
import com.example.david.isquare.R;

import java.util.List;

/**
 * Created by David on 10/11/2017.
 */

public class AdminAllMemberListAdapter extends ArrayAdapter<ContactItem> {

    private final Context context;

    private TextView txtPrefix;
    private TextView txtName;
    private LinearLayout layoutPartner;

    private AdminAllMembersFragment myFragment;

    public void setMyFragment(AdminAllMembersFragment myFragment) {
        this.myFragment = myFragment;
    }

    public AdminAllMemberListAdapter(Context context, List<ContactItem> items) {
        super(context, 0, items);
        this.context = context;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;

        switch (getItem(position).getViewType()) {
            case 1:
                view = inflater.inflate(R.layout.list_item_of_contacts_body, null);
                txtName = view.findViewById(R.id.txtName_OneFollower);
                layoutPartner = view.findViewById(R.id.layoutPartner_OneFollower);
                Follower follower = (Follower) getItem(position);
                txtName.setText(follower.getName());

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
                ContactHeader contactHeader = (ContactHeader) getItem(position);
                txtPrefix.setText(contactHeader.getPrefix());
                break;
        }
        return view;
    }
}