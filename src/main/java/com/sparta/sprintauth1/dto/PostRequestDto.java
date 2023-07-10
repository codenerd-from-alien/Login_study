package com.sparta.sprintauth1.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostRequestDto {
    private String username;
    private String contents;
    private String title;
    private String password;
}
