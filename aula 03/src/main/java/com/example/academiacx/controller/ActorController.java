package com.example.academiacx.controller;

import com.example.academiacx.models.ActorModel;
import com.example.academiacx.models.ActorModel;
import com.example.academiacx.repository.ActorRepository;
import com.example.academiacx.services.inter.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/actor")
public class ActorController {
    @Autowired
    private ActorService actorService;


    @GetMapping(value = "/actor/list")
    public ResponseEntity<List<ActorModel>> findAll()
    {
        List<ActorModel> response = actorService.list();

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/actor/{id}")
    public ResponseEntity<Optional<ActorModel>> findById(@PathVariable Long id)
    {
        Optional<ActorModel> response = actorService.findById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/actor/save")
    public ResponseEntity<ActorModel> save(@RequestBody ActorModel actorModel)
    {
        ActorModel response = actorService.create(actorModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/actor/update")
    public ResponseEntity<ActorModel> update(@RequestBody ActorModel actorModel)
    {
        ActorModel response = actorService.update(actorModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/actor/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = actorService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
