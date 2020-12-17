package com.example.soso.doctors;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class Slider extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    RelativeLayout relativeLayout;

    public Slider(Context context) {
        this.context = context;

    }

    public int[]slider_imag={
            R.drawable.pic1,
            R.drawable.pic3,
            R.drawable.pic6
    };


    public String[]slider_header={
            "We Are Here For You!",
            "Book Your Doctor!",
            "Medical Care"
    };
    public String[]slider_desed={
            " It is a unique application for the medical field that provides \n easy searching for doctors and hospitals and choosing\n a suitable date and time.",
            " We provide you with the ability to search for a doctor and choose the right time through the Doctor app.",
            "With the Doctor App, book with the best doctors in the best hospitals, while keeping your medical record."
    };




    @Override
    public int getCount() {
        return slider_header.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       layoutInflater =(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       View view = layoutInflater.inflate(R.layout.activity_slider,container,false);
       RelativeLayout relativeLayout = (RelativeLayout)view.findViewById(R.id.sss);
        ImageView img = (ImageView)view.findViewById(R.id.imageView1);
        TextView tex = (TextView)view.findViewById(R.id.textmain);
        TextView texx = (TextView)view.findViewById(R.id.cont);
        img.setImageResource(slider_imag[position]);
        tex.setText(slider_header[position]);
        texx.setText(slider_desed[position]);
        if(slider_header.equals("HOSPITAL"))
        {
            relativeLayout.setBackgroundResource(R.color.blue1);
        }
        else {
            relativeLayout.setBackgroundResource(R.color.white);
        }
      //  relativeLayout.setBackgroundResource(slider_imag[position]);
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
