package com.example.academiacx.controller;

import com.example.academiacx.models.GenreModel;
import com.example.academiacx.repository.GenreRepository;
import com.example.academiacx.services.inter.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<GenreModel> findAll()
    {
        return genreService.listGenres();
    }

    @GetMapping(value = "/{id}")
    public Optional<GenreModel> findById(@PathVariable Long id)
    {
        return genreService.findById(id);
    }

    @PostMapping
    public GenreModel save(@RequestBody GenreModel genreModel)
    {
        return genreService.create(genreModel);
    }

    @PutMapping
    public GenreModel update(@RequestBody GenreModel genreModel)
    {
        return genreService.update(genreModel);
    }
}
