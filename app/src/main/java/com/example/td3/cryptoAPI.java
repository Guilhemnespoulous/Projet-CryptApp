package com.example.td3;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface cryptoAPI {

    @GET("https://api.coinranking.com/v1/public/coins")
    Call<CryptoApiResponse> getCoinResponse();
}
