package com.CodeHacks.BookMyShow_Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowReqDto {
    LocalDate showDate;
    LocalTime showTime;
    String MovieName;
    int Theaterid;
    double multiplier;

}
