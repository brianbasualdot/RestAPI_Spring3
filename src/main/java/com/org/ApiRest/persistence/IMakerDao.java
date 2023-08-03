package com.org.ApiRest.persistence;

import com.org.ApiRest.entities.Maker;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Optional;

public interface IMakerDao {

    List<Maker> findAll();
    Optional<Maker> findById(Long Id);

    void save(Maker maker);

    void deleteById(Long id);
}
