package com.ged.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the t_bibliotheque database table.
 * 
 */
@Entity
@Table(name = "t_bibliotheque")
@NamedQuery(name = "Bibliotheque.findAll", query = "SELECT b FROM Bibliotheque b")
public class Bibliotheque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BIBLIOTHEQUE", updatable = false, unique = true, nullable = false)
	private Byte idBibliotheque;

	@Column(name = "LIBELLE_BIBLIOTHEQUE", nullable = false, length = 32)
	private String libelleBibliotheque;

	// bi-directional many-to-one association to Conteneur
	@OneToMany(mappedBy = "bibliotheque")
	private List<Conteneur> conteneurs;

	public Bibliotheque() {
	}

	public Byte getIdBibliotheque() {
		return this.idBibliotheque;
	}

	public void setIdBibliotheque(Byte idBibliotheque) {
		this.idBibliotheque = idBibliotheque;
	}

	public String getLibelleBibliotheque() {
		return this.libelleBibliotheque;
	}

	public void setLibelleBibliotheque(String libelleBibliotheque) {
		this.libelleBibliotheque = libelleBibliotheque;
	}

	public List<Conteneur> getConteneurs() {
		return this.conteneurs;
	}

	public void setConteneurs(List<Conteneur> conteneurs) {
		this.conteneurs = conteneurs;
	}

	public Conteneur addConteneur(Conteneur conteneur) {
		getConteneurs().add(conteneur);
		conteneur.setBibliotheque(this);

		return conteneur;
	}

	public Conteneur removeConteneur(Conteneur conteneur) {
		getConteneurs().remove(conteneur);
		conteneur.setBibliotheque(null);

		return conteneur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conteneurs == null) ? 0 : conteneurs.hashCode());
		result = prime * result + ((idBibliotheque == null) ? 0 : idBibliotheque.hashCode());
		result = prime * result + ((libelleBibliotheque == null) ? 0 : libelleBibliotheque.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bibliotheque other = (Bibliotheque) obj;
		if (conteneurs == null) {
			if (other.conteneurs != null)
				return false;
		} else if (!conteneurs.equals(other.conteneurs))
			return false;
		if (idBibliotheque == null) {
			if (other.idBibliotheque != null)
				return false;
		} else if (!idBibliotheque.equals(other.idBibliotheque))
			return false;
		if (libelleBibliotheque == null) {
			if (other.libelleBibliotheque != null)
				return false;
		} else if (!libelleBibliotheque.equals(other.libelleBibliotheque))
			return false;
		return true;
	}

}