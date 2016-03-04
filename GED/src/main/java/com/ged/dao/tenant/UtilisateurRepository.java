package com.ged.dao.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.tenant.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Byte> {

}
