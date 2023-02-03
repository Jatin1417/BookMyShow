package com.CodeHacks.BookMyShow_Backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Theater")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String City;

    private String address;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<TheaterSeatEntity> theaterSeatEntityList;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<ShowEntity> ListOfShows;

}
