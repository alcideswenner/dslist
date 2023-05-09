package com.alcideswenner.dslist.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(name = "year_game")
    private Integer year;

    @Column
    private String genre;

    @Column
    private String imgUrl;

    @Column
    private String shortDescription;

    @Column
    private String longDescription;

    @Column
    private String platform;
}