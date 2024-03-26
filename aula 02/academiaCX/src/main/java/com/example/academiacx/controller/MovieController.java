package com.example.academiacx.controller;

import com.example.academiacx.models.GenreModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.repository.MovieRepository;

import com.example.academiacx.services.inter.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<MovieModel> findAll()
    {
        return movieService.listMovies();
    }

    @GetMapping(value = "/{id}")
    public Optional<MovieModel> findById(@PathVariable Long id)
    {
        return movieService.findById(id);
    }

    @PostMapping
    public MovieModel save(@RequestBody MovieModel movieModel)
    {
        return movieService.create(movieModel);
    }

    @PutMapping
    public MovieModel update(@RequestBody MovieModel movieModel)
    {
        return movieService.update(movieModel);
    }
}
