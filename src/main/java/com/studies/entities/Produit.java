package com.studies.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produit implements Serializable{

	
	
	@Id @GeneratedValue
	private Long id;
	@NotNull
	@Size(min=2, max=255)
	private String designation;
	@DecimalMin("100")
	private double prix;
	private int qte;
	
	public Produit(String designation, double prix, int qte) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.qte = qte;
	}

	public Produit() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}
	
	
	
	
}
