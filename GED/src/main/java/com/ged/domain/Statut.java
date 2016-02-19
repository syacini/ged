package com.ged.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_statut database table.
 * 
 */
@Entity
@Table(name="t_statut")
@NamedQuery(name="Statut.findAll", query="SELECT s FROM Statut s")
public class Statut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_STATUT", updatable=false, unique=true, nullable=false)
	private Byte idStatut;

	@Column(name="CODE_STATUT", nullable=false)
	private Byte codeStatut;

	@Column(name="LIBELLE_STATUT", nullable=false, length=64)
	private String libelleStatut;

	public Statut() {
	}

	public Byte getIdStatut() {
		return this.idStatut;
	}

	public void setIdStatut(Byte idStatut) {
		this.idStatut = idStatut;
	}

	public Byte getCodeStatut() {
		return this.codeStatut;
	}

	public void setCodeStatut(Byte codeStatut) {
		this.codeStatut = codeStatut;
	}

	public String getLibelleStatut() {
		return this.libelleStatut;
	}

	public void setLibelleStatut(String libelleStatut) {
		this.libelleStatut = libelleStatut;
	}

}