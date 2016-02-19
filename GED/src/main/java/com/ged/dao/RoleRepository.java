package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ged.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Byte> {

}
