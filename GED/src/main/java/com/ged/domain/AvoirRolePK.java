package com.ged.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The primary key class for the t_avoir_role database table.
 * 
 */
@Embeddable
public class AvoirRolePK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	// uni-directional many-to-one association to Utilisateur
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UTILISATEUR", nullable = false, insertable = false, updatable = false)
	private Utilisateur utilisateur;

	// uni-directional many-to-one association to Bibliotheque
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BIBLIOTHEQUE", nullable = false, insertable = false, updatable = false)
	private Bibliotheque bibliotheque;

	// uni-directional many-to-one association to Role
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ROLE", nullable = false, insertable = false, updatable = false)
	private Role role;

	public AvoirRolePK() {
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Bibliotheque getBibliotheque() {
		return this.bibliotheque;
	}

	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bibliotheque == null) ? 0 : bibliotheque.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((utilisateur == null) ? 0 : utilisateur.hashCode());
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
		AvoirRolePK other = (AvoirRolePK) obj;
		if (bibliotheque == null) {
			if (other.bibliotheque != null)
				return false;
		} else if (!bibliotheque.equals(other.bibliotheque))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (utilisateur == null) {
			if (other.utilisateur != null)
				return false;
		} else if (!utilisateur.equals(other.utilisateur))
			return false;
		return true;
	}

}