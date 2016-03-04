package com.ged.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.business.IEmplacementPhysiqueBusiness;
import com.ged.dao.tenant.EmplacementPhysiqueRepository;
import com.ged.domain.tenant.EmplacementPhysique;

@Service
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
