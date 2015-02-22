package com.sav.dao;

// Generated 22 janv. 2015 15:22:58 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sav.persistance.Reglement;




import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Reglement.
 * @see com.stage.pfe.dao.Personne
 * @author Hibernate Tools
 */
public class ReglementHome {

	private static Logger log = Logger.getLogger(ReglementHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			//return (SessionFactory) new InitialContext()
				//	.lookup("SessionFactory");
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Reglement transientInstance) {
		log.debug("persisting Reglement instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Reglement instance) {
		log.debug("attaching dirty Reglement instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Reglement instance) {
		log.debug("attaching clean Reglement instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Reglement persistentInstance) {
		log.debug("deleting Reglement instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Reglement merge(Reglement detachedInstance) {
		log.debug("merging Reglement instance");
		try {
			Reglement result = (Reglement) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Reglement findById(java.lang.Integer id) {
		log.debug("getting Reglement instance with id: " + id);
		try {
			Reglement instance = (Reglement) sessionFactory.getCurrentSession()
					.get("com.stage.pfe.dao.Reglement", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Reglement> findByExample(Reglement instance) {
		log.debug("finding Reglement instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Reglement> results = (List<Reglement>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.stage.pfe.dao.Reglement")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Reglement> findAll() {//select * from reglement;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Reglement.class);
		return crit.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Reglement> findByNom(String n) {//select * from reglement where cond;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Reglement.class).add(Restrictions.eq("nom", n));
		return crit.list();
	}
	

}
