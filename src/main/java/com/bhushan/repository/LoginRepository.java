package com.bhushan.repository;

import com.bhushan.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoginRepository extends JpaRepository<LoginEntity,Integer> {

    @Query(value = "SELECT * FROM login_credentials WHERE user_name = ?1", nativeQuery = true)
    List<LoginEntity> uniqueUserName(String userName);
}
