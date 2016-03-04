package com.ged.dao.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.tenant.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Byte> {

}
