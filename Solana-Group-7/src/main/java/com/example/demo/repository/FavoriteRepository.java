package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Favorites;
import com.example.demo.Entity.Users;

public interface FavoriteRepository extends JpaRepository<Favorites, Integer> {

}
