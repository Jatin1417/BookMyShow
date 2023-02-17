package com.CodeHacks.BookMyShow_Backend.Service;

import com.CodeHacks.BookMyShow_Backend.Dto.TheaterReqDto;
import com.CodeHacks.BookMyShow_Backend.Enums.SeatType;
import com.CodeHacks.BookMyShow_Backend.Models.TheaterEntity;
import com.CodeHacks.BookMyShow_Backend.Models.TheaterSeatEntity;
import com.CodeHacks.BookMyShow_Backend.Repositories.TheaterRepository;
import com.CodeHacks.BookMyShow_Backend.Repositories.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    public String createTheater(TheaterReqDto theaterReqDto){
        TheaterEntity theater = TheaterEntity.builder().name(theaterReqDto.getName()).City(theaterReqDto.getCity()).address(theaterReqDto.getAddress()).build();


        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats();

        for(TheaterSeatEntity seatEntity: theaterSeatEntityList){
             seatEntity.setTheater(theater);
        }
        theater.setTheaterSeatEntityList(theaterSeatEntityList);
        theaterRepository.save(theater);
        return "Theater created successfully";
    }
    @Autowired
    TheaterSeatRepository theaterSeatRepository;
    public List<TheaterSeatEntity> createTheaterSeats(){

        List<TheaterSeatEntity> seats = new ArrayList<>();

        for(int i=0; i<10; i++){

            if(i<5) {
                char ch = (char) ('A' + i);
                String seatNo = "1" + ch;
                TheaterSeatEntity seat = new TheaterSeatEntity(seatNo, SeatType.CLASSIC, 100);
                seats.add(seat);
            }else{
            char ch = (char)('A'+(i-5));
            String seatNo = "2"+ch;
            TheaterSeatEntity seat = new TheaterSeatEntity(seatNo,SeatType.PLATINUM,200);
            seats.add(seat);
            }
        }


//        TheaterSeatEntity seat1 = new TheaterSeatEntity("1A", SeatType.CLASSIC,100);
//        TheaterSeatEntity seat2 = new TheaterSeatEntity("1B", SeatType.CLASSIC,100);
//        TheaterSeatEntity seat3 = new TheaterSeatEntity("1C", SeatType.CLASSIC,100);
//        TheaterSeatEntity seat4 = new TheaterSeatEntity("1D", SeatType.CLASSIC,100);
//        TheaterSeatEntity seat5 = new TheaterSeatEntity("1E", SeatType.CLASSIC,100);
//        TheaterSeatEntity seat6 = new TheaterSeatEntity("2A", SeatType.PLATINUM,200);
//        TheaterSeatEntity seat7 = new TheaterSeatEntity("2B", SeatType.PLATINUM,200);
//        TheaterSeatEntity seat8 = new TheaterSeatEntity("2C", SeatType.PLATINUM,200);
//        TheaterSeatEntity seat9 = new TheaterSeatEntity("2D", SeatType.PLATINUM,200);
//        TheaterSeatEntity seat10 = new TheaterSeatEntity("2E", SeatType.PLATINUM,200);
//
//        seats.add(seat1);
//        seats.add(seat2);
//        seats.add(seat3);
//        seats.add(seat4);
//        seats.add(seat5);
//        seats.add(seat6);
//        seats.add(seat7);
//        seats.add(seat8);
//        seats.add(seat9);
//        seats.add(seat10);

       theaterSeatRepository.saveAll(seats);
        return seats;
    }
    public String Update(TheaterReqDto theaterReqDto,int id){

        TheaterEntity theater = theaterRepository.findById(id).get();

        theater.setName(theaterReqDto.getName());
        theater.setCity(theaterReqDto.getCity());
        theater.setAddress(theaterReqDto.getAddress());

        List<TheaterSeatEntity> seats = theater.getTheaterSeatEntityList();
        for(TheaterSeatEntity seat:seats){
            seat.setTheater(theater);
        }
        theater.setTheaterSeatEntityList(seats);
        theaterRepository.save(theater);
        theaterSeatRepository.saveAll(seats);

        return "Theater updated successfully";
    }
}
