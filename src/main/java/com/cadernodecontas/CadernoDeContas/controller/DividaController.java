package com.cadernodecontas.CadernoDeContas.controller;

import com.cadernodecontas.CadernoDeContas.model.domain.DividaEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DividaController {

//    @Autowired
//    private DividaService dividaService;

    @PostMapping(value = "/divida/incluir")
    public String incluir(DividaEntity divida) {

//        dividaService.incluir(divida);

        return "";
    }

    //TODO fazer após CRUD
   /* @GetMapping(value = "/dividas")
    public ResponseEntity<String> getAll(){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    } */

    @PostMapping(path = "users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DividaEntity> create(@RequestBody DividaEntity dividaEntity) {

            //userService.save(newUser);

            return new ResponseEntity<>(dividaEntity, HttpStatus.CREATED);
        }
}

