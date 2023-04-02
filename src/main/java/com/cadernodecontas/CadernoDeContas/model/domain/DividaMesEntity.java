package com.cadernodecontas.CadernoDeContas.model.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "dividaMes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DividaMesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int numMes;

    @OneToMany(mappedBy = "dividaMesEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DividaEntity> dividaEntityList;

    public double calculoTotal() {
        return 0.0;
    }

    public double calculoTotalFixas() {
        return 0.0;
    }

    public double calculoTotalVariaveis() {
        return 0.0;
    }
}
