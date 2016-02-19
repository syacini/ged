package com.ged.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the t_avoir_role database table.
 * 
 */
@Entity
@Table(name = "t_avoir_role")
@NamedQuery(name = "AvoirRole.findAll", query = "SELECT a FROM AvoirRole a")
public class AvoirRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AvoirRolePK id;

	public AvoirRole() {
	}

	public AvoirRolePK getId() {
		return this.id;
	}

	public void setId(AvoirRolePK id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AvoirRole other = (AvoirRole) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}