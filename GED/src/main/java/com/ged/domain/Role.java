package com.ged.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_role database table.
 * 
 */
@Entity
@Table(name="t_role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ROLE", updatable=false, unique=true, nullable=false)
	private Byte idRole;

	@Column(name="LIBELLE_ROLE", nullable=false, length=32)
	private String libelleRole;

	//uni-directional many-to-many association to Action
	@ManyToMany
	@JoinTable(
		name="t_avoir_habilitation"
		, joinColumns={
			@JoinColumn(name="ID_ROLE", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_ACTION", nullable=false)
			}
		)
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

}