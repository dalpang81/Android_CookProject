package com.example.androidproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity2 extends AppCompatActivity {
    private EditText searchEditText;
    private Set<String> searchHistorySet;
    private ArrayAdapter<String> searchHistoryAdapter;
    private ListView searchHistoryListView;
    private ImageButton porkButton, kimchiButton, jajangButton;
    private LinearLayout cook1, cook2, cook3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        searchEditText = findViewById(R.id.searchEditText);
        Button searchButton = findViewById(R.id.searchButton);
        searchHistoryListView = findViewById(R.id.searchHistoryListView);
        porkButton = findViewById(R.id.imageButton1);
        kimchiButton = findViewById(R.id.imageButton2);
        jajangButton = findViewById(R.id.imageButton3);
        cook1 = findViewById(R.id.cook1);
        cook2 = findViewById(R.id.cook2);
        cook3 = findViewById(R.id.cook3);


        kimchiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, CookMenu1.class));
            }
        });

        porkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, CookMenu2.class));
            }
        });

        jajangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, CookMenu3.class));
            }
        });

        // 검색 기록을 불러오기
        loadSearchHistory();

        // 검색 기록을 표시할 어댑터 초기화
        searchHistoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(searchHistorySet));
        searchHistoryListView.setAdapter(searchHistoryAdapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSearch();
                saveSearchText();
                updateSearchHistory(); // 검색 후 검색 기록 갱신


            }
        });

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // 이 메소드는 텍스트 변경 전에 호출됩니다.
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // 이 메소드는 텍스트가 변경될 때 호출됩니다.
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 이 메소드는 텍스트 변경 후에 호출됩니다.
                handleSearchEditTextChange(editable.toString());
            }
        });

        ImageButton homeButton = findViewById(R.id.homeButton);
        ImageButton moreButton = findViewById(R.id.moreButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼2를 클릭했을 때 AnotherActivity를 시작
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });

        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼2를 클릭했을 때 AnotherActivity를 시작
                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void handleSearchEditTextChange(String searchText) {
        if (searchText.isEmpty()) {
            // EditText의 내용이 비어 있으면 ListView를 VISIBLE으로 설정
            searchHistoryListView.setVisibility(View.VISIBLE);
        } else {
            // EditText의 내용이 있으면 ListView를 GONE로 설정
            searchHistoryListView.setVisibility(View.GONE);
            if(searchText.equals("김치")) {
                cook2.setVisibility(View.VISIBLE);
            }
            else if(searchText.equals("삼겹살")) {
                cook1.setVisibility(View.VISIBLE);
            }
            else if(searchText.equals("짜장")) {
                cook3.setVisibility(View.VISIBLE);
            }
            else {
                cook1.setVisibility(View.GONE);
                cook2.setVisibility(View.GONE);
                cook3.setVisibility(View.GONE);
            }
        }
    }

    private void performSearch() {
        String searchText = searchEditText.getText().toString().trim();
        if (!searchText.isEmpty()) {
            // 검색어를 검색 기록에 추가
            addToSearchHistory(searchText);

            // 검색어가 비어 있지 않은 경우 토스트 메시지 표시
            Toast.makeText(this, "검색어: " + searchText, Toast.LENGTH_SHORT).show();


            // 검색 완료 후 EditText 초기화
            searchEditText.setText("");
        } else {
            // 검색어가 비어 있는 경우에 대한 처리
            Toast.makeText(this, "검색어를 입력하세요", Toast.LENGTH_SHORT).show();
        }
    }

    private void addToSearchHistory(String searchText) {
        // 검색 기록을 Set에 추가
        searchHistorySet.add(searchText);

        // Set을 SharedPreferences에 저장
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putStringSet("searchHistory", searchHistorySet);
        editor.apply();
    }

    private void loadSearchHistory() {
        // SharedPreferences에서 검색 기록 불러오기
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        searchHistorySet = preferences.getStringSet("searchHistory", new HashSet<>());
    }

    private void saveSearchText() {
        // 검색 버튼을 눌렀을 때 EditText의 내용을 SharedPreferences에 저장
        String searchText = searchEditText.getText().toString().trim();

        if (!searchText.isEmpty()) {
            SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("lastSearchText", searchText);
            editor.apply();
        }
    }

    private void updateSearchHistory() {
        // 검색 후 검색 기록 갱신
        searchHistoryAdapter.clear();
        searchHistoryAdapter.addAll(searchHistorySet);
        searchHistoryAdapter.notifyDataSetChanged();
    }
}