package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Tache;

import com.sav.service.TacheService;







@ManagedBean(name = "tacheBean")
@SessionScoped
public class TacheBean {

	private Integer idtache;
	private String designationTach;
	private String prixTach;
	
	
	
	
	private List<Tache> taches = new ArrayList<Tache>(0);
	public Integer getIdtache() {
		return idtache;
	}


	
	


	public String getPrixTach() {
		return prixTach;
	}






	public void setPrixTach(String prixTach) {
		this.prixTach = prixTach;
	}






	public void setIdtache(Integer idtache) {
		this.idtache = idtache;
	}




	public String getDesignationTach() {
		return designationTach;
	}




	public void setDesignationTach(String designationTach) {
		this.designationTach = designationTach;
	}




	public List<Tache> getTaches() {
		TacheService ser = new TacheService();
		taches = ser.rechercheTousTache();
		return taches;
	}




	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}




	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}

	private String action;
	
	
	
	
	
	
	




	public void modifierTache (Tache T) {
		action="modifier";
		System.out.println("id  "+idtache);
		idtache = T.getIdtache();
		designationTach = T.getDesignationTach();
		prixTach = T.getPrixTach();
	
	}
		
		
		
		
	public void validation() {
		TacheService ser = new TacheService();
		Tache T = new Tache();
		T.setDesignationTach(designationTach);
		System.out.println(action);	
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			T.setIdtache(idtache);
			ser.modifierTache(T);
		   }
	if (action.equals("ajouter"))
	
		
	
	   ser.ajouterTache(T);
	   initialisation();
	}
	
	
	public void initialisation (){
		idtache = null;
		designationTach = null;
		prixTach = null;
		
	}
	
	public void ajouterTache(){
	action="ajouter";
	initialisation();
	
	}

	public void Supprimer(Integer id) {
		TacheService ser = new TacheService();
		ser.supprimerTache(id);
	}


}

	

	



	