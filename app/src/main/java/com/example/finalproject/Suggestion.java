package com.example.finalproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.TreeSet;

public class Suggestion extends AppCompatActivity {
    TextView tv;
    Button button, buttonr, buttond;
    ImageView imageView;
    ArrayList <ArrayList <Hero>> heroes = new ArrayList <ArrayList <Hero>>();
    int cntr, cntd;
    int cur = 0;
    int dId[], rId[];
    float minf = 5, mins = 5, mint = 5;
    int choicef = 0, choices = 0, choicet = 0;
    HeroStats hs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suggestion);
        Bundle args = getIntent().getExtras();
        dId = (int[]) args.get("dire");
        rId = (int[]) args.get("radiant");
        cntd = args.getInt("dsize");
        cntr = args.getInt("rsize");
        tv = findViewById(R.id.suggestion1);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.pudge);
        buttonr = findViewById(R.id.buttonr);
        buttond = findViewById(R.id.buttond);
        hs = new HeroStats(Suggestion.this);
    }

    public void goThrough(){
        hs.getHeroStats(rId[cur], new HeroStats.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(Suggestion.this, message, Toast.LENGTH_SHORT);
            }

            @Override
            public void onResponse(ArrayList<Hero> hsa) {
                heroes.add(hsa);
                cur++;
                if (cur == cntr){
                    button.setVisibility(View.VISIBLE);
                } else {
                    goThrough();
                }
            }
        });
    }

    public void calculate(){
        for (int i = 0; i < MainActivity.ids.length; i++){
            int curId = MainActivity.ids[i];
            boolean flag = false;
            for (int id : rId){
                if (id == curId) {
                    flag = true;
                    break;
                }
            }
            if (flag || curId == 135 || curId == 123){
                continue;
            }
            float total = 0;
            for (ArrayList<Hero> against : heroes){
                for (Hero hero : against) {
                    if (hero.hero_id == curId){
                        total += (float) hero.wins / hero.games_played;
                        break;
                    }
                }
            }
            if (total < minf) {
                minf = total;
                choicef = i;
                choices = choicef;
                choicet = choices;
            } else
            if (total < mins) {
                mins = total;
                choices = i;
                choicet = choices;
            } else
            if (total < mint) {
                mint = total;
                choicet = i;
            }
        }
        imageView.setImageResource(MainActivity.imageRes[choicef]);
        tv.setText(String.valueOf(MainActivity.s1[choicef]));
    }

    public void showHeroes(View view) {
        goThrough();
        calculate();
    }

    public void god(View view) {
        tv.setText("");
        buttond.setVisibility(View.GONE);
        buttonr.setVisibility(View.GONE);
        goThrough();
    }

    public void gor(View view) {
        tv.setText("");
        buttond.setVisibility(View.GONE);
        buttonr.setVisibility(View.GONE);
        int tmp[] = rId;
        rId = dId;
        dId = tmp;
        int tmps = cntr;
        cntr = cntd;
        cntd = tmps;
        goThrough();
    }
}
