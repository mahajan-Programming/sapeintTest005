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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CompanyCoordinatesEntity getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CompanyCoordinatesEntity coordinates) {
        this.coordinates = coordinates;
    }
}
