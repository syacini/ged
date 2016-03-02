package com.ged.business;

import java.util.Collection;

import com.ged.domain.Conteneur;

public interface IConteneurBusiness {

	public Conteneur creerConteneur(Conteneur conteneur);

	public Collection<Conteneur> getAllConteneurs();

	public Conteneur getConteneurById(Integer id);

	public Conteneur majConteneur(Conteneur conteneur);

	public void supprimerConteneur(Conteneur conteneur);

	public void restaurerConteneur(Conteneur conteneur);
}
