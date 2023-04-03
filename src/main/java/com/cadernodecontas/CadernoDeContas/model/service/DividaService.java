package com.cadernodecontas.CadernoDeContas.model.service;

import com.cadernodecontas.CadernoDeContas.model.domain.DividaEntity;
import com.cadernodecontas.CadernoDeContas.model.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DividaService {

    @Autowired
    private DividaRepository dividaRepository;

    public DividaEntity cadastrar(DividaEntity divida) {
        DividaEntity dividaResponse = dividaRepository.save(divida);
        return dividaResponse;
    }

    public List<DividaEntity> findAll() {
        List<DividaEntity> dividaEntities = dividaRepository.findAll();
        return dividaEntities;
    }

    public Optional<DividaEntity> findDividaByid(Integer id) {
        Optional<DividaEntity> dividaEncontrada = dividaRepository.findById(id);
        return dividaEncontrada;
    }

    public void deleteDividaById(Integer id) {
        Optional<DividaEntity> dividaEncontrada = dividaRepository.findById(id);
        dividaRepository.deleteById(dividaEncontrada.get().getId());
    }

    public void deleteAll() {
        dividaRepository.deleteAll();
    }
}
