package com.example.soso.doctors;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
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
import java.util.Arrays;
import java.util.List;

public class reg_data extends AppCompatActivity {
RequestQueue requestQueue;
    EditText eid,enu_p,sensit,gen,bad;
    String id,em,pa;
    RadioGroup r1;
    RadioButton r2;
    private TextView textView;
    Spinner addresss,bloods,sochal;
    String tutorialsName,bloadsel,sochls;
    private static final String Tag = "reg";
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_data);




        eid = (EditText) findViewById(R.id.id_user);
        enu_p = (EditText) findViewById(R.id.patriot_numberr);
        sensit = (EditText) findViewById(R.id.sensitivity);
        gen = (EditText) findViewById(R.id.genetic_diseases);
        bad = (EditText) findViewById(R.id.bad_habit);
        textView = (TextView) findViewById(R.id.date);

        final Intent i = getIntent();
        em = i.getStringExtra("email");
        pa = i.getStringExtra("password");
        String url = "http://192.168.43.176/projects/get_id_to.php?email=" + em;
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("all");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        id = object.getString("id");
                        eid.setText(id);
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
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int Day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(reg_data.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,onDateSetListener,year,month,Day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.e(Tag,"onDateSet : mm/dd/yyy:" + year + "/" + month+ "/" + dayOfMonth);
                String date = year + "-" + month + "-" + dayOfMonth;
                textView.setTextColor(getResources().getColor(R.color.black));
                textView.setText(date);
                if(TextUtils.isEmpty(date)){

                    textView.setError("Barithday Required !");
                }
            }
        };

        addresss = (Spinner)findViewById(R.id.spinner);
        ArrayList<String> arrayListaddress = new ArrayList<>();
        arrayListaddress.add("Select an item...");
        arrayListaddress.add("Khartoum");
        arrayListaddress.add("Omdraman");
        arrayListaddress.add("Bahri");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayListaddress){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
        }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){

                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addresss.setAdapter(arrayAdapter);
        addresss.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tutorialsName = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
        bloods = (Spinner)findViewById(R.id.blood);
        ArrayList<String> arrayListbload = new ArrayList<>();
        arrayListbload.add("Select an item...");
        arrayListbload.add("A");
        arrayListbload.add("O");
        arrayListbload.add("A+");

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayListbload){

            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){

                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloods.setAdapter(arrayAdapter1);
        bloods.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bloadsel = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
        sochal = (Spinner)findViewById(R.id.social_status);
        ArrayList<String> arrayListsociall = new ArrayList<>();
        arrayListsociall.add("Select an item...");
        arrayListsociall.add("married");
        arrayListsociall.add("single");
        arrayListsociall.add("divorced");
        ArrayAdapter<String> arrayAdapterr = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayListsociall){

            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){

                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        arrayAdapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sochal.setAdapter(arrayAdapterr);
        sochal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sochls = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
    }



    public void insert(View view) {
    r1 = (RadioGroup)findViewById(R.id.radioSex);
        int selectedId = r1.getCheckedRadioButtonId();
        r2 =(RadioButton)findViewById(selectedId);
        final String rad = r2.getText().toString();
        final String idu = eid.getText().toString().trim();
        final String p_n = enu_p.getText().toString().trim();
        final String date = textView.getText().toString();
        final String sen = sensit.getText().toString().trim();
        final String gn = gen.getText().toString().trim();
        final String bd = bad.getText().toString().trim();



        Response.Listener<String>listener =  new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try{
                    JSONObject object = new JSONObject(s);
                    Boolean ch = object.getBoolean("success");
                    if(TextUtils.isEmpty(p_n))
                    {
                        enu_p.setError("patriot number Required !");
                    }
                    if(TextUtils.isEmpty(sen))
                    {
                        sensit.setError("sensitivity Required !");
                    }
                    if(TextUtils.isEmpty(gn))
                    {
                        gen.setError("genetic diseases Required !");
                    }
                    if(TextUtils.isEmpty(bd))
                    {
                        bad.setError("bad habit Required !");
                    }
                    if(TextUtils.isEmpty(date)){

                        textView.setError("Barithday Required !");
                    }
                    if (tutorialsName.equals("Select an item...")) {
                        TextView errorText = (TextView)addresss.getSelectedView();
                        errorText.setError("Address Required !");
                    }
                    if (bloadsel.equals("Select an item...")) {
                        TextView errorText1 = (TextView)bloods.getSelectedView();
                        errorText1.setError("Blood Type Required !");
                    }
                    if (sochls.equals("Select an item...")) {
                        TextView errorText2 = (TextView)sochal.getSelectedView();
                        errorText2.setError("Social Status Required !");
                    }

                    else if(ch==true)
                    {

                        Intent i = new Intent(reg_data.this,Login.class);
                        i.putExtra("email",em);
                        i.putExtra("password",pa);
                        i.putExtra("id_user",idu);
                        Toast.makeText(getBaseContext(), "تم التسجيل بنجاح.", Toast.LENGTH_SHORT).show();
                        startActivity(i);

                    }
                    else
                    {
                        Toast.makeText(getBaseContext(), "الاسم او البريد مستخدم بالفعل! ", Toast.LENGTH_SHORT).show();
                    }

                }catch (JSONException e){e.printStackTrace();}
            }

        };
        regg r = new regg(idu ,p_n,rad,date,tutorialsName,bloadsel,sochls,sen,gn,bd,listener);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(r);
    }



}
