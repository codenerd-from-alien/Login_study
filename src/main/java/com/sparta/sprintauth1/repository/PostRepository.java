package com.sparta.sprintauth1.repository;

import com.sparta.sprintauth1.entity.Post;
import com.sparta.sprintauth1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


}
