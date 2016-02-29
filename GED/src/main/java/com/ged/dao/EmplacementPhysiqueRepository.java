package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.EmplacementPhysique;

@Repository
public interface EmplacementPhysiqueRepository extends JpaRepository<EmplacementPhysique, Integer> {

}
