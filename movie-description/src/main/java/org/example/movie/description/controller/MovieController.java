package org.example.movie.description.controller;

import org.apache.http.HttpException;
import org.example.movie.description.model.Movie;
import org.example.movie.description.model.MovieInfo;
import org.example.movie.description.repositories.MovieRepository;
import org.example.movie.description.service.MovieInfoService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;
 private final MovieInfoService movieInfoService;


    public MovieController(MovieRepository movieRepository, MovieInfoService movieInfoService) {
        this.movieRepository = movieRepository;
        this.movieInfoService = new MovieInfoService();
    }

    @GetMapping
    public List<Movie> getAllItems() {
        return movieRepository.findAll();
    }

    @PostMapping

        public Movie addItem(@RequestBody Movie movie) throws HttpException, IOException {

            MovieInfo movieInfo = movieInfoService.getMovieInfo(movie.getTitle());

           movie.setDescription(movieInfo.getDescription());
            movie.setDirector(movieInfo.getDirector());

        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        movieRepository.deleteById(id);
    }
}