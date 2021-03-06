package com.sav.persistance;

// Generated 22 janv. 2015 15:05:41 by Hibernate Tools 3.4.0.CR1

/**
 * Utilisateur generated by hbm2java
 */
public class Utilisateur implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	
	
	public Utilisateur() {
	}

	public Utilisateur( String nomUtl, String prenomUtl, String adrUtl,String mailUtl, String gsm1Utl,String gsm2Utl,String telUtl,String cinUtl,String login,String motPass,String grade) {
		
		this.nomUtl = nomUtl;
		this.prenomUtl = prenomUtl;
		this.mailUtl = mailUtl;
		this.adrUtl = adrUtl;
		this.gsm1Utl = gsm1Utl;
		this.gsm2Utl = gsm2Utl;
		this.telUtl = telUtl;
		this.cinUtl = cinUtl;
		this.login = login;
		this.motPass = motPass;
		this.grade = grade;
		
	}
	
	
	

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

	
	

}
