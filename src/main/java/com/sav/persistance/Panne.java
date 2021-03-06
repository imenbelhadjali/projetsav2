package com.sav.persistance;

import com.sav.persistance.Panne;

// Generated 22 janv. 2015 15:05:41 by Hibernate Tools 3.4.0.CR1

/**
 * Client generated by hbm2java
 */
public class Panne implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idpanne;
	private String designationPan;
	
	
	
	
	public Panne() {
	}

	public Panne( String designationPan) {
		
		this.designationPan = designationPan;
		
		
	}

	public Integer getIdpanne() {
		return idpanne;
	}

	public void setIdpanne(Integer idpanne) {
		this.idpanne = idpanne;
	}

	public String getDesignationPan() {
		return designationPan;
	}

	public void setDesignationPan(String designationPan) {
		this.designationPan = designationPan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((designationPan == null) ? 0 : designationPan.hashCode());
		result = prime * result
				+ ((idpanne == null) ? 0 : idpanne.hashCode());
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
		Panne other = (Panne) obj;
		if (designationPan == null) {
			if (other.designationPan != null)
				return false;
		} else if (!designationPan.equals(other.designationPan))
			return false;
		if (idpanne == null) {
			if (other.idpanne != null)
				return false;
		} else if (!idpanne.equals(other.idpanne))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Panne [idpanne=" + idpanne + ", designationPan="
				+ designationPan + "]";
	}
	



}

	