package com.ged.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_type_document database table.
 * 
 */
@Entity
@Table(name="t_type_document")
@NamedQuery(name="TypeDocument.findAll", query="SELECT t FROM TypeDocument t")
public class TypeDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TYPE_DOCUMENT", updatable=false, unique=true, nullable=false)
	private Integer idTypeDocument;

	@Column(name="CODE_TYPE_DOCUMENT", nullable=false)
	private Short codeTypeDocument;

	@Column(name="LIBELLE_TYPE_DOCUMENT", nullable=false, length=64)
	private String libelleTypeDocument;

	//bi-directional many-to-one association to TypeDocument
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_SUPER_TYPE")
	private TypeDocument typeDocumentParent;

	//bi-directional many-to-one association to TypeDocument
	@OneToMany(mappedBy="typeDocumentParent")
	private List<TypeDocument> typesDocumentsEnfants;

	public TypeDocument() {
	}

	public Integer getIdTypeDocument() {
		return this.idTypeDocument;
	}

	public void setIdTypeDocument(Integer idTypeDocument) {
		this.idTypeDocument = idTypeDocument;
	}

	public Short getCodeTypeDocument() {
		return this.codeTypeDocument;
	}

	public void setCodeTypeDocument(Short codeTypeDocument) {
		this.codeTypeDocument = codeTypeDocument;
	}

	public String getLibelleTypeDocument() {
		return this.libelleTypeDocument;
	}

	public void setLibelleTypeDocument(String libelleTypeDocument) {
		this.libelleTypeDocument = libelleTypeDocument;
	}

	public TypeDocument getTypeDocumentParent() {
		return this.typeDocumentParent;
	}

	public void setTypeDocumentParent(TypeDocument typeDocumentParent) {
		this.typeDocumentParent = typeDocumentParent;
	}

	public List<TypeDocument> getTypesDocumentsEnfants() {
		return this.typesDocumentsEnfants;
	}

	public void setTypesDocumentsEnfants(List<TypeDocument> typesDocumentsEnfants) {
		this.typesDocumentsEnfants = typesDocumentsEnfants;
	}

	public TypeDocument addTypesDocumentsEnfant(TypeDocument typesDocumentsEnfant) {
		getTypesDocumentsEnfants().add(typesDocumentsEnfant);
		typesDocumentsEnfant.setTypeDocumentParent(this);

		return typesDocumentsEnfant;
	}

	public TypeDocument removeTypesDocumentsEnfant(TypeDocument typesDocumentsEnfant) {
		getTypesDocumentsEnfants().remove(typesDocumentsEnfant);
		typesDocumentsEnfant.setTypeDocumentParent(null);

		return typesDocumentsEnfant;
	}

}