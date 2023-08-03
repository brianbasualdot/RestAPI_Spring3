package com.org.ApiRest.service;

import com.org.ApiRest.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerService {

    List<Maker> findAll();

    Optional<Maker> findById(Long Id);

    void save(Maker maker);

    void deleteById(Long id);
}
