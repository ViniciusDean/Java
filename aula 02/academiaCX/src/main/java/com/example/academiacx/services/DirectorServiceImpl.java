package com.example.academiacx.services;

import com.example.academiacx.handlers.exceptions.ParametroInvalidoException;
import com.example.academiacx.models.DirectorModel;
import com.example.academiacx.repository.ActorRepository;
import com.example.academiacx.repository.DirectorRepository;
import com.example.academiacx.services.inter.ActorService;
import com.example.academiacx.services.inter.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImpl implements DirectorService {
    @Autowired
    private DirectorRepository directorRepository;
    @Override
    public List<DirectorModel> listDirectors() {
        return directorRepository.findAll();
    }

    @Override
    public Optional<DirectorModel> findById(Long id) {
        return directorRepository.findById(id);
    }

    @Override
    public DirectorModel create(DirectorModel actorModel) {
        actorModel.setId(null);

        return directorRepository.save(actorModel);
    }
    
    @Override
    public DirectorModel update(DirectorModel actorModel) {
        if(actorModel.getId() == null || findById(actorModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return directorRepository.save(actorModel);
    }

}
