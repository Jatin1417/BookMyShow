package com.CodeHacks.BookMyShow_Backend.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class MovieReqDto {
    String name;

    int duration;

    Date ReleaseDate;

}
