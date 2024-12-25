package com.sapient.test.SapientTest.controller;

import com.sapient.test.SapientTest.dto.User;
import com.sapient.test.SapientTest.dto.UserResponse;
import com.sapient.test.SapientTest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
@CrossOrigin
@Slf4j
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Health running ....";
    }

    @GetMapping("/loadUserData")
    public UserResponse fetchUserData() {
        try {
            UserResponse users = userService.fetchUserData();
            if(Objects.nonNull(users))
                return users;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
