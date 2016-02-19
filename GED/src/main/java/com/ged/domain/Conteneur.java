package com.ged.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_conteneur database table.
 * 
 */
@Entity
@Table(name="t_conteneur")
@NamedQuery(name="Conteneur.findAll", query="SELECT c FROM Conteneur c")
public class Conteneur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CONTENEUR", updatable=false, unique=true, nullable=false)
	private Integer idConteneur;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_HEURE_CLASSEMENT", nullable=false)
	private Date dateHeureClassement;

	@Column(name="LIBELLE_CONTENEUR", nullable=false, length=64)
	private String libelleConteneur;

	//bi-directional many-to-one association to Bibliotheque
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_BIBLIOTHEQUE")
	private Bibliotheque bibliotheque;

	//bi-directional many-to-one association to Conteneur
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CONTENEUR_PARENT")
	private Conteneur conteneurParent;

	//bi-directional many-to-one association to Conteneur
	@OneToMany(mappedBy="conteneurParent")
	private List<Conteneur> conteneursEnfants;

	//uni-directional many-to-one association to EmplacementPhysique
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_EMPLACEMENT", nullable=false)
	private EmplacementPhysique emplacementPhysique;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="conteneur")
	private List<Document> documents;

	public Conteneur() {
	}

	public Integer getIdConteneur() {
		return this.idConteneur;
	}

	public void setIdConteneur(Integer idConteneur) {
		this.idConteneur = idConteneur;
	}

	public Date getDateHeureClassement() {
		return this.dateHeureClassement;
	}

	public void setDateHeureClassement(Date dateHeureClassement) {
		this.dateHeureClassement = dateHeureClassement;
	}

	public String getLibelleConteneur() {
		return this.libelleConteneur;
	}

	public void setLibelleConteneur(String libelleConteneur) {
		this.libelleConteneur = libelleConteneur;
	}

	public Bibliotheque getBibliotheque() {
		return this.bibliotheque;
	}

	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}

	public Conteneur getConteneurParent() {
		return this.conteneurParent;
	}

	public void setConteneurParent(Conteneur conteneurParent) {
		this.conteneurParent = conteneurParent;
	}

	public List<Conteneur> getConteneursEnfants() {
		return this.conteneursEnfants;
	}

	public void setConteneursEnfants(List<Conteneur> conteneursEnfants) {
		this.conteneursEnfants = conteneursEnfants;
	}

	public Conteneur addConteneursEnfant(Conteneur conteneursEnfant) {
		getConteneursEnfants().add(conteneursEnfant);
		conteneursEnfant.setConteneurParent(this);

		return conteneursEnfant;
	}

	public Conteneur removeConteneursEnfant(Conteneur conteneursEnfant) {
		getConteneursEnfants().remove(conteneursEnfant);
		conteneursEnfant.setConteneurParent(null);

		return conteneursEnfant;
	}

	public EmplacementPhysique getEmplacementPhysique() {
		return this.emplacementPhysique;
	}

	public void setEmplacementPhysique(EmplacementPhysique emplacementPhysique) {
		this.emplacementPhysique = emplacementPhysique;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setConteneur(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setConteneur(null);

		return document;
	}

}