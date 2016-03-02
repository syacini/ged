package com.ged.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.business.IActionBusiness;
import com.ged.dao.ActionRepository;
import com.ged.domain.Action;

@Service
public class ActionBusinessImpl implements IActionBusiness {

	@Autowired
	private ActionRepository actionRepository;

	@Override
	public Action ajouterAction(Action action) {
		return actionRepository.saveAndFlush(action);
	}

	@Override
	public Collection<Action> getAllActions() {
		return actionRepository.findAll();
	}

	@Override
	public Action getActionById(Byte id) {
		return actionRepository.findOne(id);
	}

	@Override
	public Action majAction(Action action) {
		return ajouterAction(action);
	}

	@Override
	public void supprimerAction(Action action) {
		actionRepository.delete(action);
	}

}
