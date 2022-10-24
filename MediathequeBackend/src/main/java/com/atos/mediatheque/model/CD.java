package com.atos.mediatheque.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.atos.mediatheque.controller.UsersViews;
import com.fasterxml.jackson.annotation.JsonView;

//import lombok.Data;

@Entity
//@Data
@Table(name = "CD")
public class CD extends Item {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1l;
	// clef de hachage SHA qui identifie de manière unique la classe
	
	@JsonView(UsersViews.OneUser.class)
	private String artiste_groupe;
	
	@JsonView(UsersViews.OneUser.class)
	private int duree;
	
	@JsonView(UsersViews.OneUser.class)
	private int nombreTitre;

	
	public CD() {
		super();
	}
	
	
	public CD(String artiste_groupe, int duree, int nombreTitre) {
		super();
		this.artiste_groupe = artiste_groupe;
		this.duree = duree;
		this.nombreTitre = nombreTitre;
	}
	

	public String getArtiste_groupe() {
		return artiste_groupe;
	}

	public void setArtiste_groupe(String artiste_groupe) {
		this.artiste_groupe = artiste_groupe;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getNombreTitre() {
		return nombreTitre;
	}

	public void setNombreTitre(int nombreTitre) {
		this.nombreTitre = nombreTitre;
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
		result = prime * result + Objects.hash(artiste_groupe, duree, nombreTitre);
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
		CD other = (CD) obj;
		return Objects.equals(artiste_groupe,  other.artiste_groupe) && duree == other.duree && nombreTitre == other.nombreTitre; 
	}
	
	
	
	
}
