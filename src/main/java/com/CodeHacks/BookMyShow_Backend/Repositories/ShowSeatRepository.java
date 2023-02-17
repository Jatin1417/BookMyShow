package com.CodeHacks.BookMyShow_Backend.Repositories;


import com.CodeHacks.BookMyShow_Backend.Models.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity,Integer> {
     ShowSeatEntity findBySeatNo(String no);

}
