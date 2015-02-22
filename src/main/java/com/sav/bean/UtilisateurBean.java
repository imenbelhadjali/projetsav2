package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Utilisateur;
import com.sav.service.UtilisateurService;

@ManagedBean(name = "utilisateurBean")
@SessionScoped
public class UtilisateurBean {

	private Integer idutilisateur;
	private String nomUtl;
	private String prenomUtl;
	private String adrUtl;
	private String mailUtl;
	private String gsm1Utl;
	private String gsm2Utl;
	private String telUtl;
	private String cinUtl;
	private String login;
	private String motPass;
	private String grade;
	
	
	
	
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>(0);
	private String action;
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getIdutilisateur() {
		return idutilisateur;
	}

	public void setIdutilisateur(Integer idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public String getNomUtl() {
		return nomUtl;
	}

	public void setNomUtl(String nomUtl) {
		this.nomUtl = nomUtl;
	}

	public String getPrenomUtl() {
		return prenomUtl;
	}

	public void setPrenomUtl(String prenomUtl) {
		this.prenomUtl = prenomUtl;
	}

	public String getAdrUtl() {
		return adrUtl;
	}

	public void setAdrUtl(String adrUtl) {
		this.adrUtl = adrUtl;
	}

	public String getMailUtl() {
		return mailUtl;
	}
	public void setMailUtl(String mailUtl) {
		this.mailUtl = mailUtl;
	}

	public String getGsm1Utl() {
		return gsm1Utl;
	}

	public void setGsm1Utl(String gsm1Utl) {
		this.gsm1Utl = gsm1Utl;
	}

	public String getGsm2Utl() {
		return gsm2Utl;
	}




	public void setGsm2Utl(String gsm2Utl) {
		this.gsm2Utl = gsm2Utl;
	}

	public String getTelUtl() {
		return telUtl;
	}


	public void setTelUtl(String telUtl) {
		this.telUtl = telUtl;
	}

	public String getCinUtl() {
		return cinUtl;
	}
	public void setCinUtl(String cinUtl) {
		this.cinUtl = cinUtl;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotPass() {
		return motPass;
	}
	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}




	public List<Utilisateur> getUtilisateurs() {
		
		UtilisateurService ser= new UtilisateurService();
		utilisateurs= ser.rechercheTousUtilisateur();
		//for(int i=0;i<utilisateurs.size();i++)
			//System.out.println(utilisateurs.get(i));
		return utilisateurs;
	}




	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}




	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}




	public void modifierUtilisateur (Utilisateur te) {
		action="Modifier";
		idutilisateur = te.getIdutilisateur();
		nomUtl = te.getNomUtl();
		prenomUtl = te.getPrenomUtl();
		mailUtl= te.getMailUtl();
		adrUtl = te.getAdrUtl();
		gsm1Utl= te.getGsm1Utl();
		gsm2Utl= te.getGsm2Utl();
		telUtl= te.getTelUtl();
		cinUtl= te.getCinUtl();
		login = te.getLogin();
		motPass = te.getMotPass();
		grade = te.getGrade();
		
	}
		
		
		
		
	public void validation() {
		UtilisateurService ser = new UtilisateurService();
		Utilisateur te = new Utilisateur();
		te.setNomUtl(nomUtl);
		te.setPrenomUtl(prenomUtl);
		te.setMailUtl(mailUtl);
		te.setAdrUtl(adrUtl);
		te.setGsm1Utl(gsm1Utl);
		te.setGsm2Utl(gsm2Utl);
		te.setTelUtl(telUtl);
		te.setCinUtl(cinUtl);
		te.setLogin(login);
		te.setMotPass(motPass);
		te.setGrade(grade);
		if(action.equals("Modifier"))
		   {
			te.setIdutilisateur(idutilisateur);
			ser.modifierUtilisateur(te);
		   }
	if (action.equals("Ajouter"))
	   ser.ajouterUtilisateur(te);
	
	   initialisation();
	}
	
	
	public void initialisation (){
		idutilisateur = null;
		nomUtl = null;
		prenomUtl = null;
		mailUtl= null;
		adrUtl = null;
		gsm1Utl= null;
		gsm2Utl= null;
		telUtl= null;
		cinUtl= null;
		login = null;
		motPass = null;
		grade = null;
	}
	
	public void ajouterUtilisateur(){
	action="Ajouter";
	
	}

	public void Supprimer(Integer id) {
		UtilisateurService ser = new UtilisateurService();
		ser.supprimerUtilisateur(id);
	}


}

	

	



	