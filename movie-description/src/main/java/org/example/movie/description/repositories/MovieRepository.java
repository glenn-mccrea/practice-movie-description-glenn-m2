package org.example.movie.description.repositories;

import org.example.movie.description.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Integer>{}
