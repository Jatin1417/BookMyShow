package com.CodeHacks.BookMyShow_Backend.Service;

import com.CodeHacks.BookMyShow_Backend.Dto.MovieReqDto;
import com.CodeHacks.BookMyShow_Backend.Models.MovieEntity;
import com.CodeHacks.BookMyShow_Backend.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public String CreateMovie(MovieReqDto movieReqDto){
        MovieEntity movie = MovieEntity.builder().name(movieReqDto.getName()).duration(movieReqDto.getDuration()).Releasedate(movieReqDto.getReleaseDate()).build();

        try{
            movieRepository.save(movie);
        }catch(Exception e){
            System.out.print("Movie Could not be added");
        }

        return "Movie added successfully";
    }
}
