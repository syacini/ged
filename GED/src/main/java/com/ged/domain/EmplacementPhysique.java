package com.ged.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_emplacement_physique database table.
 * 
 */
@Entity
@Table(name="t_emplacement_physique")
@NamedQuery(name="EmplacementPhysique.findAll", query="SELECT e FROM EmplacementPhysique e")
public class EmplacementPhysique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EMPLACEMENT", updatable=false, unique=true, nullable=false)
	private Integer idEmplacement;

	@Column(name="LIBELLE_EMPLACEMENT", nullable=false, length=255)
	private String libelleEmplacement;

	public EmplacementPhysique() {
	}

	public Integer getIdEmplacement() {
		return this.idEmplacement;
	}

	public void setIdEmplacement(Integer idEmplacement) {
		this.idEmplacement = idEmplacement;
	}

	public String getLibelleEmplacement() {
		return this.libelleEmplacement;
	}

	public void setLibelleEmplacement(String libelleEmplacement) {
		this.libelleEmplacement = libelleEmplacement;
	}

}