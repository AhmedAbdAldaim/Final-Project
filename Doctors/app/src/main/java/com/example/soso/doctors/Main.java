package com.example.soso.doctors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

public class Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
//EditText idpicc;
    sqlit msqlit;
    String UserEmail,id_use,id_pic,idpic2;
    //-----------------
    private static final long delay=1000l;
    private  boolean mrecent = false;
    private Handler m = new Handler();
    private Runnable mx = new Runnable(){

        @Override
        public void run() {
            mrecent = false;
        }
    };

    ListView listView;
    RequestQueue requestQueue;
    final ArrayList<getname> arrayList = new ArrayList<getname>();
    NavigationView navigationView;

     TextView textView,t2;

    CheckBox checkBo;
    String save_data;
    String Check;
    sqlit db;
    //back--------------------------------------------------------
    @Override
    public void onBackPressed() {
        if (mrecent) {
            m.removeCallbacks(mx);
            m = null;
            super.onBackPressed();
        }

        //Toast.makeText(this, "اضغظ مرة اخرى لتسجيل الخروج", Toast.LENGTH_SHORT).show();
        if(mrecent=true)
        {
            m.postDelayed(mx,delay);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            View view1 = getLayoutInflater().inflate(R.layout.massage_logout,null);
            TextView textView =(TextView)view1.findViewById(R.id.t1);
            TextView textView1 =(TextView)view1.findViewById(R.id.t2);
            TextView textView3 =(TextView)view1.findViewById(R.id.b1);
            TextView textView4 =(TextView)view1.findViewById(R.id.b2);
            builder.setView(view1);
            final AlertDialog dialog = builder.create();
            textView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    save_data="0";
                    msqlit.Update_log(msqlit.get_iduser(),msqlit.get_idpic(),msqlit.get_email(),msqlit.get_password(),save_data);
                    finish();
                }
            });
            textView4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();
        }

    }


    //oncreat ---------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // idpicc =(EditText)findViewById(R.id.ipdp);
        msqlit = new sqlit(this);
        id_use = msqlit.get_iduser();

        drawerLayout = (DrawerLayout) findViewById(R.id.dra);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        navigationView = (NavigationView) findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(this);

        //Toast.makeText(this, ""+id_use, Toast.LENGTH_SHORT).show();

   ;
        Intent intent = this.getIntent();
        String em = intent.getStringExtra("email");
         id_pic = intent.getStringExtra("pic_id");



        String url = "http://192.168.43.176/projects/get_name_to_nav.php?user_id="+id_use;

        listView =(ListView)findViewById(R.id.listvies);
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("all");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String id = object.getString("user_id");
                        String idp = object.getString("pic_id");
                        String fname = object.getString("name");
                        String email = object.getString("email");
                        String password = object.getString("password");
                        String ima = object.getString("image");
                        arrayList.add(new getname(id,idp, fname, email, password, ima));
                        l();
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

    public void l(){
        ListAdapter listAdapter = new list(arrayList);
        listView.setAdapter(listAdapter);
    }




    class list  extends BaseAdapter {
        ArrayList<getname> arrayList = new ArrayList<getname>();

        public list(ArrayList<getname> arrayList) {
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
            View view = layoutInflater.inflate(R.layout.activity_navig,null);
            textView = (TextView)view.findViewById(R.id.fname);
            t2 =(TextView)view.findViewById(R.id.t2);
            final ImageView imageView =(ImageView)view.findViewById(R.id.imgaa);
            Button button = (Button)view.findViewById(R.id.buto_upd);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent inte = new Intent(Main.this,Update_singup.class);
                    inte.putExtra("id",arrayList.get(position).id);
                    inte.putExtra("fname",arrayList.get(position).fname);
                    inte.putExtra("email",arrayList.get(position).email);
                    inte.putExtra("password",arrayList.get(position).password);
                    imageView.buildDrawingCache();
                    Bitmap imge = imageView.getDrawingCache();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("img",imge);
                    inte.putExtras(bundle);
                    startActivity(inte);

                }
            });
            textView.setText(arrayList.get(position).fname);
            t2.setText(arrayList.get(position).idp);
            Picasso.with(Main.this).load("http://192.168.43.176/projects/pic/"+arrayList.get(position).image).into(imageView);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                   notifyDataSetChanged();
                    //dont forget to call getData();
                    handler.postDelayed(this, 60 * 10000); //ensure to run after 10 minutes
                }
            }, 60 * 10000);
            return view;
        }



    }

    public void hos(View view) {
        final String id_ppp = t2.getText().toString();
        Intent intent = new Intent(Main.this,hosptal.class);
        intent.putExtra("name_pic",textView.getText().toString());
        intent.putExtra("id_pic",id_ppp);
        startActivity(intent);
    }
    public void open(View view) {

        drawerLayout.openDrawer(GravityCompat.START);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);

        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.m2:
                Intent intent1 = new Intent(Main.this,about.class);
                startActivity(intent1);
                break;
            case R.id.m3:
                drawerLayout.closeDrawer(GravityCompat.START);
                String name = "تطبيق موعدي";
                String url = "http://com.play.store/app/?id=" + getPackageName();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, name + "\n" + url);
                startActivity(intent);
                break;
            case R.id.m5:
                drawerLayout.closeDrawer(GravityCompat.START);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                View view1 = getLayoutInflater().inflate(R.layout.massage_logout, null);
                TextView textView = (TextView) view1.findViewById(R.id.t1);
                TextView textView1 = (TextView) view1.findViewById(R.id.t2);
                TextView textView3 = (TextView) view1.findViewById(R.id.b1);
                TextView textView4 = (TextView) view1.findViewById(R.id.b2);
                builder.setView(view1);
                final AlertDialog dialog = builder.create();
                textView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        save_data="0";
                        msqlit.Update_log(msqlit.get_iduser(),msqlit.get_idpic(),msqlit.get_email(),msqlit.get_password(),save_data);

                        finish();
                    }
                });
                textView4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
                break;
        }
        return false;
    }


}

















