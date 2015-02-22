package com.sav.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sav.persistance.Piece;

import com.sav.service.PieceService;







@ManagedBean(name = "pieceBean")
@SessionScoped
public class PieceBean {

	private Integer idpiece;
	private String designationPce;
	private String prixPce;
	
	
	
	
	private List<Piece> pieces = new ArrayList<Piece>(0);
	public Integer getIdpiece() {
		return idpiece;
	}


	
	


	public String getPrixPce() {
		return prixPce;
	}






	public void setPrixPce(String prixPce) {
		this.prixPce = prixPce;
	}






	public void setIdpiece(Integer idpiece) {
		this.idpiece = idpiece;
	}




	public String getDesignationPce() {
		return designationPce;
	}




	public void setDesignationPce(String designationPce) {
		this.designationPce = designationPce;
	}




	public List<Piece> getPieces() {
		PieceService ser = new PieceService();
		pieces = ser.rechercheTousPiece();
		return pieces;
	}




	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}




	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}

	private String action;
	
	
	
	
	
	
	




	public void modifierPiece (Piece P) {
		action="modifier";
		System.out.println("id  "+idpiece);
		idpiece = P.getIdpiece();
		designationPce = P.getDesignationPce();
		prixPce = P.getPrixPce();
	
	}
		
		
		
		
	public void validation() {
		PieceService ser = new PieceService();
		Piece P = new Piece();
		P.setDesignationPce(designationPce);
		System.out.println(action);	
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			P.setIdpiece(idpiece);
			ser.modifierPiece(P);
		   }
	if (action.equals("ajouter"))
	
		
	
	   ser.ajouterPiece(P);
	   initialisation();
	}
	
	
	public void initialisation (){
		idpiece = null;
		designationPce = null;
		prixPce = null;
		
	}
	
	public void ajouterPiece(){
	action="ajouter";
	initialisation();
	
	}

	public void Supprimer(Integer id) {
		PieceService ser = new PieceService();
		ser.supprimerPiece(id);
	}


}

	

	



	