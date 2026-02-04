//package com.example.springBoot2.controllers;
//
//import com.example.springBoot2.models.Movie;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/movies")
//public class MovieController {
//    private final List<Movie> movies = List.of(
//        new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 142),
//        new Movie("The Godfather", "Francis Ford Coppola", 1972, 175),
//        new Movie("The Dark Knight", "Christopher Nolan", 2008, 152)
//    );
//
//    @GetMapping
//    public List<Movie> getMovies() {
//        return movies;
//    }
//}

package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Album;
import com.example.springBoot2.models.Movie;
import com.example.springBoot2.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //1
    @GetMapping("")
    public List<Movie> getAllItems() {
        return movieRepository.findAll();
    }
    //2
    @GetMapping("/{id}")
    public Movie getItem(@PathVariable int id) {
        return movieRepository.findById(id).orElse(null);
    }
    //3
    @PostMapping("")
    public Movie addItem(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
    //4
    @PutMapping("/{id}")
    public Movie updateItem(@PathVariable int id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }
    //5
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        movieRepository.deleteById(id);
    }


}