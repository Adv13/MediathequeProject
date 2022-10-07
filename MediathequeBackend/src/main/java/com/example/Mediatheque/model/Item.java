package com.example.Mediatheque.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.Mediatheque.controller.UsersViews;
import com.fasterxml.jackson.annotation.JsonView;


public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 659048648281019650L;//-1
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(UsersViews.OneUser.class)
	private long id;
	
	@JsonView(UsersViews.OneUser.class)
	private String titre;
	
	@JsonView(UsersViews.OneUser.class)
	private int nombreExemplaires;
	
	
}
