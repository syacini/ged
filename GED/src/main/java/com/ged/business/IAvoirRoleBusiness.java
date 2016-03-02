package com.ged.business;

import java.util.Collection;

import com.ged.domain.AvoirRole;
import com.ged.domain.Bibliotheque;
import com.ged.domain.Role;
import com.ged.domain.Utilisateur;

public interface IAvoirRoleBusiness {

	AvoirRole attribuerRoleUtilisateurBibliotheque(Utilisateur utilisateur, Role role, Bibliotheque bibliotheque);

	void retirerRoleUtilisateurBibliotheque(Utilisateur utilisateur, Role role, Bibliotheque bibliotheque);

	Collection<Role> getRolesUtilisateurBibliotheque(Utilisateur utilisateur, Bibliotheque bibliotheque);

}
