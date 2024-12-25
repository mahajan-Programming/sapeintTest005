package com.sapient.test.SapientTest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CompanyCoordinatesEntity {
    @Column(name = "company_lat")
    private double lat;
    @Column(name = "company_lng")
    private double lng;
}
