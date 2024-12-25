package com.sapient.test.SapientTest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class AddressEntity {
    @Column(name = "address")
    private String address;
    private String city;
    private String state;
    private String stateCode;
    private String postalCode;
    private String country;

    @Embedded
    private CoordinatesEntity coordinates;

}
