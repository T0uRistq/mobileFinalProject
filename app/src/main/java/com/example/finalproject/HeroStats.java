package com.example.finalproject;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HeroStats {
    Context context;
    ArrayList <Hero> tmp;
    RequestQueue requestQueue;

    public HeroStats(Context context){
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(ArrayList<Hero> hs);
    }

    public void getHeroStats(int id, VolleyResponseListener volleyResponseListener){
        tmp = new ArrayList<>();
        String url = "https://api.opendota.com/api/heroes/" + String.valueOf(id) + "/matchups";
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++){
                                JSONObject jo = response.getJSONObject(i);
                                tmp.add(new Hero(jo.getInt("hero_id"), jo.getInt("wins"), jo.getInt("games_played")));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        volleyResponseListener.onResponse(tmp);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        volleyResponseListener.onError(error.getMessage());
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }
}
