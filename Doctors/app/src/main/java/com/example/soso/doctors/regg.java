package com.example.soso.doctors;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SoSo on 3/24/2020.
 */

public class regg extends StringRequest {
    private static final String url = "http://192.168.43.176/projects/insertp.php";
    private Map<String,String> map;
    public regg(String user_id,String pas_num,String gender,String birthday,String address,String blod,String social_status,String sensitivity,String genetic_diseases,String bad_habit , Response.Listener<String> listener) {
        super(Method.POST, url, listener, null);
        map = new HashMap<>();
        map.put("user_id",user_id);
        map.put("patriot_number",pas_num);
        map.put("gender",gender);
        map.put("birthday",birthday);
        map.put("address",address);
        map.put("blood_type",blod);
        map.put("social_status",social_status);
        map.put("sensitivity",sensitivity);
        map.put("genetic_diseases",genetic_diseases);
        map.put("bad_habit",bad_habit);

    }
    @Override
    protected Map<String, String> getParams() {
        return map;
    }
}