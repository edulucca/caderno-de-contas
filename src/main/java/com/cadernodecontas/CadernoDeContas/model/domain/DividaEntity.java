package com.cadernodecontas.CadernoDeContas.model.domain;

import com.cadernodecontas.CadernoDeContas.model.domain.enums.TipoDividaEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
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
    private String desc;

    // @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataFinal;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    // @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date dataDePgto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoDivida")
    private TipoDividaEnum tipoDividaEnum;

    @ManyToOne(targetEntity = DividaMesEntity.class)
    @JoinColumn(name = "dividaMes_id", nullable = false)
    private DividaMesEntity dividaMesEntity;
}
