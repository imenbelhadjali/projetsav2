package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Statut;

import com.sav.service.StatutService;







@ManagedBean(name = "statutBean")
@SessionScoped
public class StatutBean {

	private Integer idstatut;
	private String designationStat;
	
	
	
	
	private List<Statut> statuts = new ArrayList<Statut>(0);
	public Integer getIdstatut() {
		return idstatut;
	}




	public void setIdstatut(Integer idstatut) {
		this.idstatut = idstatut;
	}




	public String getDesignationStat() {
		return designationStat;
	}




	public void setDesignationStat(String designationStat) {
		this.designationStat = designationStat;
	}




	public List<Statut> getStatuts() {
		StatutService ser = new StatutService();
		statuts = ser.rechercheTousStatut();
		return statuts;
	}




	public void setStatuts(List<Statut> statuts) {
		this.statuts = statuts;
	}




	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}

	private String action;
	
	
	
	
	
	
	




	public void modifierStatut (Statut s) {
		action="modifier";
		System.out.println("id  "+idstatut);
		idstatut = s.getIdstatut();
		designationStat = s.getDesignationStat();
	
	}
		
		
		
		
	public void validation() {
		StatutService ser = new StatutService();
		Statut s = new Statut();
		s.setDesignationStat(designationStat);
		System.out.println(action);	
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			s.setIdstatut(idstatut);
			ser.modifierStatut(s);
		   }
	if (action.equals("ajouter"))
	
		
	
	   ser.ajouterStatut(s);
	   initialisation();
	}
	
	
	public void initialisation (){
		idstatut = null;
		designationStat = null;
		
	}
	
	public void ajouterStatut(){
	action="ajouter";
	initialisation();
	
	}

	public void Supprimer(Integer id) {
		StatutService ser = new StatutService();
		ser.supprimerStatut(id);
	}


}

	

	



	