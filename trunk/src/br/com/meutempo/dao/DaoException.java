package br.com.meutempo.dao;

import org.hibernate.HibernateException;

public class DaoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoException(HibernateException e) {
		super(e);
	}

	public DaoException(String mensagem) {
		super(mensagem);
	}

}
