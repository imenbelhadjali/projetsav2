package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Type;

import com.sav.service.TypeService;







@ManagedBean(name = "typeBean")
@SessionScoped
public class TypeBean {

	private Integer idtype;
	private String designationType;
	
	
	
	
	private List<Type> types = new ArrayList<Type>(0);
	public Integer getIdtype() {
		return idtype;
	}




	public void setIdtype(Integer idtype) {
		this.idtype = idtype;
	}




	public String getDesignationType() {
		return designationType;
	}




	public void setDesignationType(String designationType) {
		this.designationType = designationType;
	}




	public List<Type> getTypes() {
		TypeService ser = new TypeService();
		types = ser.rechercheTousType();
		return types;
	}




	public void setTypes(List<Type> types) {
		this.types = types;
	}




	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}

	private String action;
	
	
	
	
	
	
	




	public void modifierType (Type t) {
		action="modifier";
		System.out.println("id  "+idtype);
		idtype = t.getIdtype();
		designationType = t.getDesignationType();
	
	}
		
		
		
		
	public void validation() {
		TypeService ser = new TypeService();
		Type t = new Type();
		t.setDesignationType(designationType);
		System.out.println(action);	
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			t.setIdtype(idtype);
			ser.modifierType(t);
		   }
	if (action.equals("ajouter"))
	
		
	
	   ser.ajouterType(t);
	   initialisation();
	}
	
	
	public void initialisation (){
		idtype = null;
		designationType = null;
		
	}
	
	public void ajouterType(){
	action="ajouter";
	initialisation();
	
	}

	public void Supprimer(Integer id) {
		TypeService ser = new TypeService();
		ser.supprimerType(id);
	}


}

	

	



	