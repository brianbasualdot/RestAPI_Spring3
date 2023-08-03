package com.org.ApiRest.service.IMPL;

import com.org.ApiRest.entities.Product;
import com.org.ApiRest.persistence.IProductDao;
import com.org.ApiRest.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class IMPLProductService implements IproductService {

    @Autowired
    private IProductDao iProductDao;

    @Override
    public List<Product> findAll() {
        return iProductDao.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductDao.findById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return iProductDao.findByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public void save(Product product) {
        iProductDao.save(product);
    }

    @Override
    public void deleteById(Long id) {
        iProductDao.deleteById(id);
    }
}
