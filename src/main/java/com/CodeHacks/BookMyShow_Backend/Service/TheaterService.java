package com.CodeHacks.BookMyShow_Backend.Service;

import com.CodeHacks.BookMyShow_Backend.Dto.TheaterReqDto;
import com.CodeHacks.BookMyShow_Backend.Models.TheaterEntity;
import com.CodeHacks.BookMyShow_Backend.Repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    public String createTheater(TheaterReqDto theaterReqDto){
        TheaterEntity theater = TheaterEntity.builder().name(theaterReqDto.getName()).City(theaterReqDto.getCity()).address(theaterReqDto.getAddress()).build();
        theaterRepository.save(theater);
        return "Theater created successfully";
    }
}
