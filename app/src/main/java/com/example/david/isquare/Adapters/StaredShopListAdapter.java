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

import com.example.david.isquare.Dialogs.AdminWithdrawalDoneDialog;
import com.example.david.isquare.Fragments.ShopFragments.ShopDetailsNewFragment;
import com.example.david.isquare.Fragments.ShopFragments.StaredShopFragment;
import com.example.david.isquare.Objects.Shop;
import com.example.david.isquare.R;
import com.example.david.isquare.Utils.FontManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/11/2017.
 */

public class StaredShopListAdapter extends ArrayAdapter {

    private final Context context;
    private List<Shop> lists = new ArrayList<>();

    private Button btnStar;
    private TextView txtMark;
    private LinearLayout layoutOneShop;
    private ImageView imgShop;

    private StaredShopFragment myFragment;

    private Typeface iconFont;

    public void setMyFragment(StaredShopFragment myFragment) {
        this.myFragment = myFragment;
    }

    public StaredShopListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }


    public void setList(List<Shop> lists){
        this.lists = lists;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_of_shop, parent, false);

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);

        txtMark = rowView.findViewById(R.id.txtMark_OneShop);
        txtMark.setTypeface(iconFont);

        btnStar = rowView.findViewById(R.id.btnStart_OneShop);
        btnStar.setTypeface(iconFont);
        btnStar.setText(context.getResources().getString(R.string.fa_star));
        btnStar.setTag(position);
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
                else {
                    btn.setText(context.getResources().getString(R.string.fa_star));
                    btn.setTextColor(context.getResources().getColor(R.color.colorMyRed));
                    lists.get(i).setStared(true);
                }
            }
        });

        layoutOneShop = rowView.findViewById(R.id.layoutOneShop_OneShop);
        layoutOneShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopDetailsNewFragment shopDetailFragment = myFragment.getMyActivity().shopDetailsNewFragment;
                myFragment.getMyActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, shopDetailFragment).commit();
            }
        });

        imgShop = rowView.findViewById(R.id.imgShop_OneShop);
        switch (position){
            case 0:
                imgShop.setImageDrawable(context.getResources().getDrawable(R.drawable.raw_1505667297));
                break;
            case 1:
                imgShop.setImageDrawable(context.getResources().getDrawable(R.drawable.raw_1505561697));
                break;
            default:
                break;
        }
        return rowView;
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}