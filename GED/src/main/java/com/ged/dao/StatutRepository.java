package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.Statut;

@Repository
public interface StatutRepository extends JpaRepository<Statut, Byte> {

}
