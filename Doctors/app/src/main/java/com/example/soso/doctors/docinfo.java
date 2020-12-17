package com.example.soso.doctors;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class docinfo extends AppCompatActivity {
    TextView textView1, textView, textView3,in,name,daatee,cashh,locc,fromm;
    ListView listView;
    ImageView imageView;
    RecyclerView recyclerView;
    Adabpter adabpter;
    ArrayList<lsst> arrayList = new ArrayList<lsst>();

    RequestQueue requestQueue;
    String days2[]=new String[30],ec;
    String day_accepet[]=new String[30];
    String id_Day_sick[]= new String[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docinfo);
        textView =(TextView)findViewById(R.id.name);
        textView1 =(TextView)findViewById(R.id.hoss);
        textView3 =(TextView)findViewById(R.id.dep);
        locc =(TextView)findViewById(R.id.loc);
        cashh =(TextView)findViewById(R.id.cash);
        in =(TextView)findViewById(R.id.info);

        imageView = (ImageView)findViewById(R.id.img);
        final Intent intent = getIntent();
        final String name_doc = intent.getStringExtra("name");
        final String dept = intent.getStringExtra("name_dep");
        final String hos = intent.getStringExtra("name_hos");
        final String name_pic = intent.getStringExtra("name_pic");
        final String id_pic = intent.getStringExtra("id_pic");
        final String lo = intent.getStringExtra("loc");
        String cs = intent.getStringExtra("price");
        String ii = intent.getStringExtra("car");
        final String id = intent.getStringExtra("id");
        String id_hos = intent.getStringExtra("id_hos");

       // Toast.makeText(this, dept, Toast.LENGTH_SHORT).show();
        Bundle e = getIntent().getExtras();
        final Bitmap b = (Bitmap) e.getParcelable("img");

//        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
//        ec = Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);

        imageView.setImageBitmap(b);
        textView.setText(name_doc);
        textView1.setText(hos);
        textView3.setText(dept);

      //  in.setText(ii);
        locc.setText(lo);
       cashh.setText(cs);
        in.setText(ii);

        recyclerView = (RecyclerView)findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // LinearLayoutManager linearLayoutManager = new GridLayoutManager(this,2);GRID 2
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);


        String url = "http://192.168.43.176/projects/day.php?docid="+id+"&&hosid="+id_hos;
        // listView =(ListView)findViewById(R.id.lday);

        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("all");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String name =object.getString("day");
                        String from =object.getString("from");
                        String to =object.getString("to");
                        arrayList.add(new lsst(name,name,from,to,hos,lo,dept,name_doc,name_pic,id_pic,id));
                        adabpter = new Adabpter(arrayList,docinfo.this);

                        recyclerView.setAdapter(adabpter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("VOLLEY","ERROR");
            }

        });
        requestQueue.add(jsonObjectRequest);
    }

    public void date(View view) {

        Toast.makeText(this, "hhh", Toast.LENGTH_SHORT).show();
    }
}




