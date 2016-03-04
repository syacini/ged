package com.ged.domain.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_user table on the master database.
 * 
 */
@Entity
@Table(name="t_user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer id;

	@Lob
	@Column(nullable=false)
	private String password;

	@Column(name="USER_EMAIL", nullable=false, length=128)
	private String email;

	@Column(name="USER_ENABLED", nullable=false)
	private Boolean enabled;

	@Column(name="USER_FIRST_NAME", nullable=false, length=32)
	private String firstName;

	@Column(name="USER_LAST_NAME", nullable=false, length=32)
	private String lastName;

	@Column(nullable=false, length=8)
	private String username;

	//uni-directional many-to-one association to Organization
	@ManyToOne
	@JoinColumn(name="ORGANISATION_ID", nullable=false)
	private Organization Organization;

	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Organization getOrganization() {
		return this.Organization;
	}

	public void setOrganization(Organization Organization) {
		this.Organization = Organization;
	}

}