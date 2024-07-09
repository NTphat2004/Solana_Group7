package com.example.demo.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Transactions")
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Transaction_ID")
	private int transactionId;

	@ManyToOne
	@JoinColumn(name = "NFT_ID", nullable = false)
	private NFTs nft;

	@ManyToOne
	@JoinColumn(name = "Seller_ID", nullable = false)
	private Users seller;

	@ManyToOne
	@JoinColumn(name = "Buyer_ID", nullable = false)
	private Users buyer;

	@Column(name = "Transaction_Date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;

	@Column(name = "Transaction_Value", nullable = false)
	private double transactionValue;

	@Column(name = "Payment_Method", length = 50)
	private String paymentMethod;

}
