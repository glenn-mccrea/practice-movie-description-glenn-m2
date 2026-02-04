package org.example.movie.description.controller;

import org.apache.http.HttpException;
import org.example.movie.description.MovieDescriptionService;
import org.example.movie.description.model.Movie;
import org.example.movie.description.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;
    private MovieDescriptionService descriptionService;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        this.descriptionService = new MovieDescriptionService();
    }
    @GetMapping
    public List<Movie> getAllItems() {
        return movieRepository.findAll();
    }

    @PostMapping
    public Movie addItem(@RequestBody Movie movie) throws HttpException, IOException {
        String generatedDescription = descriptionService.generateDescription(movie.getTitle());
        movie.setDescription(generatedDescription);
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        movieRepository.deleteById(id);
    }
}