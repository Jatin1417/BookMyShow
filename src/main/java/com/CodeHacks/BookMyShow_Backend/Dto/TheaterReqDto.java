package com.CodeHacks.BookMyShow_Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterReqDto {
    String name;
    String city;
    String address;
}
