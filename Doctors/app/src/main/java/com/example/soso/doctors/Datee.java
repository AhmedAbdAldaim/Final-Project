package com.example.soso.doctors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Datee extends AppCompatActivity {
TextView Datte,name_hos,loc,dep,doc,pic,idpic;
    EditText ediddoc;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datee);
        Datte= (TextView)findViewById(R.id.date);
        name_hos=(TextView)findViewById(R.id.hos);
        loc=(TextView)findViewById(R.id.loc);
        dep=(TextView)findViewById(R.id.dep);
        doc=(TextView)findViewById(R.id.doc);
        pic=(TextView)findViewById(R.id.pic);
        ediddoc=(EditText) findViewById(R.id.iddoc);
        idpic=(TextView)findViewById(R.id.id_pic);
        button =(Button)findViewById(R.id.button);

        Intent intent = getIntent();
        final String DATE = intent.getStringExtra("date");
        String hos = intent.getStringExtra("hos");
        String locc = intent.getStringExtra("loc");
        String depp = intent.getStringExtra("dep");
        String docc = intent.getStringExtra("doc");
        String picc = intent.getStringExtra("pic");
        String id_do = intent.getStringExtra("id_doc");
        String id_pi = intent.getStringExtra("id_pic");


        Datte.setText(DATE);
        name_hos.setText(hos);
        loc.setText(locc);
        dep.setText(depp);
        doc.setText(docc);
        pic.setText(picc);
        ediddoc.setText(id_do);
        idpic.setText(id_pi);


    }


    public void sure(View view) {
        final String iudoc = ediddoc.getText().toString().trim();
        final String idppic = idpic.getText().toString().trim();
        final String datt = Datte.getText().toString().trim();

        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String ss) {
                try {
                    JSONObject object = new JSONObject(ss);
                    Boolean ch = object.getBoolean("success");
                    if (TextUtils.isEmpty(iudoc)) {
                        ediddoc.setError("Required !");
                    }

                    else if (ch == true) {
                        Intent i = new Intent(Datee.this, Done.class);
                        Toast.makeText(Datee.this, "Reservation was successful", Toast.LENGTH_SHORT).show();
                        startActivity(i);

                    } else {
                        Toast.makeText(getBaseContext(), "Error ", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        };

        sure r = new sure(iudoc,idppic,datt,listener);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(r);


    }
}