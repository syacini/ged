package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.Conteneur;

@Repository
public interface ConteneurRepository extends JpaRepository<Conteneur, Integer> {

}
