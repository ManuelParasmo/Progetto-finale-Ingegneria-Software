package com.magazzino.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.magazzino.Control.GestioneMagazzino;

public class testEvadiPrenotazione {
	
	@Test
	public void testCasoID1() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			int numPrenotazione = 716;
			String esito = "C";
			boolean risultato = gM.evadiPrenotazione(numPrenotazione, esito);
			assertTrue(risultato);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID2() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String numPrenotazione = "11aa@a";
			String esito = "C";
			boolean risultato = gM.evadiPrenotazione(Integer.parseInt(numPrenotazione), esito);
			assertFalse(risultato);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID3() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			int numPrenotazione = 716;
			String esito = "CO";
			boolean risultato = gM.evadiPrenotazione(numPrenotazione, esito);
			assertFalse(risultato);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID4() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			int numPrenotazione = 716;
			String esito = "NO";
			boolean risultato = gM.evadiPrenotazione(numPrenotazione, esito);
			assertFalse(risultato);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
