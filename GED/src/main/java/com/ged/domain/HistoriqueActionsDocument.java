package com.ged.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_historique_actions_documents database table.
 * 
 */
@Entity
@Table(name="t_historique_actions_documents")
@NamedQuery(name="HistoriqueActionsDocument.findAll", query="SELECT h FROM HistoriqueActionsDocument h")
public class HistoriqueActionsDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HistoriqueActionsDocumentPK id;

	//uni-directional many-to-one association to Action
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_ACTION", nullable=false, insertable=false, updatable=false)
	private Action action;

	//uni-directional many-to-one association to Utilisateur
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_UTILISATEUR", nullable=false, insertable=false, updatable=false)
	private Utilisateur utilisateur;

	//uni-directional many-to-one association to Document
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_DOCUMENT", nullable=false, insertable=false, updatable=false)
	private Document document;

	public HistoriqueActionsDocument() {
	}

	public HistoriqueActionsDocumentPK getId() {
		return this.id;
	}

	public void setId(HistoriqueActionsDocumentPK id) {
		this.id = id;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}