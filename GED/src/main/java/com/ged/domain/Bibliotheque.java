package com.ged.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_bibliotheque database table.
 * 
 */
@Entity
@Table(name="t_bibliotheque")
@NamedQuery(name="Bibliotheque.findAll", query="SELECT b FROM Bibliotheque b")
public class Bibliotheque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_BIBLIOTHEQUE", updatable=false, unique=true, nullable=false)
	private Byte idBibliotheque;

	@Column(name="LIBELLE_BIBLIOTHEQUE", nullable=false, length=32)
	private String libelleBibliotheque;

	//bi-directional many-to-one association to Conteneur
	@OneToMany(mappedBy="bibliotheque")
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

}