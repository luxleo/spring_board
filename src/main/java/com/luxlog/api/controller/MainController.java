package com.luxlog.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String main() {
        return "메인 페이지 이올시다";
    }

    @GetMapping("/user")
    public String userMain() {
        return "사용자 페이지 이올시다";
    }
    @GetMapping("/admin")
    public String adminMain() {
        return "관리자 페이지 이올시다";
    }
}
