package com.example.academiacx.services.inter;

import com.example.academiacx.models.FranchiseModel;

import java.util.List;
import java.util.Optional;

public interface FranchiseService {
    List<FranchiseModel> listFranchises();

    Optional<FranchiseModel> findById(Long id);

    FranchiseModel create(FranchiseModel franchiseModel);

    FranchiseModel update(FranchiseModel franchiseModel);
}
