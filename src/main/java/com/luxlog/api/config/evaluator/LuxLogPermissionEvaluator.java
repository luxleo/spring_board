package com.luxlog.api.config.evaluator;

import com.luxlog.api.config.UserPrincipal;
import com.luxlog.api.domain.Post;
import com.luxlog.api.exception.PostNotFoundException;
import com.luxlog.api.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

@RequiredArgsConstructor
public class LuxLogPermissionEvaluator implements PermissionEvaluator {
    private final PostRepository postRepository;
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return false;
    }
    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        var principal = (UserPrincipal) authentication.getPrincipal();
        Post post = postRepository.findById((Long) targetId)
                .orElseThrow(PostNotFoundException::new);
        if (!post.getUserId().equals(principal.getUserId())) {
            return false;
        }
        return true;
    }
}
