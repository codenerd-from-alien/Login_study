package com.sparta.sprintauth1.entity;


import com.sparta.sprintauth1.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "post")
@NoArgsConstructor
public class Post extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, length = 500)
    private String username;
    @Column(name = "contents", nullable = true, length = 500)
    private String contents;
    @Column(name = "title", nullable = true, length = 500)
    private String title;
    @Column(name = "pasword", nullable = false, length = 500)
    private String password;

    public Post(PostRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
    }

    public void update(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.password =requestDto.getPassword();
    }
}
