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
@Table(name = "Transaction_Details")
public class Transaction_Details {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Detail_ID")
    private int detailId;

    @ManyToOne
    @JoinColumn(name = "Transaction_ID", nullable = false)
    private Transactions transaction;

    @Column(name = "Blockchain", length = 50)
    private String blockchain;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "Timestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

}
