package com.magazzino.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.magazzino.Control.GestioneMagazzino;

public class testEffettuaPrenotazione {

	@Test
	public void testCasoID1() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Manuel";
			String cognome = "Parasmo";
			String email = "manuel@gmail.com";
			String documento = "FO0000000";
			String telefono = "3516789012";
			String residenza = "Formia46";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertTrue(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID2() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Maaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanuel";
			String cognome = "Parasmo";
			String email = "manuel@gmail.com";
			String documento = "FO0000001";
			String telefono = "3516789012";
			String residenza = "Formia46";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID3() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Manuel00-";
			String cognome = "Parasmo";
			String email = "manuel@gmail.com";
			String documento = "FO0000002";
			String telefono = "3516789012";
			String residenza = "Formia46";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID4() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Manuel";
			String cognome = "Paaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaarasmo";
			String email = "manuel@gmail.com";
			String documento = "FO0000003";
			String telefono = "3516789012";
			String residenza = "Formia46";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID5() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Manuel";
			String cognome = "Parasmo01??";
			String email = "manuel@gmail.com";
			String documento = "FO0000004";
			String telefono = "3516789012";
			String residenza = "Formia46";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID6() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Manuel";
			String cognome = "Parasmo";
			String email = "manuelmail";
			String documento = "FO0000005";
			String telefono = "3516789012";
			String residenza = "Formia46";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID7() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Manuel";
			String cognome = "Parasmo";
			String email = "manuel@gmail.com";
			String documento = "FO0000000RM";
			String telefono = "3516789012";
			String residenza = "Formia46";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID8() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Manuel";
			String cognome = "Parasmo";
			String email = "manuel@gmail.com";
			String documento = "FO00";
			String telefono = "3516789012";
			String residenza = "Formia46";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID9() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Manuel";
			String cognome = "Parasmo";
			String email = "manuel@gmail.com";
			String documento = "FO00000??.-";
			String telefono = "3516789012";
			String residenza = "Formia46";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID10() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Manuel";
			String cognome = "Parasmo";
			String email = "manuel@gmail.com";
			String documento = "FO0000006";
			String telefono = "35167890123112";
			String residenza = "Formia46";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID11() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Manuel";
			String cognome = "Parasmo";
			String email = "manuel@gmail.com";
			String documento = "FO0000007";
			String telefono = "3516783";
			String residenza = "Formia46";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID12() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Manuel";
			String cognome = "Parasmo";
			String email = "manuel@gmail.com";
			String documento = "FO0000008";
			String telefono = "35167@ab";
			String residenza = "Formia46";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID13() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Manuel";
			String cognome = "Parasmo";
			String email = "manuel@gmail.com";
			String documento = "FO0000009";
			String telefono = "3516789012";
			String residenza = "Fooooooooooooooooooooooooooooooormia46";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCasoID14() {
		try {
			GestioneMagazzino gM = GestioneMagazzino.getInstance();
			String nome = "Manuel";
			String cognome = "Parasmo";
			String email = "manuel@gmail.com";
			String documento = "FO0000010";
			String telefono = "3516789012";
			String residenza = "Formia 46!!!!#";
			ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
			idAttrezzature.add(1);
			idAttrezzature.add(2);
			idAttrezzature.add(3);
			boolean esito = gM.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
			assertFalse(esito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
