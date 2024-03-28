package com.example.academiacx.services;

import com.example.academiacx.handlers.exceptions.ParametroInvalidoException;
import com.example.academiacx.handlers.exceptions.RecursoNaoEntradoException;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.repository.MovieRepository;
import com.example.academiacx.services.inter.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<MovieModel> list() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<MovieModel> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public MovieModel create(MovieModel genreModel) {
        genreModel.setId(null);

        return movieRepository.save(genreModel);
    }

    @Override
    public MovieModel update(MovieModel genreModel) {
        if(genreModel.getId() == null || findById(genreModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return movieRepository.save(genreModel);
    }
    @Override
    public List<MovieModel> getUser(Long id) {

        return (List<MovieModel>) movieRepository.getReferenceById(id);
    }
    public boolean delete(Long id) {

        findById(id);

        try {
            movieRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecursoNaoEntradoException("Id informado não encontrado!");
        }

    }
}
