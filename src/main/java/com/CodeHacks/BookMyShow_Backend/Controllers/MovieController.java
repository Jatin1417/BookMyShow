package com.CodeHacks.BookMyShow_Backend.Controllers;

import com.CodeHacks.BookMyShow_Backend.Dto.MovieReqDto;
import com.CodeHacks.BookMyShow_Backend.Repositories.MovieRepository;
import com.CodeHacks.BookMyShow_Backend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public String AddMovie(@RequestBody MovieReqDto movieReqDto){
            return movieService.CreateMovie(movieReqDto);
    }
}
