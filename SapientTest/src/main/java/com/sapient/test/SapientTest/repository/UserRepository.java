package com.sapient.test.SapientTest.repository;

import com.sapient.test.SapientTest.dto.User;
import com.sapient.test.SapientTest.dto.UserResponse;
import com.sapient.test.SapientTest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(nativeQuery = true,value = "SELECT * from users where role=:role")
    List<UserEntity> findAllByRole(@Param("role") String role);

    List<UserEntity> findAllBySsn(String ssn);
}
