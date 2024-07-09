package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Transactions;
import com.example.demo.Entity.Users;

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {

}
