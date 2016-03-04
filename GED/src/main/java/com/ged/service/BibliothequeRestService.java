package com.ged.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ged.business.IBibliothequeBusiness;
import com.ged.domain.tenant.Bibliotheque;

@RestController
public class BibliothequeRestService {

	@Autowired
	private IBibliothequeBusiness bibliothequeBusiness;

	@RequestMapping(value = "/bibliotheques", method = RequestMethod.POST)
	public Bibliotheque creerBibliotheque(@RequestBody Bibliotheque bibliotheque) {
		return bibliothequeBusiness.creerBibliotheque(bibliotheque);
	}

	@RequestMapping(value = "/bibliotheques", method = RequestMethod.GET)
	public Collection<Bibliotheque> getAllBibliotheques() {
		return bibliothequeBusiness.getAllBibliotheques();
	}

	public Bibliotheque getBibliothequeById(Short id) {
		return bibliothequeBusiness.getBibliothequeById(id);
	}

	public Bibliotheque majBibliotheque(Bibliotheque bibliotheque) {
		return bibliothequeBusiness.majBibliotheque(bibliotheque);
	}

	public void supprimerBibliotheque(Bibliotheque bibliotheque) {
		bibliothequeBusiness.supprimerBibliotheque(bibliotheque);
	}

	public void restaurerBibliotheque(Bibliotheque bibliotheque) {
		bibliothequeBusiness.restaurerBibliotheque(bibliotheque);
	}

}
