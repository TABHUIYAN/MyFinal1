package com.example.bhuiyan.myfinal1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * display list view
 * list view adapter
 * Activity which creats new list
 */
public class DisplayListView extends AppCompatActivity {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ListAdapter listAdapter;
    ListView listView;
    ListView displayLi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview);




        listView=(ListView) findViewById(R.id.listview);
        listAdapter=new ListAdapter(this,R.layout.row_layout);

        listView.setAdapter(listAdapter);

        json_string=getIntent().getExtras().getString("json_data");
        try {
            // jsonObject=new JSONObject(json_string);
            // jsonArray=jsonObject.getJSONArray("O");
            JSONArray json=new JSONArray(json_string);
            int i=0;
            //String number,name,address;
            String number,name,address,position,position1,banking,bonus,status,contract_name,bike_stands,available_bike_stands,available_bikes,last_update;

//JSON array

            while(i<=json.length()){
                JSONObject JO=json.getJSONObject(i);
                JSONObject jb=JO.getJSONObject("position");
                jb.get("lat");
                jb.get("lng");

                ListItem.xLat.add((double)jb.get("lat"));
                ListItem.yLng.add((double)jb.get("lng"));
                ListItem.myName.add((String)JO.get("name"));


                number=JO.getString("number");
                name=JO.getString("name");
                address=JO.getString("address");
                position= jb.getString("lat");
                position1 = jb.getString("lng");

                banking = JO.getString("banking");
                bonus = JO.getString("bonus");
                status = JO.getString("status");
                contract_name = JO.getString("contract_name");
                bike_stands = JO.getString("bike_stands");
                available_bike_stands = JO.getString("available_bike_stands");
                available_bikes = JO.getString("available_bikes");
                last_update = JO.getString("last_update");


                ListItem listItem=new ListItem(" "+ number,""+name,
                        ""+address,"Latitude: "+position,"Longitude: "+position1,
                        "Banking:"+banking,"Bonus: "+bonus,"status: "+status,
                        "contractName: "+contract_name, "bikeStands: "+bike_stands,
                        "availableStands: "+available_bike_stands,
                        "availableBikes: "+available_bikes, "lastUpdate: "+last_update);
                listAdapter.add(listItem);

                i++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
