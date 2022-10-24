package com.atos.Mediatheque.service;

import java.util.List;

import com.atos.Mediatheque.model.Emprunt;
import com.atos.Mediatheque.model.Item;
import com.atos.Mediatheque.model.User;



public interface IMediatheque {

	public Emprunt effectuerEmprunt(User user, List<Item> documents) throws Exception;  
	public void restituerEmprunt( Emprunt emprunt) throws Exception ;  

}
