package com.sapient.test.SapientTest.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class HairEntity {
    private String color;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
