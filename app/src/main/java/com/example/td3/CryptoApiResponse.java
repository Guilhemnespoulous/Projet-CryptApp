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
}
