package com.ged.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.business.IUtilisateurBusiness;
import com.ged.dao.UtilisateurRepository;
import com.ged.domain.Utilisateur;

@Service
public class UtilisateurBusinessImpl implements IUtilisateurBusiness {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
		return utilisateurRepository.saveAndFlush(utilisateur);
	}

	@Override
	public Utilisateur getUtilisateurById(Byte id) {
		return utilisateurRepository.getOne(id);
	}

	@Override
	public Collection<Utilisateur> getAllUtilisateurs() {
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur majUtilisateur(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public Utilisateur desactiverUtilisateur(Utilisateur utilisateur) {
		utilisateur.setActif(false);
		return majUtilisateur(utilisateur);
	}

	@Override
	public Utilisateur reactiverUtilisateur(Utilisateur utilisateur) {
		utilisateur.setActif(true);
		return majUtilisateur(utilisateur);
	}
}
