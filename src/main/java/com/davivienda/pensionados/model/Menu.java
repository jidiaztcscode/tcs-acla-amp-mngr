package com.davivienda.pensionados.model;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false)
    private String name;

    @ManyToOne
    private Menu parent; // null if top-level menu

    @OneToMany(mappedBy = "parent")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Menu> subMenus;

	public Set<Menu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(Set<Menu> subMenus) {
		this.subMenus = subMenus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}
	// getters and setters
}