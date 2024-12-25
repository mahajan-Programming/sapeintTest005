package com.sapient.test.SapientTest.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class BankEntity {
    private String cardExpire;
    private String cardNumber;
    private String cardType;
    private String currency;
    private String iban;

}
