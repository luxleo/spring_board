package com.luxlog.api.service;

import com.luxlog.api.crypto.PasswordEncoder;
import com.luxlog.api.domain.User;
import com.luxlog.api.exception.AlreadySignedUpException;
import com.luxlog.api.repository.UserRepository;
import com.luxlog.api.request.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입 전에 이메일 중복 체크하고 진행한다.
     */
    public void signUp(SignUp signUp) {
        Optional<User> optionalUser = repository.findByEmail(signUp.getEmail());
        if (optionalUser.isPresent()) {
            throw new AlreadySignedUpException();
        }

        var user = User.builder()
                .name(signUp.getName())
                .password(passwordEncoder.encrypt(signUp.getPassword()))
                .email(signUp.getEmail())
                .build();
        repository.save(user);
    }
}
