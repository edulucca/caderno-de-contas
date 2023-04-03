package com.cadernodecontas.CadernoDeContas.model.domain;

import com.cadernodecontas.CadernoDeContas.model.domain.enums.TipoDividaEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "divida")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DividaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double valor;

    private String nome;
    private String descricao;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataFinal;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataDePgto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoDivida")
    private TipoDividaEnum tipoDividaEnum;

    @ManyToOne(targetEntity = DividaMesEntity.class)
    @JoinColumn(name = "dividaMes_id")
    @JsonBackReference
    private DividaMesEntity dividaMesEntity;
}
