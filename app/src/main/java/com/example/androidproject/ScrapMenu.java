package com.example.androidproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ScrapMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrap_menu);
        String scrapData = getScrapData();
        String scrapData2 = getScrapData2();
        String scrapData3 = getScrapData3();

        LinearLayout cook1 = findViewById(R.id.cook1);
        LinearLayout cook2 = findViewById(R.id.cook2);
        LinearLayout cook3 = findViewById(R.id.cook3);

        ImageButton imageButton = findViewById(R.id.imageButton);
        ImageButton imageButton1 = findViewById(R.id.imageButton1);
        ImageButton imageButton2 = findViewById(R.id.imageButton2);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange)));

        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle("스크랩 보기");
        actionBar.setHomeAsUpIndicator(R.drawable.home);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScrapMenu.this, CookMenu1.class));
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScrapMenu.this, CookMenu2.class));
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScrapMenu.this, CookMenu3.class));
            }
        });

        if(scrapData.equals("김치볶음밥")) {
            cook1.setVisibility(View.VISIBLE);
        }
        else if(scrapData.equals("취소")) {
            cook1.setVisibility(View.GONE);
        }

        if(scrapData2.equals("삼겹살")) {
            cook2.setVisibility(View.VISIBLE);
        }
        else if(scrapData2.equals("취소")) {
            cook2.setVisibility(View.GONE);
        }

        if(scrapData3.equals("짜장")) {
            cook3.setVisibility(View.VISIBLE);
        }
        else if(scrapData3.equals("취소")) {
            cook3.setVisibility(View.GONE);
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(ScrapMenu.this, MainActivity3.class));

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private String getScrapData() {
        SharedPreferences preferences = getSharedPreferences("ScrapData", MODE_PRIVATE);
        return preferences.getString("scrap_key", "");
    }

    private String getScrapData2() {
        SharedPreferences preferences = getSharedPreferences("ScrapData2", MODE_PRIVATE);
        return preferences.getString("scrap_key", "");
    }

    private String getScrapData3() {
        SharedPreferences preferences = getSharedPreferences("ScrapData3", MODE_PRIVATE);
        return preferences.getString("scrap_key", "");
    }
}
