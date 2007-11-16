package br.com.meutempo.dao;

import java.io.Serializable;
import java.util.Collection;

public interface GenericDAO<PersistentObject, PK extends Serializable> {
	
	Collection<PersistentObject> listar() throws DaoException;
	
	PersistentObject inserir(PersistentObject object) throws DaoException;

}
