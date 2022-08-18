package com.sparta.copy.controller;

import com.sparta.copy.controller.dto.ResponseDto;
import com.sparta.copy.controller.dto.requestDto.PostRequestDto;
import com.sparta.copy.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    // 게시물 작성
    @PostMapping("/post")
    public ResponseDto<?> createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }

    // 게시물 전체 조회
    @GetMapping("/post")
    public ResponseDto<?> getAllPost() {
        return postService.getAllPost();
    }

    // 게시물 상세 조회
    @GetMapping("/post/{id}")
    public ResponseDto<?> getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    // 게시물 수정
    @PutMapping("/post/{id}")
    public ResponseDto<?> updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.updatePost(id, postRequestDto);
    }

    // 게시물 삭제
    @DeleteMapping("/post/{id}")
    public ResponseDto<?> deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    // 게시물 비밀번호 확인
    @PostMapping("/post/{id}")
    public ResponseDto<?> validateAuthorByPassword(@PathVariable Long id, @RequestBody String password) {
        return postService.validateAuthorByPassword(id, password);
    }
}
