package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ged.domain.Action;

public interface ActionRepository extends JpaRepository<Action, Byte> {

}
