package com.ged.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.business.IAvoirRoleBusiness;
import com.ged.dao.tenant.AvoirRoleRepository;
import com.ged.domain.tenant.AvoirRole;
import com.ged.domain.tenant.AvoirRolePK;
import com.ged.domain.tenant.Bibliotheque;
import com.ged.domain.tenant.Role;
import com.ged.domain.tenant.Utilisateur;

@Service
public class AvoirRoleBusinessImpl implements IAvoirRoleBusiness {

	@Autowired
	private AvoirRoleRepository avoirRoleRepository;

	@Override
	public AvoirRole attribuerRoleUtilisateurBibliotheque(Utilisateur utilisateur, Role role,
			Bibliotheque bibliotheque) {
		AvoirRolePK id = new AvoirRolePK();
		id.setUtilisateur(utilisateur);
		id.setRole(role);
		id.setBibliotheque(bibliotheque);
		AvoirRole avoirRole = new AvoirRole();
		avoirRole.setId(id);
		return avoirRoleRepository.saveAndFlush(avoirRole);
	}

	@Override
	public void retirerRoleUtilisateurBibliotheque(Utilisateur utilisateur, Role role, Bibliotheque bibliotheque) {
		avoirRoleRepository.retirerRoleUtilisateur(utilisateur, role, bibliotheque);
	}

	@Override
	public Collection<Role> getRolesUtilisateurBibliotheque(Utilisateur utilisateur, Bibliotheque bibliotheque) {
		return avoirRoleRepository.getRolesUtilisateur(utilisateur, bibliotheque);
	}

}
