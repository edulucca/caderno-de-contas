package com.cadernodecontas.CadernoDeContas.model.service;

import com.cadernodecontas.CadernoDeContas.model.domain.DividaEntity;
import com.cadernodecontas.CadernoDeContas.model.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DividaService {

    @Autowired
    private DividaRepository dividaRepository;

    public DividaEntity cadastrar(DividaEntity divida) {
        DividaEntity dividaResponse = dividaRepository.save(divida);
        return dividaResponse;
    }
}
