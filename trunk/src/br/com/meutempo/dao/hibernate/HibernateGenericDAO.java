package br.com.meutempo.dao.hibernate;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import br.com.meutempo.dao.DaoException;
import br.com.meutempo.dao.GenericDAO;

/**
 * @author Bruno
 * 
 */
public abstract class HibernateGenericDAO<PersistentObject, PK extends Serializable>
		implements GenericDAO<PersistentObject, PK>, Serializable {

	protected SessionFactory sessionFactory;

	protected Class objectClass;

	public HibernateGenericDAO(Class objectClass, SessionFactory sessionFactory) {
		this.objectClass = objectClass;
		this.sessionFactory = sessionFactory;
	}

	public Collection<PersistentObject> listar() throws DaoException {
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(objectClass);

			return criteria.list();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	
	public PersistentObject inserir(PersistentObject object) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(object);
			sessionFactory.getCurrentSession().flush();
			
			return object;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

}
