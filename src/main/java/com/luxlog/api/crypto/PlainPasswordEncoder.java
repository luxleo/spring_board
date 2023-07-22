package com.luxlog.api.crypto;

//@Profile("test")
//@Component
public class PlainPasswordEncoder implements PasswordEncoder{
    @Override
    public String encrypt(String rawPassword) {
        return rawPassword;
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }

}
