package com.cadernodecontas.CadernoDeContas.model.domain;

import com.cadernodecontas.CadernoDeContas.model.domain.enums.TipoDividaEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

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
    private String desc;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataFinal;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataDePgto;

    @Enumerated(EnumType.STRING)
    private TipoDividaEnum tipoDividaEnum;

    @ManyToOne(targetEntity = DividaMesEntity.class)
    @JoinColumn(name = "dividaMes_id", nullable = false)
    private DividaMesEntity dividaMesEntity;
}
