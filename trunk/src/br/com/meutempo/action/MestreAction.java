package br.com.meutempo.action;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import br.com.meutempo.dao.DaoException;
import br.com.meutempo.dao.MestreDAO;
import br.com.meutempo.model.Mestre;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action para o CRUD de objetivos mestre.
 * @author Bruno
 * @since 06/11/2007
 */
public class MestreAction extends ActionSupport  {

	private static final long serialVersionUID = -3061607839699857116L;
	private Collection<Mestre> listaMestres;
	private MestreDAO mestreDAO;

	@Transactional
	public String listar() {
		try {
			listaMestres = mestreDAO.listar();
		} catch (DaoException e) {
			addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public Collection<Mestre> getListaMestres() {
		return listaMestres;
	}

	public void setMestreDAO(MestreDAO mestreDAO) {
		this.mestreDAO = mestreDAO;
	}
	
}
