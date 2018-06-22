package com.example.david.isquare.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.isquare.Fragments.AdminFragments.AdminWithdrawalFragments.AdminWithdrawalDetailFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminWithdrawalFragments.AdminWithdrawalFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.ProductsFragements.EditProductFragment;
import com.example.david.isquare.Objects.Withdrawal;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/12/2017.
 */

public class AdminWithdrawalListAdapter extends ArrayAdapter {
    private final Context context;
    private List<Withdrawal> lists = new ArrayList<>();

    private TextView txtProcessed;
    private LinearLayout layoutWithdrawal;

    private AdminWithdrawalFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(AdminWithdrawalFragment myFragment) {
        this.myFragment = myFragment;
    }

    public AdminWithdrawalListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<Withdrawal> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_admin_withdrawal, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        findViews(rowView);

        setFormula();

        setEvents(position);

        return rowView;
    }

    private void findViews(View rowView){
        txtProcessed = rowView.findViewById(R.id.txtProcessed_OneAdminWithdrawal);
        layoutWithdrawal = rowView.findViewById(R.id.layoutWithdrawal_OneAdminWithdrawal);
    }

    private void setFormula(){
        txtProcessed.setTypeface(iconFont);
    }

    private void setEvents(int i){
        if (lists.get(i).isProcessed()) {
            txtProcessed.setText(context.getResources().getString(R.string.fa_check_circle));
        }
        else {
            txtProcessed.setText(context.getResources().getString(R.string.fa_spinner));
            Animation rotation = AnimationUtils.loadAnimation(myFragment.getMyActivity(), R.anim.rotate);
            rotation.setFillAfter(true);
            txtProcessed.startAnimation(rotation);
        }
        layoutWithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminWithdrawalDetailFragment adminWithdrawalDetailFragment = myFragment.getMyActivity().adminWithdrawalDetailFragment;
                myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, adminWithdrawalDetailFragment).commit();
            }
        });
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
