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
@Table(name = "Advertisements")
public class Advertisements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Ad_ID")
	private int adId;

	@ManyToOne
	@JoinColumn(name = "User_ID", nullable = false)
	private Users user;

	@Column(name = "Ad_Title", nullable = false, length = 255)
	private String adTitle;

	@Column(name = "Ad_Description")
	private String adDescription;

	@Column(name = "Start_Date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "End_Date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Column(name = "Ad_Image_URL", length = 1000)
	private String adImageUrl;

	@Column(name = "Status", length = 50)
	private String status;

}
