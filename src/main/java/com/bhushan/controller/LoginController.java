package com.bhushan.controller;

import com.bhushan.entity.LoginEntity;
import com.bhushan.response.LoginResponse;
import com.bhushan.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("saveLogin")
    public LoginResponse saveData(@RequestBody LoginEntity loginEntity) {
        return loginService.login(loginEntity);
    }

    @PostMapping("updateLogin/{id}")
    public LoginResponse updateLogin(@PathVariable Integer id, @RequestBody Map<String, Object> loginEntity) {
        return loginService.changePassword(id, loginEntity);
    }
}
