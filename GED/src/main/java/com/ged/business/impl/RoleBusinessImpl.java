package com.ged.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.business.IRoleBusiness;
import com.ged.dao.tenant.RoleRepository;
import com.ged.domain.tenant.Action;
import com.ged.domain.tenant.Role;

@Service
public class RoleBusinessImpl implements IRoleBusiness {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role ajouterRole(Role role) {
		return roleRepository.saveAndFlush(role);
	}

	@Override
	public Collection<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleById(Byte id) {
		return roleRepository.findOne(id);
	}

	@Override
	public void attribuerAction(Role role, Action action) {
		if (!role.getActions().contains(action)) {
			role.getActions().add(action);
			roleRepository.saveAndFlush(role);
		}
	}

	@Override
	public void retirerAction(Role role, Action action) {
		if (role.getActions().remove(action)) {
			roleRepository.saveAndFlush(role);
		}
	}

	@Override
	public void supprimerRole(Role role) {
		roleRepository.delete(role);
	}

}
