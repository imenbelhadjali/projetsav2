package com.sav.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sav.dao.Reg_pieceHome;
import com.sav.dao.HibernateUtil;
import com.sav.persistance.Reg_piece;


public class Reg_pieceService {
	
	public Reg_pieceService (){
		dao=new Reg_pieceHome();
	}
	Reg_pieceHome dao; 
	
public List<Reg_piece> rechercheTousReg_piece(){
	List<Reg_piece> liste = null;
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx = null;
	try {

		tx = session.beginTransaction();

		liste = dao.findAll();
		
		tx.commit();

	} catch (RuntimeException ex) {

		if (tx != null)
			tx.rollback();
		ex.printStackTrace();
	}
	return (liste);
}




public List<Reg_piece> rechercheParNom(){
	List<Reg_piece> liste = null;
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx = null;
	try {

		tx = session.beginTransaction();

		liste = dao.findByNom("");
		
		tx.commit();

	} catch (RuntimeException ex) {

		if (tx != null)
			tx.rollback();
		ex.printStackTrace();
	}
	return (liste);
}
public void  supprimerReg_piece(Integer idreg_piece)
{
	
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		Reg_piece cl=new Reg_piece();
		cl.setIdreg_piece(idreg_piece);
		
		dao.delete(cl);
					
		
		tx.commit() ;
		}catch(RuntimeException ex){ 
		if(tx!= null) tx.rollback();
		ex.printStackTrace() ; 
			}
}

public void modifierReg_piece(Reg_piece reg_piece)

{
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		dao.merge(reg_piece);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	}




public void ajouterReg_piece(Reg_piece rp) {
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		dao.persist(rp);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	
}


}
