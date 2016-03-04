package com.ged.business;

import java.util.Collection;

import com.ged.domain.tenant.Statut;

public interface IStatutBusiness {

	public Statut creerStatut(Statut statut);

	public Collection<Statut> getAllStatuts();

	public Statut getStatutById(Byte id);

	public Statut majStatut(Statut statut);

	public void supprimerStatut(Statut statut);
}
