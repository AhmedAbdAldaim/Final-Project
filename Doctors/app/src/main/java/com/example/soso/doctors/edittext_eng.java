package com.example.soso.doctors;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by SoSo on 3/23/2020.
 */

public class edittext_eng extends EditText {
    public edittext_eng(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"Amaranth-Bold.otf"));
    }
}
