package com.ged.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_action database table.
 * 
 */
@Entity
@Table(name="t_action")
@NamedQuery(name="Action.findAll", query="SELECT a FROM Action a")
public class Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ACTION", updatable=false, unique=true, nullable=false)
	private Byte idAction;

	@Column(name="LIBELLE_ACTION", nullable=false, length=32)
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

}