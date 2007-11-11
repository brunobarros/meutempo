package br.com.meutempo.dao.hibernate;

import org.hibernate.SessionFactory;

import br.com.meutempo.dao.MestreDAO;
import br.com.meutempo.model.Mestre;

/**
 * 
 * @author Bruno Barros
 *
 */
public class HibernateMestreDAO extends HibernateGenericDAO<Mestre, Long> implements MestreDAO {

	private static final long serialVersionUID = 2583589619302855047L;

	public HibernateMestreDAO(SessionFactory sessionFactory) {
		super(Mestre.class, sessionFactory);
	}

}
