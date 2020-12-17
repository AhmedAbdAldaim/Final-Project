package com.example.soso.doctors;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SoSo on 3/24/2020.
 */

public class sure extends StringRequest {
    private static final String url = "http://192.168.43.176/projects/sur.php";
    private Map<String,String> map;
    public sure(String iddoc,String iddpic,String date,Response.Listener<String> listener) {
        super(Request.Method.POST, url, listener,null);
        map = new HashMap<>();
        map.put("iddoc",iddoc);
        map.put("idpic",iddpic);
        map.put("date",date);

    }
    @Override
    protected Map<String, String> getParams() {
        return map;
    }
}