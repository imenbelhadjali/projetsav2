package com.sav.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sav.dao.PanneHome;
import com.sav.dao.HibernateUtil;
import com.sav.persistance.Panne;


public class PanneService {
	
	public PanneService (){
		dao=new PanneHome();
	}
	PanneHome dao; 
	
public List<Panne> rechercheTousPanne(){
	List<Panne> liste = null;
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




public List<Panne> rechercheParNom(){
	List<Panne> liste = null;
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
public void  supprimerPanne(Integer idpanne)
{
	
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		Panne cl=new Panne();
		cl.setIdpanne(idpanne);
		
		dao.delete(cl);
					
		
		tx.commit() ;
		}catch(RuntimeException ex){ 
		if(tx!= null) tx.rollback();
		ex.printStackTrace() ; 
			}
}

public void modifierPanne(Panne panne)

{
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		dao.merge(panne);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	}




public void ajouterPanne(Panne p) {
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		dao.persist(p);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	
}


}
