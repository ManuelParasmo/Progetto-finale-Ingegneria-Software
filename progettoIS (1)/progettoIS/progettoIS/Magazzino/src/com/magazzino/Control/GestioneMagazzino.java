package com.magazzino.Control;

import com.magazzino.Exception.*;

import com.magazzino.Entity.*;
import com.magazzino.Database.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GestioneMagazzino {
	
	private static GestioneMagazzino gM = null;
	
	public static GestioneMagazzino getInstance() 
	{ 
		if (gM == null) 
			gM = new GestioneMagazzino(); 

		return gM; 
	}
	
	public float effettuaPrenotazione(ArrayList<Integer> idAttrezzature) throws OperationException {
		
		EntityAttrezzatura eA;
		float prezzoTot = 0;
		
		try {
			
			int AttrezzatureTotali = idAttrezzature.size();
			for(int i = 0; i < AttrezzatureTotali; i++) {
				eA = AttrezzaturaDAO.readAttrezzatura(idAttrezzature.get(i));
				if (eA == null) {
					throw new OperationException("Impossibile trovare l'attrezzatura.");
				}
				else{
					prezzoTot += eA.getPrezzo();
				}
			}
			
		}catch(DBConnectionException dbEx) {
			throw new OperationException("\nRiscontrato problema interno applicazione!\n");
		}catch(DAOException ex) {
			throw new OperationException("Ops, qualcosa è andato storto..");
		}
		
		return prezzoTot;
		
	}

	public boolean confermaPrenotazione(String nome, String cognome, String email, String documento, String telefono, String residenza, ArrayList<Integer> idAttrezzature) throws OperationException {
	
		EntityCliente eC;
		EntityPrenotazione eP;
		int idCliente = 0;
		boolean success = false;
		
		try {
			
			eC = ClienteDAO.readClienteDocumento(documento);
			if (eC != null) {
				idCliente = eC.getIdCliente();
			}
			else if (eC == null) {
				EntityCliente eCTemp = new EntityCliente(0, nome, cognome, email, documento, telefono, residenza);
				idCliente = eCTemp.saveCliente();
			}
			
			eP = new EntityPrenotazione(0, null, "", false, "", idCliente);
			success = eP.savePrenotazione(idAttrezzature);
			
		}catch(DBConnectionException dbEx) {
			success = false;
			throw new OperationException("\nRiscontrato problema interno applicazione!\n");
		}catch(DAOException ex) {
			success = false;
			throw new OperationException("Ops, qualcosa è andato storto...");
		}
		
		return success;
		
	}
		
	public boolean registraConsegna(int numPrenotazione) throws OperationException {
		
		boolean success = true; 
		
		try {
			
			EntityPrenotazione eP;
			eP = PrenotazioneDAO.readPrenotazione(numPrenotazione);
			if (eP == null) {
				System.out.println("Prenotazione non trovata.");
			}
			else if (eP != null) {
				if (eP.getEsito() == "RIFIUTATO") {
					System.out.println("Impossibile registrare la consegna, la prenotazione è stata rifiutata.");
				}
				//else if (eP.getPagato() == false) {
					//System.out.println("Impossibile registrare la consegna, la prenotazione non è stata pagata.");
				//}  ATTENZIONE: IL CONTROLLO E' STATO MOMENTANEAMENTE DISABILITATO POICHE' MANCA L'IMPLEMENTAZIONE DI EFFETTUA PAGAMENTO
				else {
					PrenotazioneDAO.updatePrenotazioneAndamento(numPrenotazione, "CONSEGNATO");
					System.out.println("Registrazione consegna avvenuta con successo.");
					System.out.println("");
				}
			}
			
		}catch(DBConnectionException dbEx) {
			success = false;
			throw new OperationException("\nRiscontrato problema interno applicazione!\n");
		}catch(DAOException ex) {
			success = false;
			throw new OperationException("Ops, qualcosa è andato storto..");
		}
		
		return success;
		
	}

	public boolean evadiPrenotazione(int numPrenotazione, String esito) throws OperationException {

		boolean success = false;
		
		try {
			
			EntityPrenotazione eP;
			eP = PrenotazioneDAO.readPrenotazione(numPrenotazione);
			if (eP == null) {
				System.out.println("Prenotazione non trovata.");
			}
			else if (eP != null) {
				if (esito.toUpperCase().equals("C")) {
					PrenotazioneDAO.updatePrenotazioneEsito(numPrenotazione, "CONFERMATO");
					ArrayList<Integer> attrezzatureInPrenotazione = PrenotazioneDAO.readAttrezzatureInPrenotazione(numPrenotazione);
					for(int i = 0; i < attrezzatureInPrenotazione.size(); i++) {
						AttrezzaturaDAO.updateAttrezzaturaNoleggiata(attrezzatureInPrenotazione.get(i));
					} 
					success = true;
				}
				else if (esito.toUpperCase().equals("R")) {
					PrenotazioneDAO.updatePrenotazioneEsito(numPrenotazione, "RIFIUTATO");
					success = true;
				}
				else {
					success = false;
				}
				inviaEsitoPrenotazione(esito);
			}
			
		}catch(DBConnectionException dbEx) {
			success = false;
			throw new OperationException("\nRiscontrato problema interno applicazione!\n");
		}catch(DAOException ex) {
			success = false;
			throw new OperationException("Ops, qualcosa è andato storto..");
		}
		
		return success;
		
	}

	public void generaReport() throws OperationException {
		
		try {
			
			EntityReport eR = new EntityReport(0, null, 0, "", "", "", "");
			eR.saveReport();
			
		}catch(DBConnectionException dbEx) {
			throw new OperationException("\nRiscontrato problema interno applicazione!\n");
		}catch(DAOException ex) {
			throw new OperationException("Ops, qualcosa è andato storto..");
		}
		
	}

	public void inviaEsitoPrenotazione(String esito) {
		
		try {
		
			if (esito.toUpperCase().equals("C")) {
				System.out.println("Invio email di conferma in corso...");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Email inviata con successo.");
			}
			else if (esito.toUpperCase().equals("R")) {
				System.out.println("Invio email di rifiuto in corso...");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Email inviata con successo.");
			}
		
		} catch (Exception e) {
			System.out.println("Unexpected exception, riprovare..");
			System.out.println();
		}
		
	}
	
}
