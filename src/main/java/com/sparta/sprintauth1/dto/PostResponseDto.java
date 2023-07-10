package com.sparta.sprintauth1.dto;

import com.sparta.sprintauth1.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private Long id;
    private String username;
    private String contents;
    private String title;
    private String password;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.username = post.getUsername();
        this.contents = post.getContents();
        this.createAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.title = post.getTitle();
        this.password = post.getPassword();
    }

    public PostResponseDto(Long id, String username, String contents, String title, String password) {
        this.id = id;
        this.username = username;
        this.contents = contents;
        this.title = title;
        this.password = password;

    }
}