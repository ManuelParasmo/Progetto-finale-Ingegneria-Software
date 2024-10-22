package com.magazzino.Boundary;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.magazzino.Control.GestioneMagazzino;
import com.magazzino.Database.PrenotazioneDAO;

public class BoundaryMagazziniere {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean exit = false;
		
		while(!exit) {

			mostraMenu();
			System.out.println("Seleziona un operazione: ");
			int scelta = (int) scan.nextInt(); scan.nextLine();
			System.out.println("");

			switch (scelta) {
				case 1:
					consultaPrenotazioni();
					break;
				case 2:
					evadiPrenotazione();
					break;
				case 3:
					System.out.println("Uscita...");
					exit = true;
					break;
				default:
					System.out.println("Opzione non valida, riprova.");
					break;
			}
			
		}
		
		System.out.println("Grazie per aver utilizzato il nostro servizio!");
	
	}
		
	public static void consultaPrenotazioni(){
		System.out.println("===============================");
        System.out.println("      CONSULTA PRENOTAZIONI    ");
        System.out.println("===============================");

        // ATTENZIONE: per poter permettere l'esecuzione del software è stata implementata una versione di "Consulta prenotazioni"
        // che restituisce il numero di prenotazione dell'ultima prenotazione inserita, questo NON corrisponde al reale 
        // comportamento che la funzionalità dovrebbe assumere.
        // vedi nota su pdf per chiarimenti.
        
        try {
        	int numPrenotazione = PrenotazioneDAO.readUltimaPrenotazione();
            System.out.println("Numero di prenotazione da utilizzare: " + numPrenotazione);
            System.out.println("");
        } catch (Exception e) {
			System.out.println("Unexpected exception, riprovare.");
			System.out.println("");
		}
        
		//System.out.println("Operazione attualmente non disponibile.");
		//System.out.println("");
		
	}
	
	public static void evadiPrenotazione(){

		GestioneMagazzino gestioneMagazzino = GestioneMagazzino.getInstance();
		boolean inputValido = false;;
		String esito = "";
		int numPrenotazione = 0;
		
		try {
			
	        System.out.println("===============================");
	        System.out.println("       EVADI PRENOTAZIONE      ");
	        System.out.println("===============================");
	        
	        while(!inputValido) {
		        try {
					System.out.println("Inserisci il numero di prenotazione: ");
					int numPrenotazioneTemp = (int) scan.nextInt(); scan.nextLine();
					numPrenotazione = numPrenotazioneTemp;
					inputValido = true;
		        } catch (InputMismatchException e) {
		        	scan.next();
		        	System.out.println("Errore nell'acquisizione del numero di prenotazione, riprovare.");
		        	System.out.println();
		        }
	        }
		        
			inputValido = false;
			while (!inputValido) {		
				System.out.println("(Assicurati di aver verificato la disponibilità degli articoli richiesti)");
				System.out.println("Premi C per confermare la richiesta oppure R per rifiutare.");
				esito = scan.nextLine();
				if ((esito.contains("R") || esito.contains("C")) && esito.length() == 1) {
					inputValido = true;
				} else {
					System.out.println("Esito non valido, riprovare.");
					System.out.println();
				}
			}

			gestioneMagazzino.evadiPrenotazione(numPrenotazione, esito);
			System.out.println("La prenotazione è stata gestita correttamente.");
			System.out.println("Il cliente è stato notificato via email dell'esito stabilito.");
			System.out.println("");

		} catch (Exception e) {
			System.out.println("Unexpected exception, riprovare.");
			System.out.println("");
		}
	}

	public static void mostraMenu() {
		
        System.out.println("===============================");
        System.out.println("        MENU MAGAZZINIERE      ");
        System.out.println("===============================");
        System.out.println("1. Consulta prenotazioni");
		System.out.println("2. Evadi prenotazione");
		System.out.println("3. Esci");
		System.out.println("===============================");
		
	}
	
}