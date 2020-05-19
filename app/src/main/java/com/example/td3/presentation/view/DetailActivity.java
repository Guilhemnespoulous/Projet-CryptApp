package com.example.td3.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
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
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private TextView txtDetail;
    private TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        txtDetail = findViewById(R.id.detail_txt);
        textView2 = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String coinJson = intent.getStringExtra(Constant.KEY_COIN);
        Coin coin = Injection.getGson().fromJson(coinJson, Coin.class);
        ImageView coinLogo = findViewById(R.id.coinLogo);
        //Etant donné que l'API que j'ai choisi ne contient que des logos en format SVG que je n'ai pas réussi à afficher sous android, j'ai contourné le problème en utilisant un autre site et une concaténation.
        String url = "https://raw.githubusercontent.com/spothq/cryptocurrency-icons/master/128/color/" + coin.getSymbol().toLowerCase() + ".png";
        Picasso.with(this).load(url).into(coinLogo);
        showDetail(coin);
    }

    private void showDetail(Coin coin) {
        txtDetail.setText(coin.getName());
        textView2.setText(coin.getSymbol().toLowerCase());

    }
}
