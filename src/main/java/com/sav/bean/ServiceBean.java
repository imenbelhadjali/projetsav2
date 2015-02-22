package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Service;

import com.sav.service.ServiceService;







@ManagedBean(name = "serviceBean")
@SessionScoped
public class ServiceBean {

	private Integer idservice;
	private String designationSer;
	
	
	
	
	private List<Service> services = new ArrayList<Service>(0);
	public Integer getIdservice() {
		return idservice;
	}




	public void setIdservice(Integer idservice) {
		this.idservice = idservice;
	}




	public String getDesignationSer() {
		return designationSer;
	}




	public void setDesignationSer(String designationSer) {
		this.designationSer = designationSer;
	}




	public List<Service> getServices() {
		ServiceService ser = new ServiceService();
		services = ser.rechercheTousService();
		return services;
	}




	public void setServices(List<Service> services) {
		this.services = services;
	}




	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}

	private String action;
	
	
	
	
	
	
	




	public void modifierService (Service s) {
		action="modifier";
		System.out.println("id  "+idservice);
		idservice = s.getIdservice();
		designationSer = s.getDesignationSer();
	
	}
		
		
		
		
	public void validation() {
		ServiceService ser = new ServiceService();
		Service s = new Service();
		s.setDesignationSer(designationSer);
		System.out.println(action);	
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			s.setIdservice(idservice);
			ser.modifierService(s);
		   }
	if (action.equals("ajouter"))
	
		
	
	   ser.ajouterService(s);
	   initialisation();
	}
	
	
	public void initialisation (){
		idservice = null;
		designationSer = null;
		
	}
	
	public void ajouterService(){
	action="ajouter";
	initialisation();
	
	}

	public void Supprimer(Integer id) {
		ServiceService ser = new ServiceService();
		ser.supprimerService(id);
	}


}

	

	



	