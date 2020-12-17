package com.example.soso.doctors;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by SoSo on 3/23/2020.
 */

public class buttonfont extends Button {
    public buttonfont(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"IbmPlexMonoSemibold-eREB.otf"));
    }
}
