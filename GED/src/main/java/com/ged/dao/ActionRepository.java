package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Byte> {

}
