package com.ged.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_utilisateur database table.
 * 
 */
@Entity
@Table(name="t_utilisateur")
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_UTILISATEUR", updatable=false, unique=true, nullable=false)
	private Byte idUtilisateur;

	@Column(nullable=false, length=128)
	private String email;

	@Column(nullable=false, length=32)
	private String nom;

	@Lob
	@Column(nullable=false)
	private String password;

	@Column(nullable=false, length=32)
	private String prenom;

	@Column(nullable=false, length=8)
	private String username;

	public Utilisateur() {
	}

	public Byte getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(Byte idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}