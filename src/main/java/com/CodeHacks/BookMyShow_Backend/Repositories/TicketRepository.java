package com.CodeHacks.BookMyShow_Backend.Repositories;

import com.CodeHacks.BookMyShow_Backend.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
