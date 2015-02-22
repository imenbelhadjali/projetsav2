package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Accessoire;

import com.sav.service.AccessoireService;

@ManagedBean(name = "accessoireBean")
@SessionScoped
public class AccessoireBean {

	private Integer idaccessoire;
	private String designationAcc;
	
	
	
	
	private List<Accessoire> accessoires = new ArrayList<Accessoire>(0);
	public Integer getIdaccessoire() {
		return idaccessoire;
	}




	public void setIdaccessoire(Integer idaccessoire) {
		this.idaccessoire = idaccessoire;
	}




	public String getDesignationAcc() {
		return designationAcc;
	}




	public void setDesignationAcc(String designationAcc) {
		this.designationAcc = designationAcc;
	}




	public List<Accessoire> getAccessoires() {
		AccessoireService ser = new AccessoireService();
		accessoires = ser.rechercheTousAccessoire();
		return accessoires;
	}




	public void setAccessoires(List<Accessoire> accessoires) {
		this.accessoires = accessoires;
	}




	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}

	private String action;
	
	
	
	
	
	
	




	public void modifierAccessoire (Accessoire a) {
		action="modifier";
		System.out.println("id  "+idaccessoire);
		idaccessoire = a.getIdaccessoire();
		designationAcc = a.getDesignationAcc();
	
	}
		
		
		
		
	public void validation() {
		AccessoireService ser = new AccessoireService();
		Accessoire a = new Accessoire();
		a.setDesignationAcc(designationAcc);
		System.out.println(action);	
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			a.setIdaccessoire(idaccessoire);
			ser.modifierAccessoire(a);
		   }
	if (action.equals("ajouter"))
	
		
	
	   ser.ajouterAccessoire(a);
	   initialisation();
	}
	
	
	public void initialisation (){
		idaccessoire = null;
		designationAcc = null;
		
	}
	
	public void ajouterAccessoire(){
	action="ajouter";
	initialisation();
	
	}

	public void Supprimer(Integer id) {
		AccessoireService ser = new AccessoireService();
		ser.supprimerAccessoire(id);
	}


}

	

	



	