package com.exp.dynamicroles.model;
 

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "action")
public class Action implements java.io.Serializable {
 
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Set<RoleAction> roleActions = new HashSet<RoleAction>(0);

	public Action() {
	}

	public Action(String name, Set<RoleAction> roleActions) {
		this.name = name;
		this.roleActions = roleActions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "action")
	public Set<RoleAction> getRoleActions() {
		return this.roleActions;
	}

	public void setRoleActions(Set<RoleAction> roleActions) {
		this.roleActions = roleActions;
	}

}
