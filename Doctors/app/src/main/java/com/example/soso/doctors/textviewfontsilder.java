package com.example.soso.doctors;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by SoSo on 3/23/2020.
 */

public class textviewfontsilder extends TextView {
    public textviewfontsilder(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"PNU-Medium.ttf"));
    }
}
