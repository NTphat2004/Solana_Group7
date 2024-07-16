package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID")
	private int userId;
	
	
	@Column(name = "Username", nullable = false, length = 50)
	@NotBlank(message = "Please enter UserName")
	private String username;
<<<<<<< HEAD
	
	
=======

>>>>>>> branch 'main' of https://github.com/NTphat2004/Solana_Group7.git
	@Column(name = "Email", nullable = false, length = 100)
	private String email;
	
	@NotBlank(message = "Please enter PassWord")
	@Column(name = "Password", nullable = false, length = 255)
	private String password;
	
	@Column(name = "Fullname", nullable = false, length = 255)
	private String fullname;

	@Column(name = "Wallet_Address", length = 255)
	private String walletAddress;

	@Column(name = "Role", length = 50)
	private String role = "User";
}
