package com.cadernodecontas.CadernoDeContas.controller;

import com.cadernodecontas.CadernoDeContas.model.domain.DividaEntity;
import com.cadernodecontas.CadernoDeContas.model.repository.DividaRepository;
import com.cadernodecontas.CadernoDeContas.model.service.DividaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/divida")
public class DividaController {

    @Autowired
    private DividaService dividaService;

    @PostMapping(value = "/cadastrar",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DividaEntity> cadastrarDivida(@RequestBody DividaEntity dividaEntity) {
       try{
            DividaEntity divida = dividaService.cadastrar(dividaEntity);
            return new ResponseEntity<>(divida, HttpStatus.CREATED);
       } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @GetMapping(value = "/")
    public ResponseEntity<List<DividaEntity>> getAllDivida(){
       List<DividaEntity> dividaEntities = new ArrayList<DividaEntity>();
       try {
            dividaService.findAll().forEach(dividaEntities::add);

            if(dividaEntities.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

       return new ResponseEntity<>(dividaEntities, HttpStatus.OK);
       } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }
}

