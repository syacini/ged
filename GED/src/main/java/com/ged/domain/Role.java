package com.ged.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the t_role database table.
 * 
 */
@Entity
@Table(name = "t_role")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROLE", updatable = false, unique = true, nullable = false)
	private Byte idRole;

	@Column(name = "LIBELLE_ROLE", nullable = false, length = 32)
	private String libelleRole;

	// uni-directional many-to-many association to Action
	@ManyToMany
	@JoinTable(name = "t_avoir_habilitation", joinColumns = {
			@JoinColumn(name = "ID_ROLE", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_ACTION", nullable = false) })
	private List<Action> actions;

	public Role() {
	}

	public Byte getIdRole() {
		return this.idRole;
	}

	public void setIdRole(Byte idRole) {
		this.idRole = idRole;
	}

	public String getLibelleRole() {
		return this.libelleRole;
	}

	public void setLibelleRole(String libelleRole) {
		this.libelleRole = libelleRole;
	}

	public List<Action> getActions() {
		return this.actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actions == null) ? 0 : actions.hashCode());
		result = prime * result + ((idRole == null) ? 0 : idRole.hashCode());
		result = prime * result + ((libelleRole == null) ? 0 : libelleRole.hashCode());
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
		Role other = (Role) obj;
		if (actions == null) {
			if (other.actions != null)
				return false;
		} else if (!actions.equals(other.actions))
			return false;
		if (idRole == null) {
			if (other.idRole != null)
				return false;
		} else if (!idRole.equals(other.idRole))
			return false;
		if (libelleRole == null) {
			if (other.libelleRole != null)
				return false;
		} else if (!libelleRole.equals(other.libelleRole))
			return false;
		return true;
	}
}