package com.sav.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sav.dao.TypeHome;
import com.sav.dao.HibernateUtil;
import com.sav.persistance.Type;


public class TypeService {
	
	public TypeService (){
		dao=new TypeHome();
	}
	TypeHome dao; 
	
public List<Type> rechercheTousType(){
	List<Type> liste = null;
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




public List<Type> rechercheParNom(){
	List<Type> liste = null;
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
public void  supprimerType(Integer idtype)
{
	
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		Type cl=new Type();
		cl.setIdtype(idtype);
		
		dao.delete(cl);
					
		
		tx.commit() ;
		}catch(RuntimeException ex){ 
		if(tx!= null) tx.rollback();
		ex.printStackTrace() ; 
			}
}

public void modifierType(Type type)

{
	
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		dao.merge(type);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	}




public void ajouterType(Type t) {
	Session	session=HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx= null ; 
	try{
		
		tx=session.beginTransaction();
		dao.persist(t);
		tx.commit() ;
		}catch(RuntimeException ex){ 
			
			if(tx!= null) tx.rollback(); ex.printStackTrace() ; 
		}
	
}


}
