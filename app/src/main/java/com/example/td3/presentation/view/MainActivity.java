package com.example.td3.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.td3.Constant;
import com.example.td3.R;
import com.example.td3.data.cryptoAPI;
import com.example.td3.presentation.controller.MainController;
import com.example.td3.presentation.model.Coin;
import com.example.td3.presentation.model.CryptoApiResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private Gson gson;
    public MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("application esiea", Context.MODE_PRIVATE);
        controller = new MainController();
        controller.OnStart();


        gson = new GsonBuilder()
                .setLenient()
                .create();
        List<Coin> coinList = getDataFromCache();
        if (coinList != null) {
            showList(coinList);
            Toast.makeText(getApplicationContext(), "affichage liste en cache", Toast.LENGTH_SHORT).show();

        }else{
            makeApiCall();
        }
    }

    private List<Coin> getDataFromCache() {
        String jsonCoin = sharedPreferences.getString(Constant.KEY_COIN_LIST, null);

        if(jsonCoin == null){
            return null;
        } else{
            Type listType = new TypeToken<List<Coin>>(){}.getType();
            return gson.fromJson(jsonCoin, listType);
        }


    }

    private void showList(List<Coin> coinList) {
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        // define an adapter
        mAdapter = new ListAdapter(coinList);
        recyclerView.setAdapter(mAdapter);

    }


    private void makeApiCall(){



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        cryptoAPI cryptoAPI = retrofit.create(cryptoAPI.class);

        Call<CryptoApiResponse> call = cryptoAPI.getCoinResponse();
        call.enqueue(new Callback<CryptoApiResponse>() {
            @Override
            public void onResponse(Call<CryptoApiResponse> call, Response<CryptoApiResponse> response) {
                if (response.isSuccessful() && response.body() != null){
                    List<Coin> coinList = response.body().getData().getCoins();
                    saveList(coinList);
                    showList(coinList);
                }
                else{
                    showError();
                }
            }

            @Override
            public void onFailure(Call<CryptoApiResponse> call, Throwable t) {
                showError();
            }
        });

    }

    private void saveList(List<Coin> coinList) {
        String jsonString = gson.toJson(coinList);
        sharedPreferences
                .edit()
                .putString("jsonCoinList", jsonString)
                .apply();
        Toast.makeText(getApplicationContext(), "Liste sauvegardée", Toast.LENGTH_SHORT).show();

    }

    private void showError() {
        Toast.makeText(getApplicationContext(), "Erreur de l'API", Toast.LENGTH_SHORT).show();
    }
}
