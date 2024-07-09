package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.NFTs;
import com.example.demo.Entity.Users;

public interface NftRepository extends JpaRepository<NFTs, Integer> {

}
