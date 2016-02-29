package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.AvoirRole;
import com.ged.domain.AvoirRolePK;

@Repository
public interface AvoirRoleRepository extends JpaRepository<AvoirRole, AvoirRolePK> {

}
