package com.ged.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ged.domain.AvoirRole;
import com.ged.domain.AvoirRolePK;
import com.ged.domain.Bibliotheque;
import com.ged.domain.Role;
import com.ged.domain.Utilisateur;

@Repository
public interface AvoirRoleRepository extends JpaRepository<AvoirRole, AvoirRolePK> {
        @Query("SELECT a.id.role FROM AvoirRole a WHERE a.id.utilisateur = :u AND a.id.bibliotheque = :b")
        public Collection<Role> getRolesUtilisateur(@Param("u") Utilisateur utilisateur, @Param("b") Bibliotheque bibliotheque);
        
        @Query("DELETE AvoirRole a WHERE a.id.utilisateur = :u AND a.id.role = :r AND a.id.bibliotheque = :b")
        public void retirerRoleUtilisateur(@Param("u") Utilisateur utilisateur, @Param("r") Role role, @Param("b") Bibliotheque bibliotheque);
}
