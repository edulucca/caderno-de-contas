package com.cadernodecontas.CadernoDeContas.controller;

import com.cadernodecontas.CadernoDeContas.model.domain.DividaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class DividaController {

//    @Autowired
//    private DividaService dividaService;

    @PostMapping(value = "/divida/incluir")
    public String incluir(DividaEntity divida) {

//        dividaService.incluir(divida);

        return "";
    }
}
