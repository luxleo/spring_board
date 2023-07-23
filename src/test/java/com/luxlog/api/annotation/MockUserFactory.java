package com.luxlog.api.annotation;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

public class MockUserFactory implements WithSecurityContextFactory<CustomWithMockUser> {
//    private UserRepository userRepository;
//    @Override
//    public SecurityContext createSecurityContext(CustomWithMockUser annotation) {
//        User.builder()
//                        .password(annotation.password())
//        userRepository.save()
//    }

    @Override
    public SecurityContext createSecurityContext(CustomWithMockUser annotation) {
        return null;
    }
}
