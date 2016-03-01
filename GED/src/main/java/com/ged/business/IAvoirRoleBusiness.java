package com.ged.business;

import java.util.Collection;

import com.ged.domain.AvoirRole;
import com.ged.domain.Bibliotheque;
import com.ged.domain.Role;
import com.ged.domain.Utilisateur;

public interface IAvoirRoleBusiness {

	AvoirRole attribuerRoleUtilisateur(Utilisateur utilisateur, Role role, Bibliotheque bibliotheque);

	void retirerRoleUtilisateur(Utilisateur utilisateur, Role role, Bibliotheque bibliotheque);

	Collection<Role> getRolesUtilisateur(Utilisateur utilisateur, Bibliotheque bibliotheque);

}
