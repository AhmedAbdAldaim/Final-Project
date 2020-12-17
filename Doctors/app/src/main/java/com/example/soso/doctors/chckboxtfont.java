package com.example.soso.doctors;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.CheckBox;

/**
 * Created by SoSo on 3/23/2020.
 */

public class chckboxtfont extends CheckBox {
    public chckboxtfont(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"PNU-Medium.ttf"));
    }
}
