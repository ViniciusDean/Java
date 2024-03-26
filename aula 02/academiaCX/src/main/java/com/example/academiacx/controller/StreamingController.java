package com.example.academiacx.controller;

import com.example.academiacx.models.StreamingModel;
import com.example.academiacx.services.inter.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/streaming")
public class StreamingController {
    @Autowired
    private StreamingService streamingService;

    @GetMapping
    public List<StreamingModel> findAll()
    {
        return streamingService.listStreaming();
    }

    @GetMapping(value = "/{id}")
    public Optional<StreamingModel> findById(@PathVariable Long id)
    {
        return streamingService.findById(id);
    }

    @PostMapping
    public StreamingModel save(@RequestBody StreamingModel streamingModel)
    {
        return streamingService.create(streamingModel);
    }

    @PutMapping
    public StreamingModel update(@RequestBody StreamingModel streamingModel)
    {
        return streamingService.update(streamingModel);
    }
}
