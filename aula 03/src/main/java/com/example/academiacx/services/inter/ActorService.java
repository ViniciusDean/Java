package com.example.academiacx.services.inter;

import com.example.academiacx.models.ActorModel;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    List<ActorModel> list();

    Optional<ActorModel> findById(Long id);

    ActorModel create(ActorModel actorModel);

    ActorModel update(ActorModel actorModel);
    boolean delete(Long id);

}
