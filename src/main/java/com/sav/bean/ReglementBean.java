package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Reglement;

import com.sav.service.ReglementService;







@ManagedBean(name = "reglementBean")
@SessionScoped
public class ReglementBean {

	private Integer idreglement;
	private String totaltache;
	private String prixReg;
	private String totalpiece;
	private String totalrep;
	private String datesortie;
	private String observationReg;
	
	
	
	
	private List<Reglement> reglements = new ArrayList<Reglement>(0);
	private String action;
	
	
	
	
	
	
	public String getTotaltache() {
		return totaltache;
	}



	public void setTotaltache(String totaltache) {
		this.totaltache = totaltache;
	}



	public String getPrixReg() {
		return prixReg;
	}



	public void setPrixReg(String prixReg) {
		this.prixReg = prixReg;
	}



	public String getTotalpiece() {
		return totalpiece;
	}



	public void setTotalpiece(String totalpiece) {
		this.totalpiece = totalpiece;
	}



	public String getTotalrep() {
		return totalrep;
	}



	public void setTotalrep(String totalrep) {
		this.totalrep = totalrep;
	}



	public String getDatesortie() {
		return datesortie;
	}



	public void setDatesortie(String datesortie) {
		this.datesortie = datesortie;
	}



	public String getObservationReg() {
		return observationReg;
	}



	public void setObservationReg(String observationReg) {
		this.observationReg = observationReg;
	}



	public Integer getIdreglement() {
		return idreglement;
	}


	
	public void setIdreglement(Integer idreglement) {
		this.idreglement = idreglement;
	}









	public List<Reglement> getReglements() {
		ReglementService ser = new ReglementService();
		reglements = ser.rechercheTousReglement();
		return reglements;
	}




	public void setReglements(List<Reglement> reglements) {
		this.reglements = reglements;
	}




	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}

	
	
	
	
	
	
	
	




	public void modifierReglement (Reglement r) {
		action="modifier";
		System.out.println("id  "+idreglement);
		idreglement = r.getIdreglement();
		prixReg = r.getPrixReg();
		totaltache = r.getTotaltache();
		totalpiece = r.getTotalpiece();
		totalrep = r.getTotalrep();
		datesortie = r.getDatesortie();
		observationReg = r.getObservationReg();
		
	
	}
		
		
		
		
	public void validation() {
		ReglementService ser = new ReglementService();
		Reglement r = new Reglement();
		r.setPrixReg(prixReg);
		r.setTotaltache(totaltache);
		r.setTotalpiece(totalpiece);
		r.setTotalrep(totalrep);
		r.setDatesortie(datesortie);
		r.setObservationReg(observationReg);
		System.out.println(action);	
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			r.setIdreglement(idreglement);
			ser.modifierReglement(r);
		   }
	if (action.equals("ajouter"))
	
		
	
	   ser.ajouterReglement(r);
	   initialisation();
	}
	
	
	public void initialisation (){
		idreglement = null;
		prixReg = null;
		totaltache = null;
		totalpiece = null;
		totaltache = null;
		totalrep = null;
		datesortie = null;
		observationReg = null;
		
	}
	
	public void ajouterReglement(){
	action="ajouter";
	initialisation();
	
	}

	public void Supprimer(Integer id) {
		ReglementService ser = new ReglementService();
		ser.supprimerReglement(id);
	}


}

	

	



	