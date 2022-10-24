package com.atos.mediatheque.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.atos.mediatheque.controller.UsersViews;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

//import lombok.Data;

@Entity
//@Data
@Inheritance(strategy=InheritanceType.JOINED) 
public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 659048648281019650L;//-1
	// clef de hachage SHA qui identifie de manière unique la classe
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(UsersViews.OneUser.class)
	private long id;
	
	@JsonView(UsersViews.OneUser.class)
	private String titre;
	
	@JsonView(UsersViews.OneUser.class)// ItemViews à créer plutot 
	private int nombreExemplaires;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonView(UsersViews.OneUser.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateParution;
	
	@ManyToMany(mappedBy="items", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Emprunt> emprunts = new HashSet<Emprunt>();
	
	
	public Item() {
		super();
	}
	
	
	public Item(long id, String titre, int nombreExemplaires, Date dateParution, Set<Emprunt> emprunts) {
		super();
		this.id = id;
		this.titre = titre;
		this.nombreExemplaires = nombreExemplaires;
		this.dateParution = dateParution;
		this.emprunts = emprunts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNombreExemplaires() {
		return nombreExemplaires;
	}

	public void setNombreExemplaires(int nombreExemplaires) {
		this.nombreExemplaires = nombreExemplaires;
	}

	public Date getDateParution() {
		return dateParution;
	}

	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@PrePersist
	private void onCreate() {
		dateParution = new Date(); 
		
	}
	
}
