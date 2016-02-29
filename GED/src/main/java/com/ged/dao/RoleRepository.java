package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Byte> {

}
