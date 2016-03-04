package com.ged.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.business.IStatutBusiness;
import com.ged.dao.tenant.StatutRepository;
import com.ged.domain.tenant.Statut;

@Service
public class StatutBusinessImpl implements IStatutBusiness {

	@Autowired
	private StatutRepository statutRepository;

	@Override
	public Statut creerStatut(Statut statut) {
		return statutRepository.saveAndFlush(statut);
	}

	@Override
	public Collection<Statut> getAllStatuts() {
		return statutRepository.findAll();
	}

	@Override
	public Statut getStatutById(Byte id) {
		return statutRepository.findOne(id);
	}

	@Override
	public Statut majStatut(Statut statut) {
		return creerStatut(statut);
	}

	@Override
	public void supprimerStatut(Statut statut) {
		// TODO
	}

}
