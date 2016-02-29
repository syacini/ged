package com.ged.business;

import java.util.Collection;

import com.ged.domain.Utilisateur;

public interface IUtilisateurBusiness {

	Utilisateur ajouterUtilisateur(Utilisateur utilisateur);

	Utilisateur getUtilisateurById(Byte id);

	Collection<Utilisateur> getAllUtilisateurs();

	Utilisateur majUtilisateur(Utilisateur utilisateur);

	Utilisateur desactiverUtilisateur(Utilisateur utilisateur);
	
	Utilisateur reactiverUtilisateur(Utilisateur utilisateur);
}
