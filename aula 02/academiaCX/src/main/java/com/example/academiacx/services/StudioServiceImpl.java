package com.example.academiacx.services;

import com.example.academiacx.handlers.exceptions.ParametroInvalidoException;
import com.example.academiacx.models.StudioModel;
import com.example.academiacx.repository.StudioRepository;
import com.example.academiacx.services.inter.GenreService;
import com.example.academiacx.services.inter.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioServiceImpl  implements StudioService {
    @Autowired
    private StudioRepository studioRepository;

    @Override
    public List<StudioModel> listStudios() {
        return studioRepository.findAll();
    }

    @Override
    public Optional<StudioModel> findById(Long id) {
        return studioRepository.findById(id);
    }

    @Override
    public StudioModel create(StudioModel studioModel) {

        studioModel.setId(null);

        return studioRepository.save(studioModel);
    }

    @Override
    public StudioModel update(StudioModel studioModel) {

        if(studioModel.getId() == null || findById(studioModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return studioRepository.save(studioModel);
    }
}
