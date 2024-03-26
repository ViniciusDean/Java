package com.example.academiacx.controller;

import com.example.academiacx.models.DirectorModel;
import com.example.academiacx.services.inter.DirectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/director")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping
    public List<DirectorModel> findAll(){ return directorService.listDirectors();}

    @GetMapping(value = "/{id}")
    public Optional<DirectorModel> findById(@PathVariable Long id)
    {
        return directorService.findById(id);
    }

    @PostMapping
    public DirectorModel save(@RequestBody DirectorModel directorModel)
    {
        return directorService.create(directorModel);
    }

    @PutMapping
    public DirectorModel update(@RequestBody DirectorModel directorModel)
    {
        return directorService.update(directorModel);
    }
}