package com.sav.dao;

// Generated 22 janv. 2015 15:22:58 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sav.persistance.Aplfour;




import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Aplfour.
 * @see com.stage.pfe.dao.Personne
 * @author Hibernate Tools
 */
public class AplfourHome {

	private static Logger log = Logger.getLogger(AplfourHome.class);

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

	public void persist(Aplfour transientInstance) {
		log.debug("persisting Aplfour instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Aplfour instance) {
		log.debug("attaching dirty Aplfour instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Aplfour instance) {
		log.debug("attaching clean Aplfour instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Aplfour persistentInstance) {
		log.debug("deleting Aplfour instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Aplfour merge(Aplfour detachedInstance) {
		log.debug("merging Aplfour instance");
		try {
			Aplfour result = (Aplfour) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Aplfour findById(java.lang.Integer id) {
		log.debug("getting Aplfour instance with id: " + id);
		try {
			Aplfour instance = (Aplfour) sessionFactory.getCurrentSession()
					.get("com.stage.pfe.dao.Aplfour", id);
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

	public List<Aplfour> findByExample(Aplfour instance) {
		log.debug("finding Aplfour instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Aplfour> results = (List<Aplfour>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.stage.pfe.dao.Aplfour")
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
	public List<Aplfour> findAll() {//select * from aplfour;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Aplfour.class);
		return crit.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Aplfour> findByNom(String n) {//select * from aplfour where cond;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Aplfour.class).add(Restrictions.eq("nom", n));
		return crit.list();
	}
	

}
