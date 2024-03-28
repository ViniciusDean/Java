package com.example.academiacx.controller;

import com.example.academiacx.models.StreamingModel;
import com.example.academiacx.models.StreamingModel;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.services.inter.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/streaming")
public class StreamingController {
    @Autowired
    private StreamingService streamingService;

    @GetMapping(value = "/streaming/list")
    public ResponseEntity<List<StreamingModel>> findAll()
    {
        List<StreamingModel> response = streamingService.list();

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/streaming/{id}")
    public ResponseEntity<Optional<StreamingModel>> findById(@PathVariable Long id)
    {
        Optional<StreamingModel> response = streamingService.findById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/streaming/save")
    public ResponseEntity<StreamingModel> save(@RequestBody StreamingModel streamingModel)
    {
        StreamingModel response = streamingService.create(streamingModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/streaming/update")
    public ResponseEntity<StreamingModel> update(@RequestBody StreamingModel streamingModel)
    {
        StreamingModel response = streamingService.update(streamingModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }
    @DeleteMapping(value = "/streaming/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = streamingService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
