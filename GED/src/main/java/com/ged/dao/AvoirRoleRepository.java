package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.AvoirRole;
import com.ged.domain.AvoirRolePK;

@Repository
public interface AvoirRoleRepository extends JpaRepository<AvoirRole, AvoirRolePK> {
        @Query("SELECT a.role FROM AvoirRole a WHERE a.utilisateur = :u AND a.bibliotheque = :b")
        public Collection<Role> getRolesUtilisateur(@Param("u") Utilisateur utilisateur, @Param("b") Bibliotheque bibliotheque);
        
        @Query("DELETE AvoirRole a WHERE a.utilisateur = :u AND a.role = :r AND a.bibliotheque = :b")
        public void retirerRoleUtilisateur(@Param("u") Utilisateur utilisateur, @Param("r") Role role, @Param("b") Bibliotheque bibliotheque);
}
