package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.NFTs;
import com.example.demo.Entity.Users;

public interface NftRepository extends JpaRepository<NFTs, Integer> {
	   @Query(value = "SELECT TOP 2 * FROM NFTs ORDER BY Price DESC", nativeQuery = true)
	    List<NFTs> findTop2ByPrice();
	   
	   @Query("SELECT n FROM NFTs  n where n.nftId = ?1")
	   NFTs findbynftId(Integer id);
	   
	   @Query("SELECT n FROM NFTs  n where n.nftAddress = ?1")
	   NFTs findbyadress(String id);
}
