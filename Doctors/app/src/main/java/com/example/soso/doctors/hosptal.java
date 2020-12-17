package com.example.soso.doctors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

 public class hosptal extends AppCompatActivity {
   ListView listView;
   //  Spinner spinner;
     String name_pic,id_pic;
    RequestQueue requestQueue;
     TextView textView;
    String url = "http://192.168.43.176/projects/hospitals.php";
    ArrayList<lis> arrayList = new ArrayList<lis>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosptal);
       textView =(TextView)findViewById(R.id.idpic);
        Intent intent = getIntent();
        name_pic = intent.getStringExtra("name_pic");
        id_pic = intent.getStringExtra("id_pic");
        textView.setText(id_pic);

        listView =(ListView)findViewById(R.id.list);
        //spinner =(Spinner)findViewById(R.id.list);

        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("all");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String id = object.getString("id");
                        String name = object.getString("name");
                        String loc = object.getString("location");
                        String ph = object.getString("phone_number");
                        String img = object.getString("avatar");
                        arrayList.add(new lis(id,name,loc,ph,img));
                        l();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                };
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("VOLLEY","ERROR");
            }

        });
        requestQueue.add(jsonObjectRequest);
    }
    public void l(){
        ListAdapter listAdapter = new liss(arrayList);
        listView.setAdapter(listAdapter);
    }


        class liss extends BaseAdapter {
            ArrayList<lis> arrayList = new ArrayList<lis>();

            public liss(ArrayList<lis> arrayList) {
                this.arrayList = arrayList;
            }

            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return arrayList.get(position).id;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View view = layoutInflater.inflate(R.layout.hos_de, null);
                TextView id = (TextView) view.findViewById(R.id.id);
                final TextView name = (TextView) view.findViewById(R.id.name);
                TextView location = (TextView) view.findViewById(R.id.loc);
                TextView ph = (TextView) view.findViewById(R.id.ph);
                final ImageView img = (ImageView) view.findViewById(R.id.img);

               id.setText(arrayList.get(position).id);
                name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Intent intent = new Intent(hosptal.this,dept.class);
                        intent.putExtra("id",arrayList.get(position).id);
                        intent.putExtra("name_hos",arrayList.get(position).name);
                        intent.putExtra("name_pic",name_pic);
                        intent.putExtra("id_pic",textView.getText().toString());

                        startActivity(intent);

                    }
                });
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(hosptal.this,dept.class);
                        intent.putExtra("name_hos",arrayList.get(position).name);
                        intent.putExtra("id",arrayList.get(position).id);
                        intent.putExtra("name_pic",name_pic);
                        intent.putExtra("id_pic",textView.getText().toString());
                        startActivity(intent);

                    }
                });
                ph.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(hosptal.this,dept.class);
                        intent.putExtra("id",arrayList.get(position).id);
                        intent.putExtra("name_hos",arrayList.get(position).name);
                        intent.putExtra("name_pic",name_pic);
                        intent.putExtra("id_pic",textView.getText().toString());
                        startActivity(intent);

                    }
                });
                location.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(hosptal.this,dept.class);
                        intent.putExtra("id",arrayList.get(position).id);
                        intent.putExtra("name_hos",arrayList.get(position).name);
                        intent.putExtra("name_pic",name_pic);
                        intent.putExtra("id_pic",textView.getText().toString());
                        startActivity(intent);

                    }
                });
                name.setText(arrayList.get(position).name);
                location.setText(arrayList.get(position).location);
                ph.setText(arrayList.get(position).ph);
                Picasso.with(hosptal.this).load("http://192.168.43.176/projects/pic/" + arrayList.get(position).image).into(img);

                return view;
            }
        }}