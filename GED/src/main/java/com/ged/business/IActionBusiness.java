package com.ged.business;

import java.util.Collection;

import com.ged.domain.tenant.Action;

public interface IActionBusiness {

	public Action ajouterAction(Action action);

	public Collection<Action> getAllActions();

	public Action getActionById(Byte id);

	public Action majAction(Action action);

	public void supprimerAction(Action action);
}
