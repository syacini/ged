package com.ged.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.business.IConteneurBusiness;
import com.ged.dao.ConteneurRepository;
import com.ged.domain.Conteneur;

@Service
public class ConteneurBusinessImpl implements IConteneurBusiness {

	@Autowired
	private ConteneurRepository conteneurRepository;

	@Override
	public Conteneur creerConteneur(Conteneur conteneur) {
		return conteneurRepository.saveAndFlush(conteneur);
	}

	@Override
	public Collection<Conteneur> getAllConteneurs() {
		return conteneurRepository.findAll();
	}

	@Override
	public Conteneur getConteneurById(Integer id) {
		return conteneurRepository.findOne(id);
	}

	@Override
	public Conteneur majConteneur(Conteneur conteneur) {
		return creerConteneur(conteneur);
	}

	@Override
	public void supprimerConteneur(Conteneur conteneur) {
		conteneur.setActif(false);
		for (Conteneur cEnfant : conteneur.getConteneursEnfants()) {
			supprimerConteneur(cEnfant);
		}
	}

	@Override
	public void restaurerConteneur(Conteneur conteneur) {
		conteneur.setActif(true);
		for (Conteneur cEnfant : conteneur.getConteneursEnfants()) {
			restaurerConteneur(cEnfant);
		}
	}

}
