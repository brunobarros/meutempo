package br.com.meutempo.action;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import br.com.meutempo.dao.DaoException;
import br.com.meutempo.dao.GenericDAO;
import br.com.meutempo.dao.MestreDAO;
import br.com.meutempo.dao.PrioridadeDAO;
import br.com.meutempo.model.Mestre;
import br.com.meutempo.model.Prioridade;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Bruno
 *
 */
public class MestreActionTest {

	private MestreAction action;
	private MestreDAO mestreDAOMock;
	private PrioridadeDAO prioridadeDAOMock;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		action = new MestreAction();
		mestreDAOMock = createMock(MestreDAO.class);
		prioridadeDAOMock = createMock(PrioridadeDAO.class);
		action.setMestreDAO(mestreDAOMock);
		action.setPrioridadeDAO(prioridadeDAOMock);
	}
	
	@Test
	public void testListarSucesso() throws Exception {
		Collection<Mestre> listaMestresMock = createMock(Collection.class);
		expect(listaMestresMock.size()).andReturn(7);
		replay(listaMestresMock);
		
		expect(mestreDAOMock.listar()).andReturn(listaMestresMock);		
		replay(mestreDAOMock);
		
		assertEquals("Retorno da action difere do esperado.", 
				Action.SUCCESS, action.listar());
		assertNotNull("Deveria retornar uma lista de objetivos mestre.", 
				action.getListaMestres());
		assertEquals(7, action.getListaMestres().size());
		assertEquals(0, action.getActionMessages().size());
		assertEquals(0, action.getActionErrors().size());
	}
	
	@Test
	public void testInserirSucesso() throws Exception {
		expect(mestreDAOMock.inserir(new Mestre())).andReturn(new Mestre());
		replay(mestreDAOMock);
		
		action.setMestre(new Mestre());
				
		assertEquals(Action.SUCCESS, action.inserir());
		assertEquals(1, action.getActionMessages().size());
		assertTrue(action.getActionMessages().contains("Mestre adicionado com sucesso."));
	}
	
	@Test
	public void testInserirFalha() throws Exception {
		expect(mestreDAOMock.inserir(new Mestre())).andThrow(new DaoException("Problema qualquer."));
		replay(mestreDAOMock);
		
		action.setMestre(new Mestre());
		
		assertEquals("Retorno da execução da action difere da esperada.", 
				ActionSupport.ERROR, action.inserir());
		assertEquals("Quantidade de mensagens de erro difere da esperada.", 
				1, action.getActionErrors().size());
		assertTrue("Mensagem de erro difere da esperada.", 
				action.getActionErrors().contains("Ocorreu um problema na inserção: Problema qualquer."));
	}
	
	@Test
	public void testPrepare() throws Exception {
		Collection<Prioridade> prioridadesMock = createMock(Collection.class);
		expect(prioridadesMock.size()).andReturn(1);
		expect(prioridadesMock.contains(new Prioridade(1, "Urgente"))).andReturn(true);
		replay(prioridadesMock);		
		
		expect(prioridadeDAOMock.listar()).andReturn(prioridadesMock);
		replay(prioridadeDAOMock);
		
		assertEquals(ActionSupport.SUCCESS, action.prepare());
		assertEquals(1, action.getPrioridades().size());
		assertTrue(action.getPrioridades().contains(new Prioridade(1, "Urgente")));
	}

}
