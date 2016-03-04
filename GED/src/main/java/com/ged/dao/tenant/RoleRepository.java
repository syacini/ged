package com.ged.dao.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.tenant.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Byte> {

}
