package com.sapient.test.SapientTest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class CompanyAddressEntity {
    @Column(name = "company_address")
    private String address;
    @Column(name = "company_city")
    private String city;
    @Column(name = "company_state")
    private String state;
    @Column(name = "company_stateCode")
    private String stateCode;
    @Column(name = "company_postalCode")
    private String postalCode;
    @Column(name = "company_country")
    private String country;

    @Embedded
    private CompanyCoordinatesEntity coordinates;
}
