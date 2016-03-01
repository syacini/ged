package com.ged.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.ged.business.IAvoirRoleBusiness;
import com.ged.dao.AvoirRoleRepository;
import com.ged.domain.AvoirRole;
import com.ged.domain.AvoirRolePK;
import com.ged.domain.Bibliotheque;
import com.ged.domain.Role;
import com.ged.domain.Utilisateur;

public class AvoirRoleBusinessImpl implements IAvoirRoleBusiness {

	@Autowired
	private AvoirRoleRepository avoirRoleRepository;

	@Override
	public AvoirRole attribuerRoleUtilisateur(Utilisateur utilisateur, Role role, Bibliotheque bibliotheque) {
		AvoirRolePK id = new AvoirRolePK();
		id.setUtilisateur(utilisateur);
		id.setRole(role);
		id.setBibliotheque(bibliotheque);
		AvoirRole avoirRole = new AvoirRole();
		avoirRole.setId(id);
		return avoirRoleRepository.saveAndFlush(avoirRole);
	}

	@Override
	public void retirerRoleUtilisateur(Utilisateur utilisateur, Role role, Bibliotheque bibliotheque) {
		avoirRoleRepository.retirerRoleUtilisateur(utilisateur, role, bibliotheque);
	}

	@Override
	public Collection<Role> getRolesUtilisateur(Utilisateur utilisateur, Bibliotheque bibliotheque) {
		return avoirRoleRepository.getRolesUtilisateur(utilisateur, bibliotheque);
	}
	

}
