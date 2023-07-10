package com.sparta.sprintauth1.controller;

import com.sparta.sprintauth1.dto.PostRequestDto;
import com.sparta.sprintauth1.dto.PostResponseDto;
import com.sparta.sprintauth1.jwt.JwtUtil;
import com.sparta.sprintauth1.service.PostService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    public PostController( PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public List<PostResponseDto> getAllPost(){
        return postService.getAllPost();
    }
    //상세 조회
    @GetMapping("/{id}")
    public PostResponseDto getData(@PathVariable Long id){
        return postService.getData(id);
    }

    @DeleteMapping("/{id}") //선택한 목록 삭제
    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto,@CookieValue(JwtUtil.AUTHORIZATION_HEADER) String tokenValue){
        return postService.deletePost(id, requestDto.getPassword(),tokenValue);
    }

    @PutMapping("/{id}") //게시글 수정
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto,@CookieValue(JwtUtil.AUTHORIZATION_HEADER) String tokenValue ){
        return postService.updateMemo(id, requestDto,tokenValue);
    }

    @PostMapping("")//게시글 작성
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto,@CookieValue(JwtUtil.AUTHORIZATION_HEADER) String tokenValue){
        return postService.createPost(requestDto,tokenValue);// 클라이언트로 보내기
    }
}
