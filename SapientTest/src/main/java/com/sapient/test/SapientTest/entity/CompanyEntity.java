package com.sapient.test.SapientTest.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class CompanyEntity {
    private String department;
    private String name;
    private String title;

    @Embedded
    private CompanyAddressEntity address;

}
