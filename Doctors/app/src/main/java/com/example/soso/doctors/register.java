package com.example.soso.doctors;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SoSo on 3/24/2020.
 */

public class register extends StringRequest {
    private static final String url = "http://192.168.43.176/projects/registerr.php";
    private Map<String,String> map;
    public register(String fname,String email, String password,Response.Listener<String> listener) {
        super(Request.Method.POST, url, listener,null);
        map = new HashMap<>();
        map.put("fname",fname);
        map.put("email",email);
        map.put("password",password);

    }
    @Override
    protected Map<String, String> getParams() {
        return map;
    }
}