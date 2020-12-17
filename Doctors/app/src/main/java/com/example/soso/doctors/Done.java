package com.example.soso.doctors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Done extends AppCompatActivity {
   /// String id_pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        //Intent intent = getIntent();
         //id_pic = intent.getStringExtra("idpic");
    }



    public void maidn(View view) {
        Intent intent = new Intent(Done.this,Main.class);
        startActivity(intent);
    }
}
