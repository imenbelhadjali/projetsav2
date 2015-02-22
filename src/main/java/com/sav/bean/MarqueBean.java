package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Marque;

import com.sav.service.MarqueService;







@ManagedBean(name = "marqueBean")
@SessionScoped
public class MarqueBean {

	private Integer idmarque;
	private String designationMarq;
	
	
	
	
	private List<Marque> marques = new ArrayList<Marque>(0);
	public Integer getIdmarque() {
		return idmarque;
	}




	public void setIdmarque(Integer idmarque) {
		this.idmarque = idmarque;
	}




	public String getDesignationMarq() {
		return designationMarq;
	}




	public void setDesignationMarq(String designationMarq) {
		this.designationMarq = designationMarq;
	}




	public List<Marque> getMarques() {
		MarqueService ser = new MarqueService();
		marques = ser.rechercheTousMarque();
		return marques;
	}




	public void setMarques(List<Marque> marques) {
		this.marques = marques;
	}




	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}

	private String action;
	
	
	
	
	
	
	




	public void modifierMarque (Marque M) {
		action="modifier";
		System.out.println("id  "+idmarque);
		idmarque = M.getIdmarque();
		designationMarq = M.getDesignationMarq();
	
	}
		
		
		
		
	public void validation() {
		MarqueService ser = new MarqueService();
		Marque M = new Marque();
		M.setDesignationMarq(designationMarq);
		System.out.println(action);	
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			M.setIdmarque(idmarque);
			ser.modifierMarque(M);
		   }
	if (action.equals("ajouter"))
	
		
	
	   ser.ajouterMarque(M);
	   initialisation();
	}
	
	
	public void initialisation (){
		idmarque = null;
		designationMarq = null;
		
	}
	
	public void ajouterMarque(){
	action="ajouter";
	initialisation();
	
	}

	public void Supprimer(Integer id) {
		MarqueService ser = new MarqueService();
		ser.supprimerMarque(id);
	}


}

	

	



	