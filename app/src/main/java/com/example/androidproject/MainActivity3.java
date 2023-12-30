package com.example.androidproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        String scrapData = getScrapData();

        ImageButton button3 = findViewById(R.id.button3);
        ImageButton homeButton = findViewById(R.id.homeButton);
        ImageButton searchButton = findViewById(R.id.searchButton);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity3.this, ScrapMenu.class));

            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼2를 클릭했을 때 AnotherActivity를 시작
                startActivity(new Intent(MainActivity3.this, MainActivity.class));
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼2를 클릭했을 때 AnotherActivity를 시작
                startActivity(new Intent(MainActivity3.this, MainActivity2.class));
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private String getScrapData() {
        SharedPreferences preferences = getSharedPreferences("ScrapData", MODE_PRIVATE);
        return preferences.getString("scrap_key", "");
    }
}