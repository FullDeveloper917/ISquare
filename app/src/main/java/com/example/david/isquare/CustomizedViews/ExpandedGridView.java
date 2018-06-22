package com.example.david.isquare.CustomizedViews;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by David on 10/17/2017.
 */

public class ExpandedGridView extends GridView {

    private android.view.ViewGroup.LayoutParams params;
    private int old_count = 0;

    public ExpandedGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if (getCount() != old_count) {
            old_count = getCount();
            params = getLayoutParams();
            params.height = (getCount() / getNumColumns() + 1) * (old_count > 0 ? getChildAt(0).getHeight() : 0) ;
            setLayoutParams(params);
        }
        super.onDraw(canvas);
    }
}
