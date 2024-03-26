package com.example.academiacx.services.inter;

import com.example.academiacx.models.StudioModel;
import com.example.academiacx.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface StudioService {
    List<StudioModel> listStudios();

    Optional<StudioModel> findById(Long id);

    StudioModel create(StudioModel studioModel);

    StudioModel update(StudioModel studioModel);
}
