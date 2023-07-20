package com.luxlog.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luxlog.api.repository.UserRepository;
import com.luxlog.api.request.SignUp;
import com.luxlog.api.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class AuthControllerTest {
    @Autowired
    AuthService service;
    @Autowired
    UserRepository repository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void beforeEach() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("회원가입 성공")
    void signUp() throws Exception {
        //given
        SignUp signUp = SignUp.builder()
                .email("test@gmail.com")
                .name("test")
                .password("1234")
                .build();

        //when
        mockMvc.perform(post("/auth/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signUp)))
                .andExpect(status().isOk())
                .andDo(print());

        //then
    }
}