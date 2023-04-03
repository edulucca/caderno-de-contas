package com.cadernodecontas.CadernoDeContas.model.repository;

import com.cadernodecontas.CadernoDeContas.model.domain.DividaMesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DividaMesRepository extends JpaRepository<DividaMesEntity, Integer> {
}
