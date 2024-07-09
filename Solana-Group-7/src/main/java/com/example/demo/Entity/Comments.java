package com.example.demo.Entity;

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
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Comments")
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Comment_ID")
	private int commentId;

	@ManyToOne
	@JoinColumn(name = "NFT_ID", nullable = false)
	private NFTs nft;

	@ManyToOne
	@JoinColumn(name = "User_ID", nullable = false)
	private Users user;

	@Column(name = "Comment_Content")
	private String commentContent;

	@Column(name = "Comment_Date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date commentDate;

}
