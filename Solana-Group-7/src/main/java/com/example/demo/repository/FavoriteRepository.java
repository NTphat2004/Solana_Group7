package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Favorites;
import com.example.demo.Entity.Users;

public interface FavoriteRepository extends JpaRepository<Favorites, Integer> {

	@Query("SELECT n FROM Favorites n where n.user.userId = ?1")
	List<Favorites> findallbyuser(Integer iduser);
	
}
