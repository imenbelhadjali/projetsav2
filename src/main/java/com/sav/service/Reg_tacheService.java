package com.sav.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sav.dao.Reg_tacheHome;
import com.sav.dao.HibernateUtil;
import com.sav.persistance.Reg_tache;


public class Reg_tacheService {
	
	public Reg_tacheService (){
		dao=new Reg_tacheHome();
	}
	Reg_tacheHome dao; 
	
public List<Reg_tache> rechercheTousReg_tache(){
	List<Reg_tache> liste = null;
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




public List<Reg_tache> rechercheParNom(){
	List<Reg_tache> liste = null;
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
public void  supprimerReg_tache(Integer idreg_tache)
{
	
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		Reg_tache cl=new Reg_tache();
		cl.setIdreg_tache(idreg_tache);
		
		dao.delete(cl);
					
		
		tx.commit() ;
		}catch(RuntimeException ex){ 
		if(tx!= null) tx.rollback();
		ex.printStackTrace() ; 
			}
}

public void modifierReg_tache(Reg_tache reg_tache)

{
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		dao.merge(reg_tache);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	}




public void ajouterReg_tache(Reg_tache rt) {
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		dao.persist(rt);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	
}


}
