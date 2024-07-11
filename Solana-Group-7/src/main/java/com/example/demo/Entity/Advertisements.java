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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@NotBlank(message = "Please Enter Title")
	@Column(name = "Ad_Title", nullable = false, length = 255)
	private String adTitle;
	
	@NotBlank(message = "Please Enter Description")
	@Column(name = "Ad_Description")
	private String adDescription;
	
	@NotNull(message = "Start date cannot be null")
	@Column(name = "Start_Date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@NotNull(message = "End date cannot be null")
	@Column(name = "End_Date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	@Column(name = "Ad_Image_URL", length = 1000)
	private String adImageUrl;

	@Column(name = "Status", length = 50)
	private String status = "Đang quảng cáo";

}
