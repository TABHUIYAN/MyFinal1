package com.example.bhuiyan.myfinal1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
TextView disTerm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        disTerm= (TextView) findViewById(R.id.txTerm);
        disTerm.setOnClickListener(new View.OnClickListener() { //On click listener fuction where map button click to
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutActivity.this, TermsActivity.class); //Maps activivty intent
                startActivity(intent);
            }
        });
    }

    public void disTerm(View view) {
        startActivity(new Intent(AboutActivity.this, TermsActivity.class));
    }
}
