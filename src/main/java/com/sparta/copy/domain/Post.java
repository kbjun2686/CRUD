package com.sparta.copy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.copy.controller.dto.requestDto.PostRequestDto;
import com.sparta.copy.repository.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    // columnDefinition : 원하는 컬럼 타입으로 데이터 추출이 가능
    // "TEXT" : 컬럼을 text 로 설정하여 데이터를 추출하는 내용
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String author;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    public Post(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.author = postRequestDto.getAuthor();
        this.password = postRequestDto.getPassword();
    }

    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.author = postRequestDto.getAuthor();
        this.password = postRequestDto.getPassword();
    }
}
