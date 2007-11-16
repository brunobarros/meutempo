package br.com.meutempo.dao.hibernate;

import org.hibernate.SessionFactory;

import br.com.meutempo.dao.PrioridadeDAO;
import br.com.meutempo.model.Prioridade;

/**
 * 
 * @author Bruno Barros
 *
 */
public class HibernatePrioridadeDAO extends HibernateGenericDAO<Prioridade, Integer> implements PrioridadeDAO {

	private static final long serialVersionUID = 1841330468265788454L;

	public HibernatePrioridadeDAO(SessionFactory sessionFactory) {
		super(Prioridade.class, sessionFactory);
	}

}
