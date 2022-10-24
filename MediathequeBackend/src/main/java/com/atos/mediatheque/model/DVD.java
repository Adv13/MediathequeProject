package com.atos.mediatheque.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.atos.mediatheque.controller.UsersViews;
import com.fasterxml.jackson.annotation.JsonView;

//import lombok.Data;

@Entity
//@Data
@Table(name = "DVD")
public class DVD extends Item{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1l;
	// clef de hachage SHA qui identifie de manière unique la classe
	
	@JsonView(UsersViews.OneUser.class)
	private String realisateur;
	
	@JsonView(UsersViews.OneUser.class)
	private int duree;
	
	@Enumerated(EnumType.STRING)
	@JsonView(UsersViews.OneUser.class)
	private TypeDVD type;
	
	
	public DVD() {
		super();
	}
	

	public DVD(String realisateur, int duree, TypeDVD type) {
		super();
		this.realisateur = realisateur;
		this.duree = duree;
		this.type = type;
	}
	

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public TypeDVD getType() {
		return type;
	}

	public void setType(TypeDVD type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	// Mot clef qui est utilisé pour définir
	// une méthode qui est héritée de la classe parente.
	// On ne l'utilise donc que dans le cas de l'héritage.
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(duree, realisateur, type);
		return result;
	}


	@Override
	// Mot clef qui est utilisé pour définir
	// une méthode qui est héritée de la classe parente.
	// On ne l'utilise donc que dans le cas de l'héritage.
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj)
			return true;
		if(!super.equals(obj))
			return false;
		if(getClass() !=obj.getClass())
			return false;
		DVD other = (DVD) obj;
		return duree == other.duree && Objects.equals(realisateur,  other.realisateur) && type == other.type;
	}
	
	
	
	
	
}
