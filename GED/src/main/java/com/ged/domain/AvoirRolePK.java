package com.ged.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the t_avoir_role database table.
 * 
 */
@Embeddable
public class AvoirRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_UTILISATEUR", insertable=false, updatable=false, unique=true, nullable=false)
	private byte idUtilisateur;

	@Column(name="ID_BIBLIOTHEQUE", insertable=false, updatable=false, unique=true, nullable=false)
	private byte idBibliotheque;

	@Column(name="ID_ROLE", insertable=false, updatable=false, unique=true, nullable=false)
	private byte idRole;

	public AvoirRolePK() {
	}
	public byte getIdUtilisateur() {
		return this.idUtilisateur;
	}
	public void setIdUtilisateur(byte idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public byte getIdBibliotheque() {
		return this.idBibliotheque;
	}
	public void setIdBibliotheque(byte idBibliotheque) {
		this.idBibliotheque = idBibliotheque;
	}
	public byte getIdRole() {
		return this.idRole;
	}
	public void setIdRole(byte idRole) {
		this.idRole = idRole;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AvoirRolePK)) {
			return false;
		}
		AvoirRolePK castOther = (AvoirRolePK)other;
		return 
			(this.idUtilisateur == castOther.idUtilisateur)
			&& (this.idBibliotheque == castOther.idBibliotheque)
			&& (this.idRole == castOther.idRole);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.idUtilisateur);
		hash = hash * prime + ((int) this.idBibliotheque);
		hash = hash * prime + ((int) this.idRole);
		
		return hash;
	}
}