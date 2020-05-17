package com.example.td3;

import com.example.td3.data.cryptoAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {

        private static Gson gsonInstance;
        private static cryptoAPI cryptoAPIInstance;

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
    }

