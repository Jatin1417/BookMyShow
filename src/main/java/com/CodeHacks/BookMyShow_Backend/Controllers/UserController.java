package com.CodeHacks.BookMyShow_Backend.Controllers;

import com.CodeHacks.BookMyShow_Backend.Dto.UserRequestDto;
import com.CodeHacks.BookMyShow_Backend.Repositories.UserRepository;
import com.CodeHacks.BookMyShow_Backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String AddUser(@RequestBody UserRequestDto user){
         return userService.CreateUser(user);
    }
}
