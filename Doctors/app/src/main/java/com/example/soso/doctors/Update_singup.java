package com.example.soso.doctors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Update_singup extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    ImageView imageView;
    String ec ;
    //RequestQueue requestQueue;
    //String url = "http://192.168.43.172/projects/upd.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_singup);
         e1 =(EditText)findViewById(R.id.fname);
        e3 =(EditText)findViewById(R.id.email);
        e4 =(EditText)findViewById(R.id.password);
        e5 =(EditText)findViewById(R.id.id);

        imageView =(ImageView)findViewById(R.id.selectimg);

        Intent intent = getIntent();
        String f = intent.getStringExtra("fname");

        String e = intent.getStringExtra("email");
        String p = intent.getStringExtra("password");
        String i = intent.getStringExtra("id");

        e1.setText(f);
        e3.setText(e);
        e4.setText(p);
        e5.setText(i);

        Bundle ee = getIntent().getExtras();
        Bitmap b = (Bitmap) ee.getParcelable("img");
        imageView.setImageBitmap(b);

    }



    public void update(View view) {
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        ec = Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);

        final String fnamee = e1.getText().toString().trim();
        final String emaill = e3.getText().toString().trim();
        final String passwordd = e4.getText().toString().trim();
        final String id = e5.getText().toString().trim();
        final Response.Listener<String>listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try{
                    JSONObject object = new JSONObject(s);
                    Boolean ch = object.getBoolean("success");
                     if(ch==true)
                    {
                      Toast.makeText(getBaseContext(), "تم التعديل بنجاح.", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(), "لم يتم ", Toast.LENGTH_SHORT).show();
                    }

                }catch (JSONException e){e.printStackTrace();}
            }

        };
        update_map r = new update_map(fnamee,emaill,passwordd,id,ec,listener);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(r);
        update_mapimage r2 = new update_mapimage(id,ec,listener);
        RequestQueue requestQueue2 = Volley.newRequestQueue(this);
        requestQueue2.add(r2);


    }
    public void selectimg(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==100&&resultCode==RESULT_OK)
        {
            Uri uri = data.getData();
            imageView.setImageURI(uri);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void back(View view) {
        finish();
    }

    public void passhiden(View view) {
        if (view.getId() == R.id.imageseyes) {
            if (e4.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                ((ImageView) (view)).setImageResource(R.drawable.ic_remove_red_eye_black_24dp);
                e4.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                ((ImageView) (view)).setImageResource(R.drawable.ic_visibility_off_black_24dp);
                e4.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }


}