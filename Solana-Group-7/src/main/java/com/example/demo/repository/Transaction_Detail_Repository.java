package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Transaction_Details;
import com.example.demo.Entity.Users;

public interface Transaction_Detail_Repository extends JpaRepository<Transaction_Details, Integer> {

}
