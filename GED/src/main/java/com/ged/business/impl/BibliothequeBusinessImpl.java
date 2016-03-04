package com.ged.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.business.IBibliothequeBusiness;
import com.ged.business.IConteneurBusiness;
import com.ged.dao.tenant.BibliothequeRepository;
import com.ged.domain.tenant.Bibliotheque;
import com.ged.domain.tenant.Conteneur;

@Service
public class BibliothequeBusinessImpl implements IBibliothequeBusiness {

	@Autowired
	private BibliothequeRepository bibliothequeRepository;

	@Autowired
	private IConteneurBusiness conteneurBusiness;

	@Override
	public Bibliotheque creerBibliotheque(Bibliotheque bibliotheque) {
		return bibliothequeRepository.saveAndFlush(bibliotheque);
	}

	@Override
	public Collection<Bibliotheque> getAllBibliotheques() {
		return bibliothequeRepository.findAll();
	}

	@Override
	public Bibliotheque getBibliothequeById(Short id) {
		return bibliothequeRepository.findOne(id);
	}

	@Override
	public Bibliotheque majBibliotheque(Bibliotheque bibliotheque) {
		return creerBibliotheque(bibliotheque);
	}

	@Override
	public void supprimerBibliotheque(Bibliotheque bibliotheque) {
		bibliotheque.setActive(false);
		for (Conteneur conteneur : bibliotheque.getConteneurs()) {
			conteneurBusiness.supprimerConteneur(conteneur);
		}
	}

	@Override
	public void restaurerBibliotheque(Bibliotheque bibliotheque) {
		bibliotheque.setActive(true);
		for (Conteneur conteneur : bibliotheque.getConteneurs()) {
			conteneurBusiness.restaurerConteneur(conteneur);
		}
	}

}
