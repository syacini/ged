package com.ged.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_avoir_role database table.
 * 
 */
@Entity
@Table(name="t_avoir_role")
@NamedQuery(name="AvoirRole.findAll", query="SELECT a FROM AvoirRole a")
public class AvoirRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AvoirRolePK id;

	//uni-directional many-to-one association to Utilisateur
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_UTILISATEUR", nullable=false, insertable=false, updatable=false)
	private Utilisateur utilisateur;

	//uni-directional many-to-one association to Bibliotheque
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_BIBLIOTHEQUE", nullable=false, insertable=false, updatable=false)
	private Bibliotheque bibliotheque;

	//uni-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_ROLE", nullable=false, insertable=false, updatable=false)
	private Role role;

	public AvoirRole() {
	}

	public AvoirRolePK getId() {
		return this.id;
	}

	public void setId(AvoirRolePK id) {
		this.id = id;
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

}