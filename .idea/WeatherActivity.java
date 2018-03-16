package com.example.bhuiyan.myfinal1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * weather json api
 * json object and arrays
 */
public class WeatherActivity extends AppCompatActivity {
    TextView t1_temp,t2_city,t3_description,t4_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        //text view identifier
        t1_temp=(TextView)findViewById(R.id.textView);
        t2_city=(TextView)findViewById(R.id.textView3);
        t3_description=(TextView)findViewById(R.id.textView4);
        t4_date=(TextView)findViewById(R.id.textView2);
        find_weather();
    }

    public void find_weather(){
        String url="http://api.openweathermap.org/data/2.5/weather?q=Dublin,ie&appid=060fd89a4b169624d798311ec5735e16&units=imperial";
        JsonObjectRequest jor= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject main_object=response.getJSONObject("main");
                    JSONArray array=response.getJSONArray("weather");
                    JSONObject object=array.getJSONObject(0);
                    String temp= String.valueOf(main_object.getDouble("temp"));
                    String description=object.getString("description");
                    String city=response.getString("name");


                    // t1_temp.setText(temp);
                    t2_city.setText(city);
                    t3_description.setText(description);
                    Calendar calender=Calendar.getInstance();
                    SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
                    String formated_date=sdf.format(calender.getTime());
                    t4_date.setText(formated_date);

                    double temp_int=Double.parseDouble(temp);
                    double centi=(temp_int-32)/1.8000;
                    centi=Math.round(centi);
                    int i=(int)centi;
                    t1_temp.setText(String.valueOf(i));






                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() { //Volley librarys
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(jor);
    }

}

