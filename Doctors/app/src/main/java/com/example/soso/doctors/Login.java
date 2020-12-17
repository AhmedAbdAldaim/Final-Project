package com.example.soso.doctors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
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

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    EditText emai, passwor,ided,idpic;
    ImageView imageView;
    CheckBox checkBo;
    String save_data,idu;
    String Check,id;
    sqlit db;


    RequestQueue requestQueue;
    //oncreate------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emai = (EditText) findViewById(R.id.ed1);
        passwor = (EditText) findViewById(R.id.ed2);
        ided = (EditText) findViewById(R.id.edid);
        idpic = (EditText) findViewById(R.id.edidpic);
        imageView = (ImageView) findViewById(R.id.imageseyes);


        Intent i = getIntent();
        String em = i.getStringExtra("email");
        String pa = i.getStringExtra("password");
        idu = i.getStringExtra("id_user");

        String url = "http://192.168.43.176/projects/getidpic.php?user_id="+idu;
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("all");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                          id = object.getString("id");
                        idpic.setText(id);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("VOLLEY", "ERROR");
            }

        });
        requestQueue.add(jsonObjectRequest);


        emai.setText(em);
        passwor.setText(pa);
        ided.setText(idu);


        checkBo = (CheckBox) findViewById(R.id.check);
        db = new sqlit(this);

        if (db.get_check() != null) {
            Check = db.get_check();
            if (Check.equals("1")) {
                ided.setText(db.get_iduser());
                idpic.setText(db.get_idpic());
                emai.setText(db.get_email());
                passwor.setText(db.get_password());
                checkBo.setChecked(true);
                save_data = "1";
                  startActivity(new Intent(Login.this,Main.class));
            } else {
               // ided.setText(db.get_iduser());
                checkBo.setChecked(false);
                save_data = "0";
            }
            checkBo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        save_data = "1";
                       // Toast.makeText(getBaseContext(), "تم حفظ بيانات تسجيل الدخول", Toast.LENGTH_SHORT).show();
                    } else {
                        save_data = "0";
                        //   Toast.makeText(getBaseContext(), "", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


    }


    public void login(View view) {
      //  Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
        final String ema = emai.getText().toString().trim();
        final String pas = passwor.getText().toString().trim();
         final String idpicc = idpic.getText().toString();
       // Toast.makeText(Login.this, idpicc, Toast.LENGTH_SHORT).show();

        Response.Listener<String>listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try{
                    JSONObject object = new JSONObject(s);
                    Boolean ch = object.getBoolean("success");
                    if(TextUtils.isEmpty(ema))
                    {
                        emai.setError("Email is Requierd!");
                    }
                    if (TextUtils.isEmpty(pas))
                    {
                        passwor.setError("Password is Required!");
                    }

                  else if(ch==true)
                    {

                      //  Toast.makeText(getBaseContext(), "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();
                        checkBo.setChecked(true);
                        db.Update_log(idu,idpicc,ema,pas,save_data);
                        Intent intent = new Intent(Login.this,Main.class);
                        intent.putExtra("email",ema);
                        intent.putExtra("id_user",idu);
                        intent.putExtra("pic_id",idpicc);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(), "لم يتم تسجيل الدخول", Toast.LENGTH_SHORT).show();
                    }
                }catch(JSONException e){e.printStackTrace();}
            }
        };
        log lo = new log(ema,pas,listener);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(lo);
    }




    public void reg(View view) {
    Intent intent = new Intent(Login.this,Singup.class);
    startActivity(intent);

    }
    public void passhiden(View view) {
        if(view.getId()==R.id.imageseyes)
        {
            if(passwor.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                ((ImageView) (view)).setImageResource(R.drawable.ic_remove_red_eye_black_24dp);
                passwor.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView) (view)).setImageResource(R.drawable.ic_visibility_off_black_24dp);
                passwor.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }


}
