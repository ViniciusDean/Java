package com.example.academiacx.services.inter;

import com.example.academiacx.models.GenreModel;
import com.example.academiacx.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<GenreModel> listGenres();
    Optional<GenreModel> findById(Long id);

    GenreModel create(GenreModel genreModel);

    GenreModel update(GenreModel genreModel);

}
