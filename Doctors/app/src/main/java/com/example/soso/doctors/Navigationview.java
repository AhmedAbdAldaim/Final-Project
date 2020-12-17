package com.example.soso.doctors;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

/**
 * Created by Ahmed Neymar on 10/3/2018.
 */

public class Navigationview extends NavigationView {
    private final Context context;
    private Typeface typeface;
    public Navigationview(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.typeface = null;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        final ViewGroup viewGroup=(ViewGroup)getChildAt(0);
        final int navMenuitem = viewGroup.getChildCount();
        ViewGroup itemview;
        if(typeface == null)
        {
            typeface = Typeface.createFromAsset(context.getAssets(),"PNU-Medium.ttf");

        }
        for(int i=0;i<navMenuitem;i++)
        {
            itemview = (ViewGroup)viewGroup.getChildAt(i);
            if(itemview instanceof NavigationMenuItemView){
                CheckedTextView checkedTextVie=(CheckedTextView)itemview.getChildAt(0);
                checkedTextVie.setTypeface(typeface);
            }
        }
    }
}
