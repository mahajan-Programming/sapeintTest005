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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CompanyAddressEntity getAddress() {
        return address;
    }

    public void setAddress(CompanyAddressEntity address) {
        this.address = address;
    }
}
