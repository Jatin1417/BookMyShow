package com.CodeHacks.BookMyShow_Backend.Service;

import com.CodeHacks.BookMyShow_Backend.Dto.ShowReqDto;
import com.CodeHacks.BookMyShow_Backend.Models.*;
import com.CodeHacks.BookMyShow_Backend.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;
    @Autowired
    private TheaterSeatRepository theaterSeatRepository;

    public String addShow(ShowReqDto showReqDto){


        MovieEntity movie = movieRepository.findByname(showReqDto.getMovieName());

        TheaterEntity theater = theaterRepository.findById(showReqDto.getTheaterid()).get();

        ShowEntity show = ShowEntity.builder().showDate(showReqDto.getShowDate()).showTime(showReqDto.getShowTime()).multiplier(showReqDto.getMultiplier()).build();

        show.setMovie(movie);
        show.setTheater(theater);

        List<ShowSeatEntity> showseats = createShowSeats(theater.getTheaterSeatEntityList());

        show.setShowSeatEntityList(showseats);



        for(ShowSeatEntity showSeat: showseats){
            showSeat.setShow(show);
        }

        movie.getShowEntityList().add(show);
        theater.getListOfShows().add(show);

        movieRepository.save(movie); //movie is the parent, save movie is called so no need to call save show.
        theaterRepository.save(theater);
        return "show created successfully";
    }
    public List<ShowSeatEntity> createShowSeats(List<TheaterSeatEntity> theaterSeatEntityList){
        List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();
        for(TheaterSeatEntity seatEntity:theaterSeatEntityList){
            ShowSeatEntity showSeat = ShowSeatEntity.builder().seatNo(seatEntity.getSeatNo()).seatType(seatEntity.getSeatType()). build();
            showSeatEntityList.add(showSeat);
        }
       showSeatRepository.saveAll(showSeatEntityList);
        return showSeatEntityList;
    }
}

