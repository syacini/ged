package com.ged.dao.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.tenant.Conteneur;

@Repository
public interface ConteneurRepository extends JpaRepository<Conteneur, Integer> {

}
