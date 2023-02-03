package com.CodeHacks.BookMyShow_Backend.Repositories;

import com.CodeHacks.BookMyShow_Backend.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer>{
}
