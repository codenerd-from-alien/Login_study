package com.sparta.sprintauth1.service;

import com.sparta.sprintauth1.dto.PostRequestDto;
import com.sparta.sprintauth1.dto.PostResponseDto;
import com.sparta.sprintauth1.entity.Post;
import com.sparta.sprintauth1.jwt.JwtUtil;
import com.sparta.sprintauth1.repository.PostRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final JwtUtil jwtUtil;

    public PostService(PostRepository postRepository, JwtUtil jwtUtil) {
        this.postRepository = postRepository;
        this.jwtUtil = jwtUtil;
    }


    public PostResponseDto createPost(PostRequestDto requestDto, String tokenValue) {
        Post post = new Post(requestDto);
        String token = jwtUtil.substringToken(tokenValue);
        if(!jwtUtil.validateToken(token)){
            throw new IllegalArgumentException("Token Error");
        }else{
            postRepository.save(post);
            PostResponseDto postResponseDto = new PostResponseDto(post);
            return postResponseDto;
        }
        //Post savePost =  postRepository.save(post);//postrepository에 디비를 저장할 수 있는 함수 호출을 해서 전달...
        //postrepository에 디비를 저장할 수 있는 함수 호출을 해서 전달...
        // Entity -> ResponseDto

    }

    public List<PostResponseDto> getAllPost() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")).stream().map(PostResponseDto::new).toList();
    }

    @Transactional
    public Long updateMemo(Long id, PostRequestDto requestDto, String tokenValue) {
        Post post = findPost(id);
        String token = jwtUtil.substringToken(tokenValue);
        if(!jwtUtil.validateToken(token)){
            throw new IllegalArgumentException("Token Error");
        }else {
            post.update(requestDto);
        }

        return id;
    }

    public Long deletePost(Long id, String password, String tokenValue) {
        String token = jwtUtil.substringToken(tokenValue);
        Post post = findPost(id);
        if(!jwtUtil.validateToken(token)){
            throw new IllegalArgumentException("Token Error");
        }else{
            postRepository.delete(post);
        }
        return id;
    }
    @Transactional(readOnly = true)
    public PostResponseDto getData(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("해당ID의 게시글이 없습니다."));
        return new PostResponseDto(post);
    }


    public Post findPost(Long id){
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 포스트는 존재 안함")
        );
    }
}
