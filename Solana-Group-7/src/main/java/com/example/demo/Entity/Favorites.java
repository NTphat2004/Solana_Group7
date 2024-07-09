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
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Favorites")
public class Favorites {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Favorite_ID")
    private int favoriteId;

    @ManyToOne
    @JoinColumn(name = "User_ID", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "NFT_ID", nullable = false)
    private NFTs nft;

}
