package com.atos.mediatheque.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.atos.mediatheque.controller.EmpruntViews;
import com.atos.mediatheque.controller.UsersViews;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

//import lombok.Data;

@Entity
//@Data
public class Emprunt {

	/**
	 * 
	 */
	private static final long serielVersionUID = 659048648281019650L; //:-1
	// clef de hachage SHA qui identifie de manière unique la classe
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(UsersViews.OneUser.class)
	private long numero;
	
	private Date dateEmprunt;
	
	//@NotNull
	//@JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "yyyy-MM-dd")
	private Date dateRetour;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;
	
	@ManyToMany
	@JoinColumn(name="items_id")
	@JsonView(EmpruntViews.OneEmprunt.class)
	private List<Item> items;
	
	
	public Emprunt() {
		super();
	}
	
	public Emprunt(long numero, Date dateEmprunt, Date dateRetour, User user, List<Item> items) {
		super();
		this.numero = numero;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.user = user;
		this.items = items;
	}
	
	public Emprunt(User user, List<Item> items) {
		super();
		this.user = user;
		this.items = items;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date localDateTime) {
		this.dateRetour = localDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public static long getSerielversionuid() {
		return serielVersionUID;
	}	
	
}
