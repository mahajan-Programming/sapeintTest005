package com.sapient.test.SapientTest.service;
import com.sapient.test.SapientTest.dto.User;
import com.sapient.test.SapientTest.dto.UserResponse;
import com.sapient.test.SapientTest.entity.UserEntity;
import com.sapient.test.SapientTest.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository repository;

    private final RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserResponse fetchUserData() {
        String url = "https://dummyjson.com/users";
        UserResponse users = restTemplate.getForObject(url, UserResponse.class);
        log.info(users.toString());

        saveDataToDb(users);
        return users;
    }

    private void saveDataToDb(UserResponse users) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setAge(users.getUsers().get(0).getAge());
//        System.out.println(userEntity.getAge());
        List<User> userList = users.getUsers();
        List<UserEntity> userToSave = new ArrayList<>();
        for(User user : users.getUsers()) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(user.getId());
            userEntity.setFirstName(user.getFirstName());
            userEntity.setLastName(user.getLastName());
            userEntity.setMaidenName(user.getMaidenName());
            userEntity.setAge(user.getAge());
            userEntity.setGender(user.getGender());
            userEntity.setEmail(user.getEmail());
            userEntity.setPhone(user.getPhone());
            userEntity.setUsername(user.getUsername());
            userEntity.setPassword(user.getPassword());
            userEntity.setBirthDate(user.getBirthDate());
            userEntity.setImage(user.getImage());
            userEntity.setBloodGroup(user.getBloodGroup());
            userEntity.setHeight(user.getHeight());
            userEntity.setWeight(user.getWeight());
            userEntity.setEyeColor(user.getEyeColor());
            userEntity.setIp(user.getIp());

            repository.save(userEntity);
        }
    }
}
