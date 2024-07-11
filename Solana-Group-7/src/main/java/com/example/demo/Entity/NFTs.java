package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "NFTs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NFTs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NFT_ID")
	private int nftId;

	

	@Column(name = "Name", nullable = false, length = 255)
	private String name;

	@Column(name = "Description")
	private String description;

	@Column(name = "Image_URL", length = 1000)
	private String imageUrl;

	@Column(name = "Price", nullable = false)
	private double price;

	@ManyToOne
	@JoinColumn(name = "Owner_ID", nullable = false)
	private Users owner;

	@Column(name = "Smart_Contract_Address", length = 255)
	private String smartContractAddress;
	
	 @Column(name = "NFT_Address",nullable = false, length = 255)
	    private String nftAddress;

}
