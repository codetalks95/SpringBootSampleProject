package com.bhushan.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String status;
    private String message;
    private Object object;
}
