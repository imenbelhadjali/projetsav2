package com.sav.dao;

// Generated 22 janv. 2015 15:22:58 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sav.persistance.Reg_tache;




import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Reg_tache.
 * @see com.stage.pfe.dao.Personne
 * @author Hibernate Tools
 */
public class Reg_tacheHome {

	private static Logger log = Logger.getLogger(Reg_tacheHome.class);

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

	public void persist(Reg_tache transientInstance) {
		log.debug("persisting Reg_tache instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Reg_tache instance) {
		log.debug("attaching dirty Reg_tache instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Reg_tache instance) {
		log.debug("attaching clean Reg_tache instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Reg_tache persistentInstance) {
		log.debug("deleting Reg_tache instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Reg_tache merge(Reg_tache detachedInstance) {
		log.debug("merging Reg_tache instance");
		try {
			Reg_tache result = (Reg_tache) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Reg_tache findById(java.lang.Integer id) {
		log.debug("getting Reg_tache instance with id: " + id);
		try {
			Reg_tache instance = (Reg_tache) sessionFactory.getCurrentSession()
					.get("com.stage.pfe.dao.Reg_tache", id);
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

	public List<Reg_tache> findByExample(Reg_tache instance) {
		log.debug("finding Reg_tache instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Reg_tache> results = (List<Reg_tache>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.stage.pfe.dao.Reg_tache")
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
	public List<Reg_tache> findAll() {//select * from reg_tache;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Reg_tache.class);
		return crit.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Reg_tache> findByNom(String n) {//select * from reg_tache where cond;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Reg_tache.class).add(Restrictions.eq("nom", n));
		return crit.list();
	}
	

}
