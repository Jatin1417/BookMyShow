package com.CodeHacks.BookMyShow_Backend.Repositories;

import com.CodeHacks.BookMyShow_Backend.Models.ShowEntity;
import com.CodeHacks.BookMyShow_Backend.Models.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
}
