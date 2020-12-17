package com.example.soso.doctors;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
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

public class Doctor extends AppCompatActivity {
    ListView listView;
    RequestQueue requestQueue;
    ArrayList<doc_send> arrayList = new ArrayList<doc_send>();
    String name_hos,name_dep,id_hos,name_pic,id_pic;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        textView =(TextView)findViewById(R.id.idpic);
        Intent intent = getIntent();
       id_hos = intent.getStringExtra("id_hos");
        String id_dep = intent.getStringExtra("id_dep");
         name_hos = intent.getStringExtra("name_hos");
         name_dep = intent.getStringExtra("name_dep");
        name_pic = intent.getStringExtra("name_pic");
        id_pic = intent.getStringExtra("id_pic");
        textView.setText(id_pic);

        listView = (ListView) findViewById(R.id.listvies);
        String url = "http://192.168.43.176/projects/kkkkkkk.php?hospital_id="+id_hos+"&&sp_id="+id_dep;
        requestQueue = Volley.newRequestQueue(this);
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("all");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String id = object.getString("do_id");
                        String name = object.getString("Do_name");
                        String care = object.getString("carear");
                        String addres = object.getString("address");
                        String jn = object.getString("jop_number");
                        String pr = object.getString("diagnosis_prise");
                        String img = object.getString("image");
                        arrayList.add(new doc_send(id,name,addres,jn,care,pr,img));
                        l();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }
    public void l(){
        ListAdapter listAdapter = new list(arrayList);
        listView.setAdapter(listAdapter);
    }


    class list  extends BaseAdapter{
        ArrayList<doc_send>arrayList = new ArrayList<doc_send>();

        public list(ArrayList<doc_send> arrayList) {
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
            View view =layoutInflater.inflate(R.layout.doc_de,null);
            TextView id =(TextView)view.findViewById(R.id.id);
            final TextView name = (TextView)view.findViewById(R.id.name);
            TextView hos =(TextView)view.findViewById(R.id.hos);
            TextView dep =(TextView)view.findViewById(R.id.dep);
            TextView loc =(TextView)view.findViewById(R.id.loc);
            TextView cash = (TextView)view.findViewById(R.id.cash);
            CardView info = (CardView)view.findViewById(R.id.ca);
            final ImageView img = (ImageView)view.findViewById(R.id.img);
            Button button = (Button)view.findViewById(R.id.butt);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Doctor.this,docinfo.class);
                    intent.putExtra("name",arrayList.get(position).name);
                    intent.putExtra("car",arrayList.get(position).car);
                    intent.putExtra("id",arrayList.get(position).id);
                    intent.putExtra("price",arrayList.get(position).price);
                    intent.putExtra("loc",arrayList.get(position).addres);
                    intent.putExtra("name_hos",name_hos);
                    intent.putExtra("name_dep",name_dep);
                    intent.putExtra("name_pic",name_pic);
                    intent.putExtra("id_hos",id_hos);
                    intent.putExtra("id_pic",textView.getText().toString());

                    img.buildDrawingCache();
                    Bitmap imge = img.getDrawingCache();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("img",imge);
                    intent.putExtras(bundle);

                    intent.putExtra("id",arrayList.get(position).id);
                    startActivity(intent);


                }
            });
            id.setText(arrayList.get(position).id);
            name.setText(arrayList.get(position).name);
            hos.setText(name_hos);
            dep.setText(arrayList.get(position).jn);
            loc.setText(name_dep);
            cash.setText(arrayList.get(position).price);
            Picasso.with(Doctor.this).load("http://192.168.43.176/projects/pic/"+arrayList.get(position).image).into(img);

            return view;
        }
    }
}
