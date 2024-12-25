package com.sapient.test.SapientTest.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Bank {
    private String cardExpire;
    private String cardNumber;
    private String cardType;
    private String currency;
    private String iban;

}
