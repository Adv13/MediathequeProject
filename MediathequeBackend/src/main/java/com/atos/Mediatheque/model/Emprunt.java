package com.atos.Mediatheque.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.atos.Mediatheque.controller.EmpruntViews;
import com.atos.Mediatheque.controller.UsersViews;
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
	
	public Emprunt(long numero, User user, List<Item> items) {
		super();
		this.numero = numero;
		this.user = user;
		this.items = items;
	}
	

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
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
