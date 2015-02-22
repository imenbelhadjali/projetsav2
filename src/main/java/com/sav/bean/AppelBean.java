package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Appel;
import com.sav.service.AppelService;








@ManagedBean(name = "appelBean")
@SessionScoped
public class AppelBean {

	private Integer idappel;
	private String numapp;
	private String emplacement;
	private String mdpbios;
	private String mdpsys;
	private String dosier_sauvegarde;
	private String observationApl;
	private String date_entre;
	private String etat;
	
	
	
	
	
	
	
	
	
	private List<Appel> appels = new ArrayList<Appel>(0);
	private String action;
	
	
	
	
	
	
	
	public Integer getIdappel() {
		return idappel;
	}




	public void setIdappel(Integer idappel) {
		this.idappel = idappel;
	}




	public String getNumapp() {
		return numapp;
	}




	public void setNumapp (String numapp) {
		this.numapp = numapp;
	}




	public String getEmplacement() {
		return emplacement;
	}




	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}




	public String getMdpbios() {
		return mdpbios;
	}




	public void setMdpbios(String mdpbios) {
		this.mdpbios = mdpbios;
	}




	public String getMdpsys() {
		return mdpsys;
	}




	public void setMdpsys(String mdpsys) {
		this.mdpsys = mdpsys;
	}




	public String getDosier_sauvegarde() {
		return dosier_sauvegarde;
	}




	public void setDosier_sauvegarde(String dosier_sauvegarde) {
		this.dosier_sauvegarde = dosier_sauvegarde;
	}




	public String getObservationApl() {
		return observationApl;
	}




	public void setObservationApl(String observationApl) {
		this.observationApl = observationApl;
	}




	public String getDate_entre() {
		return date_entre;
	}




	public void setDate_entre(String date_entre) {
		this.date_entre = date_entre;
	}




	public String getEtat() {
		return etat;
	}




	public void setEtat(String etat) {
		this.etat = etat;
	}




	public List<Appel> getAppels() {
		AppelService ser = new AppelService();
		appels = ser.rechercheTousAppel();
		return appels;
	}




	public void setAppels(List<Appel> appels) {
		this.appels = appels;
	}







	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}




	public void modifierAppel (Appel A) {
		action="modifier";
		System.out.println("id  "+idappel);
		idappel = A.getIdappel();
		numapp = A.getNumapp();
		emplacement = A.getEmplacement();
		mdpbios = A.getMdpbios();
		mdpsys = A.getMdpsys();
		dosier_sauvegarde = A.getDosier_sauvegarde();
		observationApl = A.getObservationApl();
		date_entre = A.getDate_entre();
		etat = A.getEtat();
	
	}
		
		
		
		
	public void validation() {
		AppelService ser = new AppelService();
		Appel A = new Appel();
		A.setNumapp(numapp);
		A.setEmplacement(emplacement);
		A.setMdpbios(mdpbios);
		A.setMdpsys(mdpsys);
		A.setDosier_sauvegarde(dosier_sauvegarde);
		A.setObservationApl(observationApl);
		A.setEtat(etat);
		A.setDate_entre(date_entre);
		
		
		System.out.println(action);	
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			A.setIdappel(idappel);
			ser.modifierAppel(A);
		   }
	if (action.equals("ajouter"))
	  ser.ajouterAppel(A);
	   initialisation();
	}
	
	public void initialisation (){
		idappel = null;
		emplacement = null;
		numapp = null;
		mdpbios = null;
		mdpsys = null;
		dosier_sauvegarde = null;
		observationApl = null;
		}
	
	
	public void ajouterAppel(){
	action="ajouter";
	initialisation();
	
	}

	public void Supprimer(Integer id) {
		AppelService ser = new AppelService();
		ser.supprimerAppel(id);
	}


}

	

	



	