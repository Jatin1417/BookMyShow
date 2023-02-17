package com.CodeHacks.BookMyShow_Backend.Models;

import com.CodeHacks.BookMyShow_Backend.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Theater_Seats")
public class TheaterSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String SeatNo;

   @Enumerated(value = EnumType.STRING)
   private SeatType seatType;

   private int rate;

   @ManyToOne
   @JoinColumn
   private TheaterEntity theater;

    public TheaterSeatEntity(String seatNo,SeatType seatType, int rate){
        this.SeatNo = seatNo;
        this.seatType = seatType;
        this.rate = rate;
    }
}
