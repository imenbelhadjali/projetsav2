package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Client;
import com.sav.service.ClientService;


@ManagedBean(name ="clientBean")
@SessionScoped
public class ClientBean {

	private Integer idclient;
	private String nomclt;
	private String prenomclt;
	private String adrclt;
	private String mailclt;
	private String gsm1clt;
	private String gsm2clt;
	private String telclt;
	private String faxclt;
	private String valeurRecherche;
	private String attribut;

	private List<Client> clients = new ArrayList<Client>(0);
	private List<String> listesRecherches = new ArrayList<String>();
	private String action;

	public String getValeurRecherche() {
		return valeurRecherche;
	}
	public void setValeurRecherche(String valeurRecherche) {
		this.valeurRecherche = valeurRecherche;
	}
	public String getAttribut() {
		return attribut;
	}
	public void setAttribut(String attribut) {
		this.attribut = attribut;
	}
	public Integer getIdclient() {
		return idclient;
	}
	public void setIdclient(Integer idclient) {
		this.idclient = idclient;
	}
	public String getNomclt() {
		return nomclt;
	}
	public void setNomclt(String nomclt) {
		this.nomclt = nomclt;
	}
	
	
	public String getPrenomclt() {
		return prenomclt;
	}
	public void setPrenomclt(String prenomclt) {
		this.prenomclt = prenomclt;
	}
	public String getAdrclt() {
		return adrclt;
	}
	public void setAdrclt(String adrclt) {
		this.adrclt = adrclt;
	}
	public String getMailclt() {
		return mailclt;
	}
	public void setMailclt(String mailclt) {
		this.mailclt = mailclt;
	}
	public String getGsm1clt() {
		return gsm1clt;
	}
	public void setGsm1clt(String gsm1clt) {
		this.gsm1clt = gsm1clt;
	}
	public String getGsm2clt() {
		return gsm2clt;
	}
	public void setGsm2clt(String gsm2clt) {
		this.gsm2clt = gsm2clt;
	}
	public String getTelclt() {
		return telclt;
	}
	public void setTelclt(String telclt) {
		this.telclt = telclt;
	}
	public String getFaxclt() {
		return faxclt;
	}
	public void setFaxclt(String faxclt) {
		this.faxclt = faxclt;
	}
	
	
	public List<String> getListesRecherches() {
		
		listesRecherches.clear();
		listesRecherches.add("Nom");
		listesRecherches.add("Prenom");
		listesRecherches.add("Client");
		listesRecherches.add("Gsm");
		listesRecherches.add("Tel");


		return listesRecherches;
		
	}
	public void setListesRecherches(List<String> listesRecherches) {
		this.listesRecherches = listesRecherches;
	}
	public List<Client> getClients() {
		
		ClientService ser = new ClientService();
		if ((valeurRecherche != null) && (attribut != null))
			clients = ser.rechercheFiltre(attribut, valeurRecherche);
		else
			clients = ser.rechercheTousClient();
		for(int i=0;i<clients.size();i++)
			System.out.println(clients.get(i));

		return clients;

	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	public void modifierClient (Client c) {
		action="Modifier";
		idclient = c.getIdclient();
		nomclt = c.getNomclt();
		prenomclt=c.getPrenomclt();
		mailclt= c.getMailclt();
		adrclt = c.getAdrclt();
		gsm1clt= c.getGsm1clt();
		gsm2clt= c.getGsm2clt();
		telclt= c.getTelclt();
		faxclt= c.getFaxclt();
	
	}
		
	
	public void validation() {
		ClientService ser = new ClientService();
		Client c = new Client();
		c.setNomclt(nomclt);
		c.setPrenomclt(prenomclt);
		c.setMailclt(mailclt);
		c.setAdrclt(adrclt);
		c.setGsm1clt(gsm1clt);
		c.setGsm2clt(gsm2clt);
		c.setTelclt(telclt);
		c.setFaxclt(faxclt);
		
		if(action.equals("Modifier"))
		   {
			c.setIdclient(idclient);
			ser.modifierClient(c);
		   }
	if (action.equals("Ajouter"))
	   ser.ajouterClient(c);
	
	   initialisation();
	}
	
	
	public String initialisation(){
		idclient = null;
		nomclt = null;
		prenomclt=null;
		mailclt= null;
		adrclt = null;
		gsm1clt= null;
		gsm2clt= null;
		telclt= null;
		faxclt= null;
		
		return null;
		
	}
	
	public void ajouterClient(){
	action="Ajouter";
	
	}

	public void Supprimer(Integer id) {
		ClientService ser = new ClientService();
		ser.supprimerClient(id);
	}

	public void annulerRecherche() {
		valeurRecherche = null;
	}


}

	

	



	