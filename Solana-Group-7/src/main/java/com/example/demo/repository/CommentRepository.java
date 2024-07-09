package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Comments;
import com.example.demo.Entity.Users;

public interface CommentRepository extends JpaRepository<Comments, Integer> {

}
