package com.example.soso.doctors;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SoSo on 4/2/2020.
 */

public class update_map extends StringRequest {
    private static final    String url = "http://192.168.43.176/projects/upd.php";
    private Map<String,String> map;

    public update_map(String fname,String email, String password,String id,String image, Response.Listener<String> listener) {
        super(Method.POST, url,listener,null);
        map = new HashMap<>();
        map.put("fname",fname);

        map.put("email",email);
        map.put("password",password);
        map.put("id",id);
        map.put("image",image);
    }


    @Override
    protected Map<String, String> getParams() {
        return map;
    }
}
