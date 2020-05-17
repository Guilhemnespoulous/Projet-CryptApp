package com.example.td3.presentation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.td3.Constant;
import com.example.td3.data.cryptoAPI;
import com.example.td3.presentation.model.Coin;
import com.example.td3.presentation.model.CryptoApiResponse;
import com.example.td3.presentation.view.MainActivity;
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

public class MainController {

    private SharedPreferences sharedPreferences;
    private Gson gson;
    private MainActivity view;

    public MainController(MainActivity mainActivity, Gson gson, SharedPreferences sharePreferences){
        this.view = mainActivity;
        this.gson = gson;
        this.sharedPreferences = sharePreferences;
    }
    public void onStart(){



        List<Coin> coinList = getDataFromCache();
        if (coinList != null) {
            view.showList(coinList);
            Toast.makeText(view.getApplicationContext(), "affichage liste en cache", Toast.LENGTH_SHORT).show();

        }else{
            makeApiCall();
        }
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
                    view.showList(coinList);
                }
                else{
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<CryptoApiResponse> call, Throwable t) {
                view.showError();
            }
        });

    }

    private void saveList(List<Coin> coinList) {
        String jsonString = gson.toJson(coinList);
        sharedPreferences
                .edit()
                .putString("jsonCoinList", jsonString)
                .apply();
        Toast.makeText(view.getApplicationContext(), "Liste sauvegardée", Toast.LENGTH_SHORT).show();

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
}
