package com.example.academiacx.controller;

import com.example.academiacx.models.GenreModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.StudioModel;
import com.example.academiacx.repository.MovieRepository;

import com.example.academiacx.services.inter.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping(value = "(/movie/list")
    public ResponseEntity<List<MovieModel>> findAll()
    {
        List<MovieModel> response = movieService.list();

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/movie/{id}")
    public ResponseEntity<Optional<MovieModel>> findById(@PathVariable Long id)
    {
        Optional<MovieModel> response = movieService.findById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/movie/save")
    public ResponseEntity<MovieModel> save(@RequestBody MovieModel movieModel)
    {
        MovieModel response = movieService.create(movieModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/movie/update")
    public ResponseEntity<MovieModel> update(@RequestBody MovieModel movieModel)
    {
        MovieModel response = movieService.update(movieModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/movie/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = movieService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
