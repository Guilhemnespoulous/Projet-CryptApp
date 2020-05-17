package com.example.td3.data;

import com.example.td3.presentation.model.CryptoApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface cryptoAPI {

    @GET("/v1/public/coins")
    Call<CryptoApiResponse> getCoinResponse();
}
