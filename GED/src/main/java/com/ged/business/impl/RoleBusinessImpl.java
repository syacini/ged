package com.ged.business.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.ged.business.IRoleBusiness;
import com.ged.dao.RoleRepository;
import com.ged.domain.Action;
import com.ged.domain.Role;

public class RoleBusinessImpl implements IRoleBusiness {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role ajouterRole(Role role) {
		return null;
	}

	@Override
	public Collection<Role> getAllRoles() {
		return null;
	}

	@Override
	public Role getRoleById(Serializable id) {
		return null;
	}

	@Override
	public void attribuerAction(Role role, Action action) {

	}

	@Override
	public void retirerAction(Role role, Action action) {

	}

	@Override
	public void supprimerRole(Role role) {

	}

}
