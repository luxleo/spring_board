package com.luxlog.api.controller;

import com.luxlog.api.config.AppConfig;
import com.luxlog.api.request.SignUp;
import com.luxlog.api.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    private final AppConfig appConfig;



    @PostMapping("/auth/sign-up")
    public void signUp(@RequestBody SignUp signUp) {
        service.signUp(signUp);
    }
}
