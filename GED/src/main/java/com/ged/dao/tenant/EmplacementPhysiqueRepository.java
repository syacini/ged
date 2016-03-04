package com.ged.dao.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.tenant.EmplacementPhysique;

@Repository
public interface EmplacementPhysiqueRepository extends JpaRepository<EmplacementPhysique, Integer> {

}
