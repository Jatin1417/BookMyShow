package com.CodeHacks.BookMyShow_Backend.Repositories;

import com.CodeHacks.BookMyShow_Backend.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
