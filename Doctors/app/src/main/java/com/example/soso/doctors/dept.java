package com.example.soso.doctors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class dept extends AppCompatActivity {
    ListView listView;
    RequestQueue requestQueue;
    String id_h,name_h,name_pic,id_pic;
    TextView textView;
    ArrayList<dept_send> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept);
        textView =(TextView)findViewById(R.id.idpic);
        Intent intent = getIntent();
         id_h = intent.getStringExtra("id");
        name_h = intent.getStringExtra("name_hos");
        name_pic = intent.getStringExtra("name_pic");
        id_pic = intent.getStringExtra("id_pic");
        textView.setText(id_pic);
       // Toast.makeText(this, id_pic, Toast.LENGTH_SHORT).show();

        String url = "http://192.168.43.176/projects/dept.php?hospital_id="+id_h;
        listView =(ListView)findViewById(R.id.list);
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("all");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String Sp_id = object.getString("Sp_id");
                        String name = object.getString("SP_name");
                        arrayList.add(new dept_send(Sp_id,name));
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
        ArrayList<dept_send> arrayList = new ArrayList<dept_send>();

        public liss(ArrayList<dept_send> arrayList) {
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
            LayoutInflater layoutInflater =getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.dep_de,null);
          //  TextView id = (TextView)view.findViewById(R.id.id);
            TextView name =(TextView)view.findViewById(R.id.name);
            //TextView idd =(TextView)view.findViewById(R.id.idd);

            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  Intent intent = new Intent(dept.this,Doctor.class);
                   intent.putExtra("id_dep",arrayList.get(position).id);
                    intent.putExtra("name_dep",arrayList.get(position).name);
                    intent.putExtra("name_hos",name_h);
                    intent.putExtra("id_hos",id_h);
                    intent.putExtra("name_pic",name_pic);
                    intent.putExtra("id_pic",textView.getText().toString());

                   startActivity(intent);
                }
            });
         //   id.setText(arrayList.get(position).id);
            name.setText(arrayList.get(position).name);
           // idd.setText(arrayList.get(position).id_dep);

            return view;
        }
    }
}
