package com.atos.mediatheque.service;

import java.util.List;

import com.atos.mediatheque.model.Emprunt;
import com.atos.mediatheque.model.Item;
import com.atos.mediatheque.model.User;



public interface IMediatheque {

	public List<Item> consulterItem(); 
	public Emprunt effectuerEmprunt(User user, List<Item> items) throws Exception; 
//	public void restituerEmprunt(User user,  Emprunt emprunt); 
//	public List<Emprunt> visualiserEmprunt(User user,  Emprunt emprunt);   
	public void restituerEmprunt( Emprunt emprunt) throws Exception ;  

}
