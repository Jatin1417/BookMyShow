package com.CodeHacks.BookMyShow_Backend.Service;

import com.CodeHacks.BookMyShow_Backend.Dto.UserRequestDto;
import com.CodeHacks.BookMyShow_Backend.Models.UserEntity;
import com.CodeHacks.BookMyShow_Backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String CreateUser(UserRequestDto userRequestDto){
        UserEntity userEntity = UserEntity.builder().name(userRequestDto.getName()).mobile(userRequestDto.getMobile()).build();

        try{
            userRepository.save(userEntity);
        }catch(Exception e){
            System.out.println("User could not be added");
        }
       return "User Added Successfully";
    }

}
