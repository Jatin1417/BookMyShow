package com.CodeHacks.BookMyShow_Backend.Controllers;

import com.CodeHacks.BookMyShow_Backend.Dto.TheaterReqDto;
import com.CodeHacks.BookMyShow_Backend.Repositories.TheaterRepository;
import com.CodeHacks.BookMyShow_Backend.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;
    @Autowired
    private TheaterRepository theaterRepository;

    @PostMapping("/add")
    public String addTheater(@RequestBody TheaterReqDto theaterReqDto){
        return theaterService.createTheater(theaterReqDto);
    }
    @PutMapping("/update")
    public String UpdateTheater(@RequestBody TheaterReqDto theaterReqDto, @RequestParam int id){
        return theaterService.Update(theaterReqDto,id);
    }
}
