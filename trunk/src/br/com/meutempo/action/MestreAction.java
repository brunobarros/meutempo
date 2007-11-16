package br.com.meutempo.action;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import br.com.meutempo.dao.DaoException;
import br.com.meutempo.dao.MestreDAO;
import br.com.meutempo.dao.PrioridadeDAO;
import br.com.meutempo.model.Mestre;
import br.com.meutempo.model.Prioridade;

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
	private Mestre mestre;
	private Collection<Prioridade> prioridades;
	private PrioridadeDAO prioridadeDAO;

	@Transactional
	public String listar() throws DaoException {
		listaMestres = mestreDAO.listar();
		return SUCCESS;
	}

	@Transactional
	public String prepare() throws DaoException {
		prioridades = prioridadeDAO.listar();
		return SUCCESS;
	}
	
	@Transactional
	public String inserir() {
		try {
			mestre = mestreDAO.inserir(mestre);
			addActionMessage("Mestre adicionado com sucesso.");
			return SUCCESS;
		} catch (DaoException e) {
			addActionError("Ocorreu um problema na inserção: " + e.getMessage());
			return ERROR;
		}
	}

	public void setMestre(Mestre mestre) {
		this.mestre = mestre;
	}
	
	public Collection<Mestre> getListaMestres() {
		return listaMestres;
	}

	public void setMestreDAO(MestreDAO mestreDAO) {
		this.mestreDAO = mestreDAO;
	}

	public Mestre getMestre() {
		return mestre;
	}

	public Collection<Prioridade> getPrioridades() {
		return prioridades;		
	}

	public void setPrioridadeDAO(PrioridadeDAO prioridadeDAO) {
		this.prioridadeDAO = prioridadeDAO;
	}

	public void setPrioridades(Collection<Prioridade> prioridades) {
		this.prioridades = prioridades;
	}
	
}
