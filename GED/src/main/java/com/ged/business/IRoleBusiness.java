package com.ged.business;

import java.util.Collection;

import com.ged.domain.Action;
import com.ged.domain.Role;

public interface IRoleBusiness {

	public Role ajouterRole(Role role);

	public Collection<Role> getAllRoles();

	public Role getRoleById(Byte id);

	public void attribuerAction(Role role, Action action);

	public void retirerAction(Role role, Action action);

	public void supprimerRole(Role role);
}
