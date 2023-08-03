package com.org.ApiRest.service.IMPL;

import com.org.ApiRest.entities.Maker;
import com.org.ApiRest.persistence.IMakerDao;
import com.org.ApiRest.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IMPLMakerService implements IMakerService {
    @Autowired
    private IMakerDao iMakerDao;

    @Override
    public List<Maker> findAll() {
        return iMakerDao.findAll();
    }

    @Override
    public Optional<Maker> findById(Long Id) {
        return iMakerDao.findById(Id);
    }

    @Override
    public void save(Maker maker) {
        iMakerDao.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        iMakerDao.deleteById(id);
    }
}
