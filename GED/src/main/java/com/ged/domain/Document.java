package com.ged.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the t_document database table.
 * 
 */
@Entity
@Table(name="t_document")
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DOCUMENT", updatable=false, unique=true, nullable=false)
	private Integer idDocument;

	@Lob
	@Column(name="CONTENU_DOCUMENT", nullable=false)
	private byte[] contenuDocument;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_HEURE_STATUT_DOCUMENT", nullable=false)
	private Date dateHeureStatutDocument;

	@Lob
	@Column(name="DESCRIPTION_DOCUMENT")
	private String descriptionDocument;

	@Column(name="LIBELLE_DOCUMENT", nullable=false, length=255)
	private String libelleDocument;

	@Column(name="TAILLE_DOCUMENT", nullable=false)
	private BigInteger tailleDocument;

	//uni-directional many-to-one association to Statut
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_STATUT", nullable=false)
	private Statut statut;

	//bi-directional many-to-one association to Conteneur
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CONTENEUR", nullable=false)
	private Conteneur conteneur;

	//uni-directional many-to-one association to TypeDocument
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_TYPE_DOCUMENT", nullable=false)
	private TypeDocument typeDocument;

	public Document() {
	}

	public Integer getIdDocument() {
		return this.idDocument;
	}

	public void setIdDocument(Integer idDocument) {
		this.idDocument = idDocument;
	}

	public byte[] getContenuDocument() {
		return this.contenuDocument;
	}

	public void setContenuDocument(byte[] contenuDocument) {
		this.contenuDocument = contenuDocument;
	}

	public Date getDateHeureStatutDocument() {
		return this.dateHeureStatutDocument;
	}

	public void setDateHeureStatutDocument(Date dateHeureStatutDocument) {
		this.dateHeureStatutDocument = dateHeureStatutDocument;
	}

	public String getDescriptionDocument() {
		return this.descriptionDocument;
	}

	public void setDescriptionDocument(String descriptionDocument) {
		this.descriptionDocument = descriptionDocument;
	}

	public String getLibelleDocument() {
		return this.libelleDocument;
	}

	public void setLibelleDocument(String libelleDocument) {
		this.libelleDocument = libelleDocument;
	}

	public BigInteger getTailleDocument() {
		return this.tailleDocument;
	}

	public void setTailleDocument(BigInteger tailleDocument) {
		this.tailleDocument = tailleDocument;
	}

	public Statut getStatut() {
		return this.statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Conteneur getConteneur() {
		return this.conteneur;
	}

	public void setConteneur(Conteneur conteneur) {
		this.conteneur = conteneur;
	}

	public TypeDocument getTypeDocument() {
		return this.typeDocument;
	}

	public void setTypeDocument(TypeDocument typeDocument) {
		this.typeDocument = typeDocument;
	}

}