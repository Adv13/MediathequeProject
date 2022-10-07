package com.atos.Mediatheque.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.atos.Mediatheque.controller.UsersViews;
import com.fasterxml.jackson.annotation.JsonView;

//import lombok.Data;

@Entity
//@Data
@Table(name = "Users")
public class User {
	/**
	 * 
	 */
	private static final long serielVersionUID = 1l;
	// clef de hachage SHA qui identifie de manière unique la classe
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(UsersViews.AllUsers.class)
	private long id;
	
	//@NotNull
	@JsonView(UsersViews.AllUsers.class)
	private String login, password;
	
	@JsonView(UsersViews.AllUsers.class)
	private String nom;
	@JsonView(UsersViews.AllUsers.class)
	private String prenom;
	
	@OneToMany(mappedBy = "user")
	@JsonView(UsersViews.OneUser.class)
	private List<Emprunt> emprunts = new ArrayList<Emprunt>();
	
	
	public User() {
		super();
	}
	

	public User(long id, String login, String password, String nom, String prenom, List<Emprunt> emprunts) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.emprunts = emprunts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public static long getSerielversionuid() {
		return serielVersionUID;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id^(id>>>32));
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
		User other = (User) obj;
		return id == other.id;
	}
	
	
	
}
