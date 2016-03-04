package com.ged.business;

import java.util.Collection;

import com.ged.domain.tenant.EmplacementPhysique;

public interface IEmplacementPhysiqueBusiness {

	public EmplacementPhysique creerEmplacementPhysique(EmplacementPhysique emplacementPhysique);

	public Collection<EmplacementPhysique> getAllEmplacememnts();

	public EmplacementPhysique getEmplacementById(Integer id);

	public EmplacementPhysique majEmplacementPhysique(EmplacementPhysique emplacementPhysique);

	public void supprimerEmplacement(EmplacementPhysique emplacementPhysique);
}
