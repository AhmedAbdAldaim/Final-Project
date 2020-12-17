package com.example.soso.doctors;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SoSo on 4/2/2020.
 */

public class update_mapimage extends StringRequest {
    private static final    String url = "http://192.168.43.176/projects/upd_image.php";
    private Map<String,String> map;

    public update_mapimage(String id,String image, Response.Listener<String> listener) {
        super(Method.POST, url,listener,null);
        map = new HashMap<>();
        map.put("id",id);
        map.put("image",image);
    }


    @Override
    protected Map<String, String> getParams() {
        return map;
    }
}
