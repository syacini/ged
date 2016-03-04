package com.ged.domain.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the t_organization table on the master database.
 * 
 */
@Entity
@Table(name = "t_organization")
@NamedQuery(name = "Organization.findAll", query = "SELECT o FROM Organization o")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORGANISATION_ID", insertable = false, updatable = false, unique = true, nullable = false)
	private Integer id;

	@Lob
	@Column(name = "ORGANIZATION_DESCRIPTION")
	private String description;

	@Column(name = "ORGANIZATION_ENABLED", nullable = false)
	private Boolean enabled;

	@Column(name = "ORGANIZATION_NAME", nullable = false, length = 32)
	private String name;

	@Column(name = "ORGANIZATION_KEY", nullable = false, length = 32)
	private String organizationKey;

	public Organization() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganizationKey() {
		return organizationKey;
	}

	public void setOrganizationKey(String organizationKey) {
		this.organizationKey = organizationKey;
	}

}