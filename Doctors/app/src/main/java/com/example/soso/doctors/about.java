package com.example.soso.doctors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void back(View view) {
        finish();
    }
}
