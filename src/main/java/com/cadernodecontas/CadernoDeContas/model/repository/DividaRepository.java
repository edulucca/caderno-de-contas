package com.cadernodecontas.CadernoDeContas.model.repository;

import com.cadernodecontas.CadernoDeContas.model.domain.DividaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DividaRepository extends JpaRepository<DividaEntity, Integer> {
}
