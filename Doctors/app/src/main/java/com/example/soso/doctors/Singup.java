package com.example.soso.doctors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Singup extends AppCompatActivity {
EditText fnam,emai,passwor,surepassword;
ImageView imageView,imageView2;

    sqlit db;
    String save_data;

    int privemod = 0;
    public static final String lo ="log";
    public static final String name ="fname";
   // public static final String lname ="lname";
    public static final String name2 ="fname";
  //  public static final String lname2 ="lname";
    public static final String email ="email";
    public static final String passwo ="password";

    public void Sav(String name, String l) {
        fnam.setText(name);
       // lnam.setText(l);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        fnam = (EditText)findViewById(R.id.fname);
       // lnam =(EditText)findViewById(R.id.lname);
        emai =(EditText)findViewById(R.id.email);
        passwor=(EditText)findViewById(R.id.password);
        surepassword=(EditText)findViewById(R.id.surepass);
         imageView =(ImageView)findViewById(R.id.imageseyes);
        imageView2=(ImageView)findViewById(R.id.images2);
        db= new sqlit(this);;
    }

    public void SIN(String name,String lname){
        SharedPreferences sharedPreferences = getSharedPreferences("file",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nam",name);
        editor.putString("lnam",lname);
        editor.commit();
    }


//back
    public void back(View view) {
        finish();
    }
//singbtn
    public void singup(View view) {
        final String fnamee = fnam.getText().toString().trim();
       // final String lnamee = lnam.getText().toString().trim();
        final String emaill = emai.getText().toString().trim();
        final String passwordd = passwor.getText().toString().trim();
        final String surepass = surepassword.getText().toString().trim();
        final String role = emai.getText().toString().trim();



        Response.Listener<String>listener =  new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try{
                    JSONObject object = new JSONObject(s);
                    Boolean ch = object.getBoolean("success");
                    if(TextUtils.isEmpty(fnamee))
                    {
                        fnam.setError("Frist name Required !");
                    }

                    if(TextUtils.isEmpty(emaill))
                    {
                        emai.setError("Email Required !");
                    }
                    if(TextUtils.isEmpty(passwordd))
                    {
                        passwor.setError("password Required !");
                    }
                    if(TextUtils.isEmpty(surepass))
                    {
                        surepassword.setError("password agein Required !");
                    }

                  else if(!surepass.equals(passwordd))
                    {
                        Toast.makeText(getBaseContext(), "الرجاء التحقق من تشابه كلمة السر", Toast.LENGTH_SHORT).show();
                    }
                   else if(ch==true)
                    {

                        Intent i = new Intent(Singup.this,reg_data.class);
                        i.putExtra("email",emaill);
                        i.putExtra("password",passwor.getText().toString());
                        Toast.makeText(getBaseContext(), "تم التسجيل بنجاح.", Toast.LENGTH_SHORT).show();
                        startActivity(i);

                    }
                    else
                    {
                        Toast.makeText(getBaseContext(), "الاسم او البريد مستخدم بالفعل! ", Toast.LENGTH_SHORT).show();
                    }

                }catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }

        };

        register r = new register(fnamee,emaill,passwordd,listener);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(r);

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

    public void passhiden2(View view) {
        if(view.getId()==R.id.images2)
        {
            if(surepassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                ((ImageView) (view)).setImageResource(R.drawable.ic_remove_red_eye_black_24dp);
                surepassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView) (view)).setImageResource(R.drawable.ic_visibility_off_black_24dp);
                surepassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
}
