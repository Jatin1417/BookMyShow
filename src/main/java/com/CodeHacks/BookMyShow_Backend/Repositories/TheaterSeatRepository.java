package com.CodeHacks.BookMyShow_Backend.Repositories;

import com.CodeHacks.BookMyShow_Backend.Models.TheaterSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatRepository extends JpaRepository<TheaterSeatEntity,Integer> {
    TheaterSeatEntity findBySeatNo(String no);
}

