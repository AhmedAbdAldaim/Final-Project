package com.example.soso.doctors;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private TextView[] nods;
    private Slider slide;
    private Button b1, b2;
    private int cout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewPager = (ViewPager)findViewById(R.id.siled);
        linearLayout =(LinearLayout)findViewById(R.id.dots);

        b1 = (Button)findViewById(R.id.button);
        b2 =(Button)findViewById(R.id.button2);

        slide = new Slider(this);
        viewPager.setAdapter(slide);

        adddoxt(0);
        viewPager.addOnPageChangeListener(vListener);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b1.getText()=="ENTER")
                {
                    Intent intent = new Intent(Main2Activity.this,Login.class);
                    startActivity(intent);
                }
                else
                {
                    viewPager.setCurrentItem(cout+1);
                }

            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(cout-1);
            }
        });;

        SharedPreferences sharedPreferences = getSharedPreferences("name", MODE_PRIVATE);
        String Fr = sharedPreferences.getString("share", "");
        if (Fr.equals("fes")) {
            Intent intent = new Intent(Main2Activity.this, Login.class);
            startActivity(intent);
            finish();

        } else {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("share", "fes");
            editor.apply();
        }


    }






    public void adddoxt(int postion){
        nods = new TextView[3];
        linearLayout.removeAllViews();
        for (int i=0; i<nods.length ;i++)
        {
            nods[i]=new TextView(this);
            nods[i].setText(Html.fromHtml("&#8226;"));
            nods[i].setTextSize(35);
            nods[i].setTextColor(getResources().getColor(R.color.blue1));
            linearLayout.addView(nods[i]);

        }
        if(nods.length > 0)
        {
            nods[postion].setTextColor(getResources().getColor(R.color.white));
            nods[postion].setTextSize(38);
        }

    }
    ViewPager.OnPageChangeListener vListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            adddoxt(position);
            cout = position;
            if(position == 0)
            {
                b1.setEnabled(true);
                b2.setEnabled(false);
                b2.setVisibility(View.INVISIBLE);

                b1.setText("NEXT");
                b2.setText("");


            }else if(position == nods.length -1){
                b1.setEnabled(true);
                b2.setEnabled(true);
                b2.setVisibility(View.VISIBLE);

                b1.setText("ENTER");
                b2.setText("BACK");
            }
            else {
                b1.setEnabled(true);
                b2.setEnabled(true);
                b2.setVisibility(View.VISIBLE);

                b1.setText("NEXT");
                b2.setText("BACK");

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    };

}
