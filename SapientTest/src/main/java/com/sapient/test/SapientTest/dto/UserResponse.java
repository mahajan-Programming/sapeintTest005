package com.sapient.test.SapientTest.dto;

import lombok.*;

import java.util.List;

public class UserResponse {
    public List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserResponse() {
    }

    public UserResponse(List<User> users) {
        this.users = users;
    }
}
