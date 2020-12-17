package com.example.soso.doctors;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by SoSo on 3/23/2020.
 */

public class buttonfont1 extends Button {
    public buttonfont1(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"GE_SS_TWO_MEDIUM.OTF"));
    }
}
