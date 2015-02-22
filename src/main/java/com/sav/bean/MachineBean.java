package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Machine;
import com.sav.service.MachineService;








@ManagedBean(name = "machineBean")
@SessionScoped
public class MachineBean {

	private Integer idmachine;
	private String num_serie;
	private String designationMach;
	private String model;
	
	
	
	
	
	
	private List<Machine> machines = new ArrayList<Machine>(0);
	private String action;
	
	
	
	
	
	
	public List<Machine> getMachines() {
		MachineService ser = new MachineService();
		machines = ser.rechercheTousMachine();
		return machines;
	}




	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}




	public Integer getIdmachine() {
		return idmachine;
	}




	public void setIdmachine(Integer idmachine) {
		this.idmachine = idmachine;
	}




	public String getNum_serie() {
		return num_serie;
	}




	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}




	public String getDesignationMach() {
		return designationMach;
	}




	public void setDesignationMach(String designationMach) {
		this.designationMach = designationMach;
	}




	public String getModel() {
		return model;
	}




	public void setModel(String model) {
		this.model = model;
	}






	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}




	public void modifierMachine (Machine m) {
		action="modifier";
		System.out.println("id  "+idmachine);
		idmachine = m.getIdmachine();
		designationMach = m.getDesignationMach();
		num_serie = m.getNum_serie();
		model = m.getModel();
	
	}
		
		
		
		
	public void validation() {
		MachineService ser = new MachineService();
		Machine m = new Machine();
		m.setDesignationMach(designationMach);
		m.setNum_serie(num_serie);
		m.setModel(model);
		
		System.out.println(action);	
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			m.setIdmachine(idmachine);
			ser.modifierMachine(m);
		   }
	if (action.equals("ajouter"))
	
		
	
	   ser.ajouterMachine(m);
	   initialisation();
	}
	
	
	public void initialisation (){
		idmachine = null;
		num_serie = null;
		designationMach = null;
		model = null;
		
		
	}
	
	public void ajouterMachine(){
	action="ajouter";
	initialisation();
	
	}

	public void Supprimer(Integer id) {
		MachineService ser = new MachineService();
		ser.supprimerMachine(id);
	}


}

	

	



	