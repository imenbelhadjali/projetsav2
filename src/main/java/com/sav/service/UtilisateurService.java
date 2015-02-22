package com.sav.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sav.dao.HibernateUtil;
import com.sav.dao.UtilisateurHome;
import com.sav.persistance.Utilisateur;

public class UtilisateurService {
	
	public UtilisateurService (){
		dao=new UtilisateurHome();
	}
	UtilisateurHome dao; 
	
public List<Utilisateur> rechercheTousUtilisateur(){
	List<Utilisateur> liste = null;
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




public List<Utilisateur> rechercheParNom(){
	List<Utilisateur> liste = null;
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
public void  supprimerUtilisateur(Integer idutilisateur)
{
	
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		Utilisateur cl=new Utilisateur();
		cl.setIdutilisateur(idutilisateur);
		
		dao.delete(cl);
					
		
		tx.commit() ;
		}catch(RuntimeException ex){ 
		if(tx!= null) tx.rollback();
		ex.printStackTrace() ; 
			}
}

public void modifierUtilisateur(Utilisateur utilisateur)

{
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		dao.merge(utilisateur);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	}




public void ajouterUtilisateur(Utilisateur te) {
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		dao.persist(te);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	
}


}
