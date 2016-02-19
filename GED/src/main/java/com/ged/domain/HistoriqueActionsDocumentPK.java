package com.ged.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the t_historique_actions_documents database table.
 * 
 */
@Embeddable
public class HistoriqueActionsDocumentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ACTION", insertable=false, updatable=false, unique=true, nullable=false)
	private byte idAction;

	@Column(name="ID_UTILISATEUR", insertable=false, updatable=false, unique=true, nullable=false)
	private byte idUtilisateur;

	@Column(name="ID_DOCUMENT", insertable=false, updatable=false, unique=true, nullable=false)
	private int idDocument;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_HEURE_ACTION", unique=true, nullable=false)
	private java.util.Date dateHeureAction;

	public HistoriqueActionsDocumentPK() {
	}
	public byte getIdAction() {
		return this.idAction;
	}
	public void setIdAction(byte idAction) {
		this.idAction = idAction;
	}
	public byte getIdUtilisateur() {
		return this.idUtilisateur;
	}
	public void setIdUtilisateur(byte idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public int getIdDocument() {
		return this.idDocument;
	}
	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}
	public java.util.Date getDateHeureAction() {
		return this.dateHeureAction;
	}
	public void setDateHeureAction(java.util.Date dateHeureAction) {
		this.dateHeureAction = dateHeureAction;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HistoriqueActionsDocumentPK)) {
			return false;
		}
		HistoriqueActionsDocumentPK castOther = (HistoriqueActionsDocumentPK)other;
		return 
			(this.idAction == castOther.idAction)
			&& (this.idUtilisateur == castOther.idUtilisateur)
			&& (this.idDocument == castOther.idDocument)
			&& this.dateHeureAction.equals(castOther.dateHeureAction);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.idAction);
		hash = hash * prime + ((int) this.idUtilisateur);
		hash = hash * prime + this.idDocument;
		hash = hash * prime + this.dateHeureAction.hashCode();
		
		return hash;
	}
}