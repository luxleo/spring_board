package com.luxlog.api.controller;

import com.luxlog.api.config.UserPrincipal;
import com.luxlog.api.request.PostCreate;
import com.luxlog.api.request.PostEdit;
import com.luxlog.api.request.PostSearch;
import com.luxlog.api.response.PostResponse;
import com.luxlog.api.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    /**
     * 글 포스트 할때 받아준다(폼 데이터로 넘김)
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/posts")
    public String postArticle(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody @Valid PostCreate params) {

        log.info("params : {}", params.toString());
        params.validate();
        postService.write(userPrincipal.getUserId(),params);
        return "Hello World";
    }

    @GetMapping("/posts")
    public List<PostResponse> getList(@ModelAttribute PostSearch postSearch) {
        return postService.getList(postSearch);

    }

    @GetMapping("/posts/{postId}")
    public PostResponse getOne(@PathVariable Long postId) {
        return postService.get(postId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping("/posts/{postId}")
    public void edit(@PathVariable Long postId, @RequestBody @Valid PostEdit postEdit) {
        postService.edit(postId, postEdit);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.delete(postId);
    }
}
