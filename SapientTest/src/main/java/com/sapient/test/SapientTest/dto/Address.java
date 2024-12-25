package com.sapient.test.SapientTest.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Address {
    private String address;
    private String city;
    private String state;
    private String stateCode;
    private String postalCode;
    private Coordinates coordinates;
    private String country;
}
