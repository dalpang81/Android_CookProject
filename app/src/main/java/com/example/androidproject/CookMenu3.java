package com.example.androidproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
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

public class CookMenu3 extends AppCompatActivity {

    private int index = 0;
    public int trueIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_menu3);

        GridLayout checkboxGridLayout = findViewById(R.id.checkboxGridLayout);
        LinearLayout receiptView = findViewById(R.id.receiptView);

        TextView receiptText = findViewById(R.id.receiptText);
        ImageButton buttonNext = findViewById(R.id.button2);
        ImageButton buttonPrevious = findViewById(R.id.button1);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index == 1) {
                    checkboxGridLayout.setVisibility(View.VISIBLE);
                    receiptView.setVisibility(View.GONE);
                }
                else if(index == 2) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("먼저 봉지 안에 짜파게티 사발면을 넣어 부숴준다.");
                }
                else if(index == 3) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("다시 컵 용기에 담아 면이 잠길때까지 \n미지근한물을 넣어준다.");
                }
                else if(index == 4) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("팬에 식용유를 두르고 양파 반개를 볶아준다.");
                }
                else if(index == 5) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("이후 밥 한공기와 미리 불려놓은 라면과 \n스프를 넣어준다.");
                }
                else if(index == 6) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("싱거우면 진간장 반스푼이나 굴소스 반스푼을 \n넣어준다.");
                }
                else if(index == 7) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("계란후라이와 함께 맛있게 먹는다.");
                }


                else if(index > 7) {
                    Toast.makeText(getApplicationContext(), "마지막 페이지입니다.", Toast.LENGTH_SHORT).show();
                    index = 7;
                }
            }
        });

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if (index == 1) {
                    checkboxGridLayout.setVisibility(View.VISIBLE);
                    receiptView.setVisibility(View.GONE);
                }
                else if(index == 2) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("먼저 봉지 안에 짜파게티 사발면을 넣어 부숴준다.");
                }
                else if(index == 3) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("다시 컵 용기에 담아 면이 잠길때까지 \n미지근한물을 넣어준다.");
                }
                else if(index == 4) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("팬에 식용유를 두르고 양파 반개를 볶아준다.");
                }
                else if(index == 5) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("이후 밥 한공기와 미리 불려놓은 라면과 \n스프를 넣어준다.");
                }
                else if(index == 6) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("싱거우면 진간장 반스푼이나 굴소스 반스푼을 \n넣어준다.");
                }
                else if(index == 7) {
                    checkboxGridLayout.setVisibility(View.GONE);
                    receiptView.setVisibility(View.VISIBLE);

                    receiptText.setText("계란후라이와 함께 맛있게 먹는다.");
                }
                else if (index < 0) {
                    Toast.makeText(getApplicationContext(), "첫번째 페이지입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ActionBar actionBar = getSupportActionBar();

        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Chef Table");
        actionBar.setHomeAsUpIndicator(R.drawable.home);
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange)));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(CookMenu3.this, MainActivity.class));
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

                return true;
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
        SharedPreferences preferences = getSharedPreferences("ScrapData3", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("scrap_key", data);
        editor.apply();
    }

    private void onScrapButtonClick() {
        String scrapData = "짜장";
        saveScrapData(scrapData);
    }

    private void onScrapButtonClick2() {
        String scrapData = "취소";
        saveScrapData(scrapData);
    }
}