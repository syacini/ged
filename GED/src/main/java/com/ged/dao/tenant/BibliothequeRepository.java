package com.ged.dao.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.tenant.Bibliotheque;

@Repository
public interface BibliothequeRepository extends JpaRepository<Bibliotheque, Short> {

}
