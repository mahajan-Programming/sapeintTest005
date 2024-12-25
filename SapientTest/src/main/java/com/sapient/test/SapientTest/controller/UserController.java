package com.sapient.test.SapientTest.controller;

import com.sapient.test.SapientTest.dto.User;
import com.sapient.test.SapientTest.dto.UserResponse;
import com.sapient.test.SapientTest.entity.UserEntity;
import com.sapient.test.SapientTest.service.UserService;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Health running ....";
    }

    @GetMapping("/loadUserData")
    public ResponseEntity<UserResponse> fetchUserData() {
        try {
            UserResponse users = userService.fetchUserData();
            if(Objects.nonNull(users))
                return ResponseEntity.ok(users);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.internalServerError().body(null);
    }

    @GetMapping("/getUsersByRole/{role}")
    public ResponseEntity<UserResponse> fetchUserByRole(@PathVariable("role") String role) {
        if(!StringUtils.isBlank(role)) {
            try {
                UserResponse users = userService.fetchUserByRole(role);
                if(Objects.nonNull(users))
                    return ResponseEntity.ok(users);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return ResponseEntity.internalServerError().body(null);
    }

    @GetMapping("/getUsersBySSN/{ssn}")
    public ResponseEntity<UserResponse> fetchUserBySSN(@PathVariable("ssn") String ssn) {
        if(!StringUtils.isBlank(ssn)) {
            try {
                UserResponse users = userService.fetchUserBySSN(ssn);
                if(Objects.nonNull(users))
                    return ResponseEntity.ok(users);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return ResponseEntity.internalServerError().body(null);
    }

    @GetMapping("/getSortedUsersByAge/{order}")
    public ResponseEntity<UserResponse> fetchSortedUsers(@PathVariable("order") String order) {
        if(!StringUtils.isBlank(order)) {
            try {
                UserResponse users = userService.fetchSortedUsers(order);
                if(Objects.nonNull(users))
                    return ResponseEntity.ok(users);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return ResponseEntity.internalServerError().body(null);
    }
}
