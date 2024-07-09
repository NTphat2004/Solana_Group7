package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Advertisements;
import com.example.demo.Entity.Users;

public interface ADRepository extends JpaRepository<Advertisements, Integer> {

}
