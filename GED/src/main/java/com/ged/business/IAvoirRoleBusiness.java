package com.ged.business;

import java.util.Collection;

import com.ged.domain.tenant.AvoirRole;
import com.ged.domain.tenant.Bibliotheque;
import com.ged.domain.tenant.Role;
import com.ged.domain.tenant.Utilisateur;

public interface IAvoirRoleBusiness {

	AvoirRole attribuerRoleUtilisateurBibliotheque(Utilisateur utilisateur, Role role, Bibliotheque bibliotheque);

	void retirerRoleUtilisateurBibliotheque(Utilisateur utilisateur, Role role, Bibliotheque bibliotheque);

	Collection<Role> getRolesUtilisateurBibliotheque(Utilisateur utilisateur, Bibliotheque bibliotheque);

}
