package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ged.domain.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Byte> {

}
