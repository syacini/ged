package com.ged.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.ged.business.IEmplacementPhysiqueBusiness;
import com.ged.dao.EmplacementPhysiqueRepository;
import com.ged.domain.EmplacementPhysique;

public class EmplacementPhysiqueImpl implements IEmplacementPhysiqueBusiness {

	@Autowired
	private EmplacementPhysiqueRepository epRepository;

	@Override
	public EmplacementPhysique creerEmplacementPhysique(EmplacementPhysique emplacementPhysique) {
		return epRepository.saveAndFlush(emplacementPhysique);
	}

	@Override
	public Collection<EmplacementPhysique> getAllEmplacememnts() {
		return epRepository.findAll();
	}

	@Override
	public EmplacementPhysique getEmplacementById(Integer id) {
		return epRepository.findOne(id);
	}

	@Override
	public EmplacementPhysique majEmplacementPhysique(EmplacementPhysique emplacementPhysique) {
		return creerEmplacementPhysique(emplacementPhysique);
	}

	@Override
	public void supprimerEmplacement(EmplacementPhysique emplacementPhysique) {
		epRepository.delete(emplacementPhysique);
	}

}
