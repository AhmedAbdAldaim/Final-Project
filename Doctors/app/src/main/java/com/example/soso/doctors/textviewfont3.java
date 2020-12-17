package com.example.soso.doctors;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by SoSo on 3/23/2020.
 */

public class textviewfont3 extends TextView {
    public textviewfont3(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"GE_SS_TWO_MEDIUM.OTF"));
    }
}
