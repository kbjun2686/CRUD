package com.sparta.copy.controller.dto.requestDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;
}
