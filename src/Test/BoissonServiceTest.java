package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import service.BoissonService;
import java.util.Map;
import domaine.Boisson;

public class BoissonServiceTest {
	private BoissonService boissonService1;
	private Map<String, Boisson> listBoisson;
	
	@Before
	public void creationListBoiss(){
	boissonService1 = new BoissonService();
	listBoisson = boissonService1.getboisson();
	}
	
	@After
	public void suppressionListBoiss(){
	listBoisson = null;
	}
	

	@Test
	public void testDisponibilitéCorrespondBienAuBooleanTrue() {
		Boisson boisson1 = listBoisson.get("CHO");
		String dispo = boissonService1.getDisponibilité(boisson1);
		assertTrue(dispo.equals("disponible"));		
	}
	
	@Test
	public void testDisponibilitéCorrespondBienAuBooleanFalse() {
		Boisson boisson1 = listBoisson.get("THE");
		String dispo = boissonService1.getDisponibilité(boisson1);
		assertTrue(dispo.equals("indisponible"));
	}

	@Test
	public void testChoixBoissonRetourneBienUnInt() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testChoixBoissonSouleveUneException() {
		fail("Not yet implemented");
	}

	@Test
	public void testInfoBoisson() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnqueteBoisson() {
		fail("Not yet implemented");
	}

	@Test
	public void testChoixPresIngr() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertBoisson() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransfertIDIngr() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransfertListIngr() {
		fail("Not yet implemented");
	}

}
