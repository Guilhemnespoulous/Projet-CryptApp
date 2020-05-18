package com.example.td3.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.td3.Constant;
import com.example.td3.Injection;
import com.example.td3.R;
import com.example.td3.presentation.controller.MainController;
import com.example.td3.presentation.model.Coin;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        txtDetail = findViewById(R.id.detail_txt);
        Intent intent = getIntent();
        String coinJson = intent.getStringExtra(Constant.KEY_COIN);
        Coin coin = Injection.getGson().fromJson(coinJson, Coin.class);
        showDetail(coin);
    }

    private void showDetail(Coin coin) {
        txtDetail.setText(coin.getName());
    }
}
