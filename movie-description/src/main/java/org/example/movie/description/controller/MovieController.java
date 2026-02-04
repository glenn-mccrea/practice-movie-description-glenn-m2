package org.example.movie.description.controller;


import org.example.movie.description.model.Movie;
import org.example.movie.description.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @GetMapping
    public List<Movie> getAllItems() {
        return movieRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Movie> getItem(@PathVariable int id) {
        return movieRepository.findById(id);
    }
    @PostMapping
    public Movie addItem(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        movieRepository.deleteById(id);
    }
}