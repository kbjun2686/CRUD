package com.sparta.copy.service;

import com.sparta.copy.controller.dto.ResponseDto;
import com.sparta.copy.controller.dto.requestDto.PostRequestDto;
import com.sparta.copy.domain.Post;
import com.sparta.copy.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    // 게시물 작성
    @Transactional
    public ResponseDto<?> createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return ResponseDto.success(post);
    }
    // 게시물 전체 조회
    @Transactional
    public ResponseDto<?> getAllPost() {
        return ResponseDto.success(postRepository.findAllByOrderByModifiedAtDesc());
    }

    // 게시물 상세 조회
    public ResponseDto<?> getPost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "post id isn't exit");
        }
        return ResponseDto.success(optionalPost.get());
    }

    // 게시물 수정
    @Transactional
    public ResponseDto<?> updatePost(Long id, PostRequestDto postRequestDto) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "post id isn't exit");
        }

        Post post = optionalPost.get();
        post.update(postRequestDto);

        return ResponseDto.success(post);
    }

    // 게시물 삭제
    public ResponseDto<?> deletePost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "post id isn't exit");
        }
        Post post = optionalPost.get();
        postRepository.delete(post);
        return ResponseDto.success(true);
    }

    // 게시물 비밀번호 확인
    @Transactional
    public ResponseDto<?> validateAuthorByPassword(Long id, String password) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_FOUND", "post id is not exit");
        }

        Post post = optionalPost.get();

        if (post.getPassword().equals(password)) {
            return ResponseDto.fail("PASSWORD_NOT_CORRECT", "password is not correct");
        }
        return ResponseDto.success(true);
    }

}
