package com.CodeHacks.BookMyShow_Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookTicketReqDto {

    List<String> bookedSeats;
    Date BookedAt;
    int UserId;
    int ShowId;


}
