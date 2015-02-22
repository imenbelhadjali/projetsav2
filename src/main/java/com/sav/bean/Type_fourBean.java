package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Type_four;

import com.sav.service.Type_fourService;







@ManagedBean(name = "type_fourBean")
@SessionScoped
public class Type_fourBean {

	private Integer idtype_four;
	private String nomtype_four;
	
	
	
	
	private List<Type_four> type_fours = new ArrayList<Type_four>(0);
	public Integer getIdtype_four() {
		return idtype_four;
	}




	public void setIdtype_four(Integer idtype_four) {
		this.idtype_four = idtype_four;
	}




	public String getNomtype_four() {
		return nomtype_four;
	}




	public void setNomtype_four(String nomtype_four) {
		this.nomtype_four = nomtype_four;
	}




	public List<Type_four> getType_fours() {
		Type_fourService ser = new Type_fourService();
		type_fours = ser.rechercheTousType_four();
		return type_fours;
	}




	public void setType_fours(List<Type_four> type_fours) {
		this.type_fours = type_fours;
	}




	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}

	private String action;
	
	
	
	
	
	
	




	public void modifierType_four (Type_four tf) {
		action="modifier";
		System.out.println("id  "+idtype_four);
		idtype_four = tf.getIdtype_four();
		nomtype_four = tf.getNomtype_four();
	
	}
		
		
		
		
	public void validation() {
		Type_fourService ser = new Type_fourService();
		Type_four tf = new Type_four();
		tf.setNomtype_four(nomtype_four);
		System.out.println(action);	
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			tf.setIdtype_four(idtype_four);
			ser.modifierType_four(tf);
		   }
	if (action.equals("ajouter"))
	
		
	
	   ser.ajouterType_four(tf);
	   initialisation();
	}
	
	
	public void initialisation (){
		idtype_four = null;
		nomtype_four = null;
		
	}
	
	public void ajouterType_four(){
	action="ajouter";
	initialisation();
	
	}

	public void Supprimer(Integer id) {
		Type_fourService ser = new Type_fourService();
		ser.supprimerType_four(id);
	}


}

	

	



	