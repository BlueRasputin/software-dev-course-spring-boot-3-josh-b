package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Movie;
import com.example.springBoot2.Repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Movie> getMovie(@PathVariable int id) {
        return movieRepository.findById(id);
    }
    @PostMapping("/add")
    public Movie addItem(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
    @PutMapping("/{id}")
    public Movie updateItem(@PathVariable int id, @RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        movieRepository.deleteById(id);
    }
}
