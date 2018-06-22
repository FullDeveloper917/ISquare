package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.david.isquare.Dialogs.AdminProductItemDeleteDialog;
import com.example.david.isquare.Fragments.AdminFragments.AdminProductsFragment;
import com.example.david.isquare.Objects.AdminProductHeader;
import com.example.david.isquare.Objects.AdminProductInterface;

import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.List;

/**
 * Created by David on 10/12/2017.
 */

public class AdminProductListAdapter extends ArrayAdapter<AdminProductInterface> {

    private final Context context;

    private TextView txtPrefix;
    private TextView txtName;
    private Button btnTrash;

    private Typeface iconFont;

    private AdminProductsFragment myFragment;

    public void setMyFragment(AdminProductsFragment myFragment) {
        this.myFragment = myFragment;
    }

    public AdminProductListAdapter(Context context, List<AdminProductInterface> items) {
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
                view = inflater.inflate(R.layout.list_item_of_admin_products, null);
                txtName = view.findViewById(R.id.txtName_OneAdminProducts);
                btnTrash = view.findViewById(R.id.btnTrash_OneAdminProducts);
                btnTrash.setTypeface(iconFont);
                btnTrash.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new AdminProductItemDeleteDialog(myFragment.getMyActivity()).show();
                    }
                });
                break;
            case 1:
                view = inflater.inflate(R.layout.list_item_of_common_header, null);
                txtPrefix = view.findViewById(R.id.txtPrefix_OneContactHeader);
                AdminProductHeader adminProductHeader = (AdminProductHeader) getItem(position);
                txtPrefix.setText(adminProductHeader.getPrefix());
                break;
        }

        return view;
    }

}