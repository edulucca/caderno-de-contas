package com.cadernodecontas.CadernoDeContas.controller;

import com.cadernodecontas.CadernoDeContas.model.domain.DividaEntity;
import com.cadernodecontas.CadernoDeContas.model.domain.DividaMesEntity;
import com.cadernodecontas.CadernoDeContas.model.domain.enums.TipoDividaEnum;
import com.cadernodecontas.CadernoDeContas.model.repository.DividaRepository;
import com.cadernodecontas.CadernoDeContas.model.service.DividaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DividaController.class)
class DividaControllerTest {

    @MockBean
    DividaRepository dividaRepository;

    @Autowired
    private DividaService dividaService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    DividaEntity divida;
    Integer id = 1;

    @BeforeEach
    public void initEach() {
        DividaMesEntity dividaMes = new DividaMesEntity();
        dividaMes.setId(1);
        dividaMes.setNumMes(1);

        divida = new DividaEntity();
        divida.setId(1);
        divida.setValor(150.0);
        divida.setNome("Wifi");
        divida.setDescricao("Conta de internet");
        divida.setDataFinal(new Date(2025, 12, 01));
        divida.setDataDePgto(new Date(2023, 04, 17));
        divida.setTipoDividaEnum(TipoDividaEnum.FIXA);
        divida.setDividaMesEntity(dividaMes);
    }


    @Test
    void cadastrarDividaTest() throws Exception {
        mockMvc.perform(post("/api/divida/cadastrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(divida)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    void getAllDividasTest() {
    }

    //TODO terminar implementacao
    @Test
    void findDividaByIdTest() throws Exception {
        when(dividaService.findDividaByid(id)).thenReturn(Optional.of(divida));

        mockMvc.perform(get("/api/divida/{id}/buscar", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(divida.getId()))
                .andExpect(jsonPath("$.valor").value(divida.getValor()))
                .andExpect(jsonPath("$.nome").value(divida.getNome()))
                .andExpect(jsonPath("$.descricao").value(divida.getDescricao()))
                /*.andExpect(jsonPath("$.dataFinal").value("2025-12-01"))
                .andExpect(jsonPath("$[0].dataDePgto").value("2023-04-17"))
                .andExpect(jsonPath("$.tipoDividaEnum").value(divida.getTipoDividaEnum()))
                .andExpect(jsonPath("$.dividaMesEntity").value(divida.getDividaMesEntity())*/
                .andDo(print());
    }

    //TODO
   @Test
    void findDividaByIdDeveriaRetornarNoContentTest() throws Exception {
       when(dividaService.findDividaByid(id)).thenReturn(Optional.of(divida));
        //when(dividaService.findDividaByid(divida.getId())).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/divida/{id}/buscar", divida.getId()))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    void deleteAllDividasTest() throws Exception {
        doNothing().when(dividaRepository).deleteAll();

        mockMvc.perform(delete("/api/divida/deletar-todas-as-dividas"))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    void deleteDividaByIdTest() throws Exception {
        when(dividaService.findDividaByid(id)).thenReturn(Optional.of(Optional.of(divida).get()));
        doNothing().when(dividaRepository).deleteById(divida.getId());

        mockMvc.perform(delete("/api/divida/{id}/deletar", divida.getId()))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    void updateDividaByIdTest() throws Exception {
        DividaMesEntity dividaMesAtualizada = new DividaMesEntity();
        dividaMesAtualizada.setId(2);
        dividaMesAtualizada.setNumMes(2);

        DividaEntity dividaAtualizada = new DividaEntity();
        dividaAtualizada.setId(1);
        dividaAtualizada.setValor(160.0);
        dividaAtualizada.setNome("Wifi");
        dividaAtualizada.setDescricao("Conta de internet");
        dividaAtualizada.setDataFinal(new Date(2025, 12, 01));
        dividaAtualizada.setDataDePgto(new Date(2023, 04, 17));
        dividaAtualizada.setTipoDividaEnum(TipoDividaEnum.FIXA);
        dividaAtualizada.setDividaMesEntity(dividaMesAtualizada);

        when(dividaService.findDividaByid(id)).thenReturn(Optional.of(divida));
        when(dividaService.cadastrar(any(DividaEntity.class))).thenReturn(dividaAtualizada);

        mockMvc.perform(put("/api/divida/{id}/atualizar", dividaAtualizada.getId()))
                //.contentType(MediaType.APPLICATION_JSON)
                //.content(objectMapper.writeValueAsString(dividaAtualizada))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(dividaAtualizada.getId()))
                .andExpect(jsonPath("$.valor").value(dividaAtualizada.getValor()))
                .andExpect(jsonPath("$.nome").value(dividaAtualizada.getNome()))
                .andExpect(jsonPath("$.descricao").value(dividaAtualizada.getDescricao()))
                /*.andExpect(jsonPath("$.dataFinal").value("2025-12-01"))
                .andExpect(jsonPath("$[0].dataDePgto").value("2023-04-17"))
                .andExpect(jsonPath("$.tipoDividaEnum").value(dividaAtualizada.getTipoDividaEnum()))
                .andExpect(jsonPath("$.dividaMesEntity").value(dividaAtualizada.getDividaMesEntity())*/
                .andDo(print());
    }
}