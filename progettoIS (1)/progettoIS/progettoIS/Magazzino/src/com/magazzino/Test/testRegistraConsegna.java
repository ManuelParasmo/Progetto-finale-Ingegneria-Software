package com.magazzino.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.magazzino.Control.GestioneMagazzino;

public class testRegistraConsegna {

	@Test
	public void testCasoID1() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			int numPrenotazione = 716;
			boolean esito = gM.registraConsegna(numPrenotazione);
			assertTrue(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID2() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String numPrenotazione = "11aa@a";
			boolean esito = gM.registraConsegna(Integer.parseInt(numPrenotazione));
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
