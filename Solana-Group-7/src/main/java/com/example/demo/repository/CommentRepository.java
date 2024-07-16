package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Comments;
import com.example.demo.Entity.Users;

public interface CommentRepository extends JpaRepository<Comments, Integer> {
	
	@Query("SELECT cm FROM Comments cm where cm.nft.nftId  = ?1")
	List<Comments> findCommentsByNFTs(Integer nftid);
	
	@Query("SELECT COUNT(n) FROM Comments n WHERE n.nft.nftId = :id")
    Integer countByIdNft(Integer id);
}
