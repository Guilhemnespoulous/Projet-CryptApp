package com.example.td3;

import java.util.List;

public class CryptoApiResponse {
    private String status;
    private List<coins> coins;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<com.example.td3.coins> getCoins() {
        return coins;
    }

    public void setCoins(List<com.example.td3.coins> coins) {
        this.coins = coins;
    }
}
