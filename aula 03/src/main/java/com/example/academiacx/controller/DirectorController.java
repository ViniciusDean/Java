package com.example.academiacx.controller;

import com.example.academiacx.models.DirectorModel;
import com.example.academiacx.models.DirectorModel;
import com.example.academiacx.models.DirectorModel;
import com.example.academiacx.services.inter.DirectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/director")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping(value = "/director/list")
    public ResponseEntity<List<DirectorModel>> findAll()
    {
        List<DirectorModel> response = directorService.list();

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "(/director/{id}")
    public ResponseEntity<Optional<DirectorModel>> findById(@PathVariable Long id)
    {
        Optional<DirectorModel> response = directorService.findById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/director/save")
    public ResponseEntity<DirectorModel> save(@RequestBody DirectorModel directorModel)
    {
        DirectorModel response = directorService.create(directorModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/director/update")
    public ResponseEntity<DirectorModel> update(@RequestBody DirectorModel directorModel)
    {
        DirectorModel response = directorService.update(directorModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }
    @DeleteMapping(value = "/director/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = directorService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}