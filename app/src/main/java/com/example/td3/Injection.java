package com.example.td3;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.td3.data.cryptoAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {

        private static Gson gsonInstance;
        private static cryptoAPI cryptoAPIInstance;
        private static SharedPreferences sharedPreferencesInstance;

        public static Gson getGson(){
            if(gsonInstance == null) {
                gsonInstance = new GsonBuilder()
                        .setLenient()
                        .create();
            }

                return gsonInstance;
            }
        public static cryptoAPI getCryptoApi() {
            if (cryptoAPIInstance == null) {


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constant.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(getGson()))
                        .build();

                cryptoAPIInstance = retrofit.create(cryptoAPI.class);
            }
            return cryptoAPIInstance;
        }
    public static SharedPreferences getSharedPreferences(Context context){
        if(sharedPreferencesInstance == null) {
            sharedPreferencesInstance = context.getSharedPreferences("application esiea", Context.MODE_PRIVATE);
        }

        return sharedPreferencesInstance;
    }
    }

