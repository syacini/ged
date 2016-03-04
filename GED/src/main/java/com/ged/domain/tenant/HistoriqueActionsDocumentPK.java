package com.ged.domain.tenant;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The primary key class for the t_historique_actions_documents database table.
 * 
 */
@Embeddable
public class HistoriqueActionsDocumentPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	// uni-directional many-to-one association to Action
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ACTION", nullable = false, insertable = false, updatable = false)
	private Action action;

	// uni-directional many-to-one association to Utilisateur
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UTILISATEUR", nullable = false, insertable = false, updatable = false)
	private Utilisateur utilisateur;

	// uni-directional many-to-one association to Document
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DOCUMENT", nullable = false, insertable = false, updatable = false)
	private Document document;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_HEURE_ACTION", nullable = false, insertable = true, updatable = false)
	private Date dateHeureAction;
	
	public HistoriqueActionsDocumentPK() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
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
		HistoriqueActionsDocumentPK other = (HistoriqueActionsDocumentPK) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (utilisateur == null) {
			if (other.utilisateur != null)
				return false;
		} else if (!utilisateur.equals(other.utilisateur))
			return false;
		return true;
	}

}