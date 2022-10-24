package com.atos.mediatheque.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.atos.mediatheque.controller.UsersViews;
import com.fasterxml.jackson.annotation.JsonView;

//import lombok.Data;

@Entity
//@Data
@Table(name = "Livre")
public class Livre extends Item {

	/**
	 * 
	 */
	private static final long serielVersionUID = 1l;
	// clef de hachage SHA qui identifie de manière unique la classe
	
	@JsonView(UsersViews.OneUser.class)
	private String ecrivain;
	
	@JsonView(UsersViews.OneUser.class)
	private long numeroIsbn; //International Standard Book Number 

	
	public Livre() {
		super();
	}
	
	
	public Livre(String ecrivain, long numeroIsbn) {
		super();
		this.ecrivain = ecrivain;
		this.numeroIsbn = numeroIsbn;
	}

	public String getEcrivain() {
		return ecrivain;
	}

	public void setEcrivain(String ecrivain) {
		this.ecrivain = ecrivain;
	}

	public long getNumeroIsbn() {
		return numeroIsbn;
	}

	public void setNumeroIsbn(long numeroIsbn) {
		this.numeroIsbn = numeroIsbn;
	}

	public static long getSerielversionuid() {
		return serielVersionUID;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ecrivain, numeroIsbn);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj)
			return true;
		if(!super.equals(obj))
			return false;
		if(getClass() !=obj.getClass())
			return false;
		Livre other = (Livre) obj;
			return Objects.equals(ecrivain,  other.ecrivain) && numeroIsbn == other.numeroIsbn; 
	}
	
	
	
	
	
}
