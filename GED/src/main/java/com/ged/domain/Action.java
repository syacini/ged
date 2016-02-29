package com.ged.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ged.exception.ValidationException;

/**
 * The persistent class for the t_action database table.
 * 
 */
@Entity
@Table(name = "t_action")
@NamedQuery(name = "Action.findAll", query = "SELECT a FROM Action a")
public class Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACTION", updatable = false, unique = true, nullable = false)
	private Byte idAction;

	@Column(name = "LIBELLE_ACTION", nullable = false, length = 32)
	private String libelleAction;

	public Action() {
	}

	public Byte getIdAction() {
		return this.idAction;
	}

	public void setIdAction(Byte idAction) {
		this.idAction = idAction;
	}

	public String getLibelleAction() {
		return this.libelleAction;
	}

	public void setLibelleAction(String libelleAction) {
		this.libelleAction = libelleAction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAction == null) ? 0 : idAction.hashCode());
		result = prime * result + ((libelleAction == null) ? 0 : libelleAction.hashCode());
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
		Action other = (Action) obj;
		if (idAction == null) {
			if (other.idAction != null)
				return false;
		} else if (!idAction.equals(other.idAction))
			return false;
		if (libelleAction == null) {
			if (other.libelleAction != null)
				return false;
		} else if (!libelleAction.equals(other.libelleAction))
			return false;
		return true;
	}

//	@PrePersist
//	@PreUpdate
//	@ExceptionHandler({ValidationException.class})
//	private void validerDonnees() {
//		if (libelleAction == null || "".equals(libelleAction)) {
//			throw new ValidationException("ACTION : Libellé vide.");
//		}
//	}
}