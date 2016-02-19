package com.ged.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the t_historique_actions_documents database table.
 * 
 */
@Entity
@Table(name = "t_historique_actions_documents")
@NamedQuery(name = "HistoriqueActionsDocument.findAll", query = "SELECT h FROM HistoriqueActionsDocument h")
public class HistoriqueActionsDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HistoriqueActionsDocumentPK id;

	public HistoriqueActionsDocument() {
	}

	public HistoriqueActionsDocumentPK getId() {
		return this.id;
	}

	public void setId(HistoriqueActionsDocumentPK id) {
		this.id = id;
	}

}