package com.example.academiacx.services;

import com.example.academiacx.handlers.exceptions.ParametroInvalidoException;
import com.example.academiacx.models.FranchiseModel;
import com.example.academiacx.repository.FranchiseRepository;
import com.example.academiacx.services.inter.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FranchiseServiceImpl implements FranchiseService {

    @Autowired
    private FranchiseRepository franchiseRepository;

    @Override
    public List<FranchiseModel> listFranchises() {
        return franchiseRepository.findAll();
    }

    @Override
    public Optional<FranchiseModel> findById(Long id) {
        return franchiseRepository.findById(id);
    }

    @Override
    public FranchiseModel create(FranchiseModel franchiseModel) {

        franchiseModel.setId(null);

        return franchiseRepository.save(franchiseModel);
    }

    @Override
    public FranchiseModel update(FranchiseModel franchiseModel) {

        if(franchiseModel.getId() == null || findById(franchiseModel.getId()).isEmpty()) {
            throw new ParametroInvalidoException("Id não encontrado");
        }

        return franchiseRepository.save(franchiseModel);
    }
}
