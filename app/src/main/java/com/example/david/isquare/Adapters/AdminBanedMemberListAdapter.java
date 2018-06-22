package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Dialogs.RemoveBanDialog;
import com.example.david.isquare.Fragments.AdminFragments.AdminBanedMembersFragment;
import com.example.david.isquare.Fragments.MeFragments.MyContactsFragments.ProfileFragment;
import com.example.david.isquare.Objects.ContactHeader;
import com.example.david.isquare.Objects.ContactItem;
import com.example.david.isquare.Objects.Follower;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.List;

/**
 * Created by David on 10/11/2017.
 */

public class AdminBanedMemberListAdapter extends ArrayAdapter<ContactItem> {

    private final Context context;

    private TextView txtPrefix;
    private TextView txtName;
    private TextView txtIconSearch;
    private Button btnBaned;

    private LinearLayout layoutPartner;

    private Typeface iconFont;

    private AdminBanedMembersFragment myFragment;

    public void setMyFragment(AdminBanedMembersFragment myFragment) {
        this.myFragment = myFragment;
    }

    public AdminBanedMemberListAdapter(Context context, List<ContactItem> items) {
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
                view = inflater.inflate(R.layout.list_item_of_contact_id_search, null);
                txtIconSearch = view.findViewById(R.id.txtIconSearch_ContactSearchViewFrg);
                txtIconSearch.setTypeface(iconFont);
                break;

            case 1:
                view = inflater.inflate(R.layout.list_item_of_contacts_body, null);
                txtName = view.findViewById(R.id.txtName_OneFollower);
                layoutPartner = view.findViewById(R.id.layoutPartner_OneFollower);
                btnBaned = view.findViewById(R.id.btnBaned_OneFollower);
                btnBaned.setVisibility(View.VISIBLE);
                btnBaned.setTypeface(iconFont);
                btnBaned.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RemoveBanDialog removeBanDialog = new RemoveBanDialog(myFragment.getMyActivity());
                        removeBanDialog.show();
                    }
                });
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
                if (position == 1) {
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