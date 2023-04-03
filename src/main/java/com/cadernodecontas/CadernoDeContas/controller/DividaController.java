package com.cadernodecontas.CadernoDeContas.controller;

import com.cadernodecontas.CadernoDeContas.model.domain.DividaEntity;
import com.cadernodecontas.CadernoDeContas.model.service.DividaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/divida")
public class DividaController {

    @Autowired
    private DividaService dividaService;

    @PostMapping(value = "/cadastrar",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DividaEntity> cadastrarDivida(@RequestBody DividaEntity dividaEntity) {
        try {
            DividaEntity divida = dividaService.cadastrar(dividaEntity);
            return new ResponseEntity<>(divida, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<DividaEntity>> getAllDividas() {
        List<DividaEntity> dividaEntities = new ArrayList<DividaEntity>();
        try {
            dividaService.findAll().forEach(dividaEntities::add);

            if (dividaEntities.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(dividaEntities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}/buscar")
    public ResponseEntity<Optional<DividaEntity>> findDividaById(@PathVariable("id") Integer id) {
        Optional<DividaEntity> dividaEncontrada = Optional.of(dividaService.findDividaByid(id).get());

        try {
            if (dividaEncontrada.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(dividaEncontrada, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/deletar-todas-as-dividas")
    public ResponseEntity<HttpStatus> deleteAllDividas() {
        try {
            dividaService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}/deletar")
    public ResponseEntity<HttpStatus> deleteDividaById(@PathVariable("id") Integer id) {
        Optional<DividaEntity> dividaEncontrada = Optional.of(dividaService.findDividaByid(id).get());
        try {
            dividaService.deleteDividaById(dividaEncontrada.get().getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<DividaEntity> updateDividaById(@PathVariable("id") Integer id, @RequestBody DividaEntity dividaEntity) {
        Optional<DividaEntity> dividaEncontrada = dividaService.findDividaByid(id);

        if (dividaEncontrada.isPresent()) {
            DividaEntity divida = dividaEncontrada.get();
            divida.setValor(dividaEntity.getValor());
            divida.setNome(dividaEntity.getNome());
            divida.setDescricao(dividaEntity.getDescricao());
            divida.setDataFinal(dividaEntity.getDataFinal());
            divida.setDataDePgto(dividaEntity.getDataDePgto());
            divida.setDividaMesEntity(dividaEntity.getDividaMesEntity());

            return new ResponseEntity<>(dividaService.cadastrar(divida), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

