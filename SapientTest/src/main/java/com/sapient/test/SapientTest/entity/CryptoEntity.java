package com.sapient.test.SapientTest.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class CryptoEntity {
    private String coin;
    private String wallet;
    private String network;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }
}
