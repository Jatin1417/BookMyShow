package com.CodeHacks.BookMyShow_Backend.Service;

import com.CodeHacks.BookMyShow_Backend.Dto.BookTicketReqDto;
import com.CodeHacks.BookMyShow_Backend.Models.ShowEntity;
import com.CodeHacks.BookMyShow_Backend.Models.ShowSeatEntity;
import com.CodeHacks.BookMyShow_Backend.Models.TicketEntity;
import com.CodeHacks.BookMyShow_Backend.Models.UserEntity;
import com.CodeHacks.BookMyShow_Backend.Repositories.ShowRepository;
import com.CodeHacks.BookMyShow_Backend.Repositories.ShowSeatRepository;
import com.CodeHacks.BookMyShow_Backend.Repositories.TheaterSeatRepository;
import com.CodeHacks.BookMyShow_Backend.Repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TicketService {

    @Autowired
    ShowSeatRepository showSeatRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    public String Createticket(BookTicketReqDto bookTicketReqDto){
        int amount=0;
        UserEntity user = userRepository.findById(bookTicketReqDto.getUserId()).get();
        ShowEntity show = showRepository.findById(bookTicketReqDto.getShowId()).get();
        List<String> SeatNos = bookTicketReqDto.getBookedSeats();
        List<ShowSeatEntity> showSeats = new ArrayList<>();
        for(String SeatNo: SeatNos) {
            showSeats.add(showSeatRepository.findBySeatNo(SeatNo));
        }
        for(ShowSeatEntity showSeat: showSeats){
            if(showSeat.getBooked()!=true){
                showSeat.setBooked(true);
                showSeat.setBookedAt(bookTicketReqDto.getBookedAt());
                amount += (theaterSeatRepository.findBySeatNo(showSeat.getSeatNo()).getRate())*(show.getMultiplier());
            }
            else{
                return "Cannot book this seat, It's Already Booked"+showSeat.getSeatNo();
            }
        }
        TicketEntity ticket = TicketEntity.builder().amount(amount).booked_at(bookTicketReqDto.getBookedAt()).BookesSeats(showSeats).build();
        ticket.setShow(show);
        ticket.setUser(user);

        show.getTicketEntityList().add(ticket);
        showRepository.save(show);

        return "Ticket Booked Successfully";

    }
}
