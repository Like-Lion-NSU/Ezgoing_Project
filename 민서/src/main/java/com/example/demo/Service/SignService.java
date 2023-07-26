package com.example.demo.Service;

import com.example.demo.Dto.SignUpResultDto;
import com.example.demo.Dto.SignInResultDto;
import org.springframework.stereotype.Service;

public interface SignService {

    SignUpResultDto signUp(String id, String password, String name, String role, String phoneNum, String email, String birthDay);

    SignInResultDto signIn(String id, String password) throws RuntimeException;
}
