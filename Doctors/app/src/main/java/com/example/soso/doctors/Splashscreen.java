package com.example.soso.doctors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splashscreen extends AppCompatActivity {
TextView t1,t2;
ImageView imageView;
Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);


        imageView =(ImageView)findViewById(R.id.img);
        t1 =(TextView)findViewById(R.id.textsplash);
        t2 =(TextView)findViewById(R.id.textsplash2);



        Animation animation = AnimationUtils.loadAnimation(this,R.anim.image);
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.text1);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.text2);


        imageView.setAnimation(animation);
        t1.setAnimation(animation1);
        t2.setAnimation(animation2);



        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                    Intent intent = new Intent(Splashscreen.this,Main2Activity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        thread.start();
    }
    }

