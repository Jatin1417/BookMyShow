package com.CodeHacks.BookMyShow_Backend.Controllers;

import com.CodeHacks.BookMyShow_Backend.Dto.ShowReqDto;
import com.CodeHacks.BookMyShow_Backend.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping
    public String addShow(ShowReqDto showReqDto){
        return showService.addShow(showReqDto);
    }
}
