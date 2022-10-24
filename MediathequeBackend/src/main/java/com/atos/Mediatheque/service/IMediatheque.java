package com.atos.Mediatheque.service;

import java.util.List;

import com.atos.Mediatheque.model.Emprunt;
import com.atos.Mediatheque.model.Item;
import com.atos.Mediatheque.model.User;



public interface IMediatheque {

	public List<Item> consulterItem(); 
	public Emprunt effectuerEmprunt(User user, List<Item> items) throws Exception; 
//	public void restituerEmprunt(User user,  Emprunt emprunt); 
//	public List<Emprunt> visualiserEmprunt(User user,  Emprunt emprunt);   
	public void restituerEmprunt( Emprunt emprunt) throws Exception ;  

}
