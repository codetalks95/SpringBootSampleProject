package com.bhushan.services;

import com.bhushan.entity.LoginEntity;
import com.bhushan.repository.LoginRepository;
import com.bhushan.response.LoginResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LoginResponse login(LoginEntity loginEntity) {
        LoginResponse loginResponse = new LoginResponse();
        loginEntity.setUserName(loginEntity.getUserName());
        loginEntity.setPassword(loginEntity.getPassword());
        loginEntity.setPasswordGenerationDate(System.currentTimeMillis());
        if (checkDateExpiry(System.currentTimeMillis())) {
            LoginEntity loginEntity1 = loginRepository.save(loginEntity);
            loginResponse.setObject(loginEntity1);
            loginResponse.setStatus("200");
            loginResponse.setMessage("The Login Credentials has been Generated");
        } else {
            loginResponse.setStatus("500");
            loginResponse.setMessage("The Login Credentials has been not been generated");
        }
        return loginResponse;
    }

    public LoginResponse changePassword(Integer id, Map<String, Object> map) {
        LoginResponse loginResponse = new LoginResponse();
        Optional<LoginEntity> loginEntity = loginRepository.findById(id);
        if (loginEntity.isPresent() && checkDateExpiry(System.currentTimeMillis())) {
            map.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(LoginEntity.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, loginEntity.get(), value);
            });
            loginResponse.setObject(loginEntity.get());
            loginResponse.setStatus("200");
            loginResponse.setMessage("The Login Credentials has been Updated");
        } else {
            loginResponse.setStatus("500");
            loginResponse.setMessage("The Login Credentials has been expired");
        }
        return loginResponse;
    }

    public LoginResponse expirePassword(LoginEntity loginEntity) {
        LoginResponse loginResponse = new LoginResponse();
        if (checkDateExpiry(loginEntity.getPasswordGenerationDate())) {
            loginResponse.setMessage("The Login has Expired");
            loginResponse.setStatus("500");
        }
        return loginResponse;
    }

    public static boolean checkDateExpiry(Long existingDate) {
        long epochCurrentTime = System.currentTimeMillis() + 24 * 60 * 60 * 1000;
        return epochCurrentTime > existingDate;
    }
}
