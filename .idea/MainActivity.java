package com.example.bhuiyan.myfinal1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * list View intent
 * map view intent
 * weather View page
 */
public class MainActivity extends AppCompatActivity {

    //initial variable
    String json_string;
    Button displayMap;
    Button displayWeather;
    Button displayAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayMap= (Button) findViewById(R.id.btn_Map);
        displayMap.setOnClickListener(new View.OnClickListener() { //On click listener fuction where map button click to
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class); //Maps activivty intent
                startActivity(intent);
            }
        });
    displayWeather=(Button)findViewById(R.id.btn_weather);
    displayWeather.setOnClickListener(new View.OnClickListener() {   //Weather activity intent
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this,"weather",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(MainActivity.this,WeatherActivity.class);
        startActivity(intent);
    }
});
    displayAbout=(Button)findViewById(R.id.btn_About); //About Button
        displayAbout.setOnClickListener(new View.OnClickListener() { //On click listener fuction where about button click to
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class); //Maps activivty intent
                startActivity(intent);
            }
            });
    }

            public void displayAbout(View view) {
                startActivity(new Intent(MainActivity.this,AboutActivity.class));

            }

    /**
     * dublin bike api data retrived
     */
            class BackgroundTask extends AsyncTask<Void, Void, String> {
                String JSON_STRING;
                String json_url;

                @Override
                protected void onPreExecute() {
                    json_url = "https://api.jcdecaux.com/vls/v1/stations?contract=Dublin&apiKey=92b7c012575bb4ed4af55ec3423f624870997d63";
                }

                @Override
                protected String doInBackground(Void... voids) {
                    try {
                        URL url = new URL(json_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuilder stringBuilder = new StringBuilder();

                        while ((JSON_STRING = bufferedReader.readLine()) != null) {
                            stringBuilder.append(JSON_STRING + "\n");
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return stringBuilder.toString().trim();


                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    return null;
                }

                @Override
                protected void onProgressUpdate(Void... values) {
                    super.onProgressUpdate(values);
                }

                @Override
                protected void onPostExecute(String result) {
                    TextView textView = (TextView) findViewById(R.id.textView);
                    textView.setText(result);
                    json_string = result;
                }

            }

    /**
     * first get json array, and go to list view
     *
     */
            public void parseJSON(View view) {
                new BackgroundTask().execute();
                if (json_string == null) {
                    Toast.makeText(getApplicationContext(), "Json Array", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(this, DisplayListView.class);
                    intent.putExtra("json_data", json_string);
                    startActivity(intent);
                }

            }
//Map view
            public void displayMap(View view) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));

            }
//Weather view
            public void displayWeather(View view) {
                startActivity(new Intent(MainActivity.this, WeatherActivity.class));

            }

        }



