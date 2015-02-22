package com.sav.persistance;

import com.sav.persistance.Client;

// Generated 22 janv. 2015 15:05:41 by Hibernate Tools 3.4.0.CR1

/**
 * Client generated by hbm2java
 */
public class Client implements java.io.Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idclient;
	private String nomclt;
	private String prenomclt;
	private String adrclt;
	private String mailclt;
	private String gsm1clt;
	private String gsm2clt;
	private String telclt;
	private String faxclt;
	
	
	
	public Client() {
	}

	public Client( String nomclt,  String adrclt,String mailclt, String gsm1clt,String gsm2clt,String telclt,String faxclt) {
		
		this.nomclt = nomclt;
		this.mailclt = mailclt;
		this.adrclt = adrclt;
		this.gsm1clt = gsm1clt;
		this.gsm2clt = gsm2clt;
		this.telclt = telclt;
		this.faxclt = faxclt;
		
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adrclt == null) ? 0 : adrclt.hashCode());
		result = prime * result + ((faxclt == null) ? 0 : faxclt.hashCode());
		result = prime * result + ((gsm1clt == null) ? 0 : gsm1clt.hashCode());
		result = prime * result + ((gsm2clt == null) ? 0 : gsm2clt.hashCode());
		result = prime * result
				+ ((idclient == null) ? 0 : idclient.hashCode());
		result = prime * result + ((mailclt == null) ? 0 : mailclt.hashCode());
		result = prime * result + ((nomclt == null) ? 0 : nomclt.hashCode());
		result = prime * result + ((telclt == null) ? 0 : telclt.hashCode());
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
		Client other = (Client) obj;
		if (adrclt == null) {
			if (other.adrclt != null)
				return false;
		} else if (!adrclt.equals(other.adrclt))
			return false;
		if (faxclt == null) {
			if (other.faxclt != null)
				return false;
		} else if (!faxclt.equals(other.faxclt))
			return false;
		if (gsm1clt == null) {
			if (other.gsm1clt != null)
				return false;
		} else if (!gsm1clt.equals(other.gsm1clt))
			return false;
		if (gsm2clt == null) {
			if (other.gsm2clt != null)
				return false;
		} else if (!gsm2clt.equals(other.gsm2clt))
			return false;
		if (idclient == null) {
			if (other.idclient != null)
				return false;
		} else if (!idclient.equals(other.idclient))
			return false;
		if (mailclt == null) {
			if (other.mailclt != null)
				return false;
		} else if (!mailclt.equals(other.mailclt))
			return false;
		if (nomclt == null) {
			if (other.nomclt != null)
				return false;
		} else if (!nomclt.equals(other.nomclt))
			return false;
		if (telclt == null) {
			if (other.telclt != null)
				return false;
		} else if (!telclt.equals(other.telclt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [idclient=" + idclient + ", nomclt=" + nomclt
				+ ", adrclt=" + adrclt + ", mailclt=" + mailclt + ", gsm1clt="
				+ gsm1clt + ", gsm2clt=" + gsm2clt + ", telclt=" + telclt
				+ ", faxclt=" + faxclt + "]";
	}
}
	