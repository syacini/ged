package com.ged.business;

import java.util.Collection;

import com.ged.domain.Bibliotheque;

public interface IBibliothequeBusiness {

	public Bibliotheque creerBibliotheque(Bibliotheque bibliotheque);

	public Collection<Bibliotheque> getAllBibliotheques();

	public Bibliotheque getBibliothequeById(Short id);

	public Bibliotheque majBibliotheque(Bibliotheque bibliotheque);

	public void supprimerBibliotheque(Bibliotheque bibliotheque);

	public void restaurerBibliotheque(Bibliotheque bibliotheque);
}
