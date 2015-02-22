package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Panne;

import com.sav.service.PanneService;







@ManagedBean(name = "panneBean")
@SessionScoped
public class PanneBean {

	private Integer idpanne;
	private String designationPan;
	
	
	
	
	private List<Panne> pannes = new ArrayList<Panne>(0);
	public Integer getIdpanne() {
		return idpanne;
	}




	public void setIdpanne(Integer idpanne) {
		this.idpanne = idpanne;
	}




	public String getDesignationPan() {
		return designationPan;
	}




	public void setDesignationPan(String designationPan) {
		this.designationPan = designationPan;
	}




	public List<Panne> getPannes() {
		PanneService ser = new PanneService();
		pannes = ser.rechercheTousPanne();
		return pannes;
	}




	public void setPannes(List<Panne> pannes) {
		this.pannes = pannes;
	}




	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}

	private String action;
	
	
	
	
	
	
	




	public void modifierPanne (Panne p) {
		action="modifier";
		System.out.println("id  "+idpanne);
		idpanne = p.getIdpanne();
		designationPan = p.getDesignationPan();
	
	}
		
		
		
		
	public void validation() {
		PanneService ser = new PanneService();
		Panne p = new Panne();
		p.setDesignationPan(designationPan);
		System.out.println(action);	
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			p.setIdpanne(idpanne);
			ser.modifierPanne(p);
		   }
	if (action.equals("ajouter"))
	
		
	
	   ser.ajouterPanne(p);
	   initialisation();
	}
	
	
	public void initialisation (){
		idpanne = null;
		designationPan = null;
		
	}
	
	public void ajouterPanne(){
	action="ajouter";
	initialisation();
	
	}

	public void Supprimer(Integer id) {
		PanneService ser = new PanneService();
		ser.supprimerPanne(id);
	}


}

	

	



	