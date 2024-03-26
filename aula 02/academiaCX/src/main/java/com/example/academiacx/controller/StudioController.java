package com.example.academiacx.controller;

import com.example.academiacx.models.StudioModel;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.services.inter.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/studio")
public class StudioController {

    @Autowired
    private StudioService studioService;

    @GetMapping
    public List<StudioModel> findAll(){ return studioService.listStudios();}

    @GetMapping(value = "/{id}")
    public Optional<StudioModel> findById(@PathVariable Long id)
    {
        return studioService.findById(id);
    }

    @PostMapping
    public StudioModel save(@RequestBody StudioModel studioModel)
    {
        return studioService.create(studioModel);
    }

    @PutMapping
    public StudioModel update(@RequestBody StudioModel studioModel)
    {
        return studioService.update(studioModel);
    }
}
