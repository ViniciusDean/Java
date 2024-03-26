package com.example.academiacx.services.inter;
import com.example.academiacx.models.MovieModel;
import com.example.academiacx.repository.MovieRepository;

import com.example.academiacx.models.GenreModel;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieModel> listMovies();
    Optional<MovieModel> findById(Long id);

    MovieModel create(MovieModel movieModel);

    MovieModel update(MovieModel movieModel);

}