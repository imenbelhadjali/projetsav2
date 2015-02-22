package com.sav.persistance;

import com.sav.persistance.Aplfour;

// Generated 22 janv. 2015 15:05:41 by Hibernate Tools 3.4.0.CR1

/**
 * Client generated by hbm2java
 */
public class Aplfour implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idaplfour;
	private String datesorti;
	private String dateretour;
	private String observation;
	private String montant;
	
	
	
	
	
	public Aplfour() {
	}
	
		
		public Aplfour(String datesorti,String dateretour,String observation,String montant){
			this.datesorti = datesorti;
			this.dateretour = dateretour;
			this.observation = observation;
			this.montant = montant;
			
			
			
			
		
	}


	public Integer getIdaplfour() {
		return idaplfour;
	}

	public void setIdaplfour(Integer idaplfour) {
		this.idaplfour = idaplfour;
		}


	public String getDatesorti() {
		return datesorti;
	}


	public void setDatesorti(String datesorti) {
		this.datesorti = datesorti;
	}


	public String getDateretour() {
		return dateretour;
	}


	public void setDateretour(String dateretour) {
		this.dateretour = dateretour;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public String getMontant() {
		return montant;
	}


	public void setMontant(String montant) {
		this.montant = montant;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateretour == null) ? 0 : dateretour.hashCode());
		result = prime * result
				+ ((datesorti == null) ? 0 : datesorti.hashCode());
		result = prime * result
				+ ((idaplfour == null) ? 0 : idaplfour.hashCode());
		result = prime * result + ((montant == null) ? 0 : montant.hashCode());
		result = prime * result
				+ ((observation == null) ? 0 : observation.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aplfour other = (Aplfour) obj;
		if (dateretour == null) {
			if (other.dateretour != null)
				return false;
		} else if (!dateretour.equals(other.dateretour))
			return false;
		if (datesorti == null) {
			if (other.datesorti != null)
				return false;
		} else if (!datesorti.equals(other.datesorti))
			return false;
		if (idaplfour == null) {
			if (other.idaplfour != null)
				return false;
		} else if (!idaplfour.equals(other.idaplfour))
			return false;
		if (montant == null) {
			if (other.montant != null)
				return false;
		} else if (!montant.equals(other.montant))
			return false;
		if (observation == null) {
			if (other.observation != null)
				return false;
		} else if (!observation.equals(other.observation))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Aplfour [idaplfour=" + idaplfour + ", datesorti=" + datesorti
				+ ", dateretour=" + dateretour + ", observation=" + observation
				+ ", montant=" + montant + "]";
	}

	
	

	}
