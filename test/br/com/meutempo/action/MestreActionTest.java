package br.com.meutempo.action;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.meutempo.dao.MestreDAO;
import br.com.meutempo.model.Mestre;

import com.opensymphony.xwork2.Action;

/**
 * @author Bruno
 *
 */
public class MestreActionTest {

	private MestreAction action;
	private MestreDAO mestreDAOMock;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		action = new MestreAction();
		mestreDAOMock = createMock(MestreDAO.class);
		action.setMestreDAO(mestreDAOMock);
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

}
