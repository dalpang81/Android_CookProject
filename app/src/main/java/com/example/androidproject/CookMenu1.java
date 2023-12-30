package com.example.androidproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CookMenu1 extends AppCompatActivity {

    private int index = 0;
    public int trueIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_menu1);

        GridLayout checkboxGridLayout = findViewById(R.id.checkboxGridLayout);
        LinearLayout receiptView = findViewById(R.id.receiptView);

        TextView receiptText = findViewById(R.id.receiptText);
        ImageButton buttonNext = findViewById(R.id.button2);
        ImageButton buttonPrevious = findViewById(R.id.button1);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if(index == 1) {
                    checkboxGridLayout.setVisibility(View.VISIBLE);
                    receiptView.setVisibility(View.GONE);
                }
                else if(index == 2) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("모든 재료를 넣고 섞어준다.");
                }
                else if(index == 3) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("팬에 식용유를 두르고 양념된 김치를 넣어준다.");
                }
                else if(index == 4) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("어느정도 볶아졌으면 밥을 넣고 볶아준다.");
                }
                else if(index == 5) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("맛있게 먹는다.");
                }


                else if(index > 5) {
                    Toast.makeText(getApplicationContext(), "마지막 페이지입니다.", Toast.LENGTH_SHORT).show();
                    index = 5;
                }
            }
        });

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if(index == 1) {
                    checkboxGridLayout.setVisibility(View.VISIBLE);
                    receiptView.setVisibility(View.GONE);
                }
                else if(index == 2) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("모든 재료를 넣고 섞어준다.");
                }
                else if(index == 3) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("팬에 식용유를 두르고 양념된 김치를 넣어준다.");
                }
                else if(index == 4) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("어느정도 볶아졌으면 밥을 넣고 볶아준다.");
                }
                else if(index == 5) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("맛있게 먹는다.");
                }

                else if(index < 0) {
                    Toast.makeText(getApplicationContext(), "첫번째 페이지입니다.", Toast.LENGTH_SHORT).show();
                    index = 0;
                }
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange)));

        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle("Chef Table");
        actionBar.setHomeAsUpIndicator(R.drawable.home);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(CookMenu1.this, MainActivity.class));
                return true;
            //finish();
            case R.id.scrap:
                if(trueIndex == 0) {
                    Toast.makeText(getApplicationContext(), "스크랩되었습니다.", Toast.LENGTH_SHORT).show();
                    onScrapButtonClick();
                    trueIndex++;
                }
                else if(trueIndex == 1) {
                    Toast.makeText(getApplicationContext(), "스크랩이 취소되었습니다.", Toast.LENGTH_SHORT).show();
                    onScrapButtonClick2();
                    trueIndex = 0;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void saveScrapData(String data) {
        SharedPreferences preferences = getSharedPreferences("ScrapData", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("scrap_key", data);
        editor.apply();
    }

    private void onScrapButtonClick() {
        String scrapData = "김치볶음밥";
        saveScrapData(scrapData);
    }

    private void onScrapButtonClick2() {
        String scrapData = "취소";
        saveScrapData(scrapData);
    }
}