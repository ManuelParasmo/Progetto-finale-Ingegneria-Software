package com.magazzino.Boundary;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.magazzino.Control.GestioneMagazzino;

public class BoundaryCliente {

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
					effettuaPrenotazione();
					break;
				case 2:
					effettuaPagamento();
					break;
				case 3:
					System.out.println("Uscita...");
					exit = true;
					break;
				default:
					System.out.println("Opzione non valida, riprova.");
					System.out.println("");
					break;
			}
			
		}
		
		System.out.println("Grazie per aver utilizzato il nostro servizio!");
	
	}
		
	public static void effettuaPrenotazione(){
		
		ArrayList<Integer> idAttrezzature;
		GestioneMagazzino gestioneMagazzino = GestioneMagazzino.getInstance();
		String nome = null, cognome = null, email = null;
		String documento = null, telefono = null, residenza = null;
		boolean inputValido = false;
		String conferma = null;
		
		try {
			
	        System.out.println("===============================");
	        System.out.println("      EFFETTUA PRENOTAZIONE    ");
	        System.out.println("===============================");
			idAttrezzature = selezionaAttrezzature();
			float prezzoTot = gestioneMagazzino.effettuaPrenotazione(idAttrezzature);
			
			while (!inputValido) {
				
				System.out.println("Il prezzo totale per il noleggio è: " + prezzoTot + "£");
				System.out.println("Procedere con la prenotazione?");
				System.out.println("Premi Y per confermare o qualsiasi altro tasto per uscire: ");
				conferma = scan.nextLine();
				
				if (conferma.toUpperCase().equals("Y")){
					
					while (!inputValido) {
						try {							
							System.out.println("Inserisci il nome: ");
							String nomeTemp = scan.nextLine();
							nome = String.valueOf(nomeTemp);		
							System.out.println("Inserisci il cognome: ");
							String cognomeTemp = scan.nextLine();
							cognome = String.valueOf(cognomeTemp);	
							inputValido = true;							
						} catch (NullPointerException e) {
							System.out.println("Errore nell'acquisizione di nome e cognome, riprovare.");
							System.out.println();
						}
					}
					
					inputValido = false;
					while (!inputValido) {						
						System.out.println("Inserisci la email: ");
						email = scan.nextLine();
						if (email.contains("@") && email.contains(".")) {
							inputValido = true;
						} else {
							System.out.println("Email non valida, riprovare.");
							System.out.println();
						}
					}
					
					inputValido = false;
					while (!inputValido) {
						System.out.println("Inserisci il documento (Codice documento di identità - 9 caratteri): ");
						documento = scan.nextLine();
						if (documento.length() == 9) {
							inputValido = true;
						} else {
							System.out.println("Documento non valido, riprovare.");
							System.out.println();
						}
					}
					
					inputValido = false;
					while (!inputValido) {
						System.out.println("Inserisci il numero di telefono: ");
						telefono = scan.nextLine();
						if (telefono.length() == 10) {
							inputValido = true;
						} else {
							System.out.println("Numero di telefono non valido, riprovare.");
							System.out.println();
						}
					}
					
					inputValido = false;
					while (!inputValido) {
						try {
							System.out.println("Inserisci la residenza: ");
							String residenzaTemp = scan.nextLine();
							residenza = String.valueOf(residenzaTemp);
							inputValido = true;
						} catch (NullPointerException e) {
							System.out.println("Errore nell'acquisizione della residenza, riprovare.");
							System.out.println("");
						}
					}
					
					gestioneMagazzino.confermaPrenotazione(nome, cognome, email, documento, telefono, residenza, idAttrezzature);
					System.out.println("Richiesta di prenotazione inviata con successo.");
					System.out.println("Riceverai presto l'esito sulla email indicata.");
					System.out.println("");
				}
				
				else{
					System.out.println("Richiesta di prenotazione annullata.");
					System.out.println("");
					break;
				}
				
			}

		} catch (Exception e) {
			System.out.println("Unexpected exception, riprovare.");
			System.out.println("");
		}
		
	}
	
	public static ArrayList<Integer> selezionaAttrezzature() {
		ArrayList<Integer> idAttrezzature = new ArrayList<Integer>();
		idAttrezzature.add(1);
		idAttrezzature.add(2);
		idAttrezzature.add(3);
		try {
			System.out.println("Selezione delle attrezzatura in corso...");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Le attrezzature selezionate sono state aggiunte alla prenotazione.");
		} catch (Exception e) {
			System.out.println("Unexpected exception, riprovare.");
			System.out.println("");
		}	
		return idAttrezzature;
	}
	
	public static void effettuaPagamento(){
		
		try {
	        System.out.println("===============================");
	        System.out.println("       EFFETTUA PAGAMENTO      ");
	        System.out.println("===============================");
			System.out.println("Stiamo cercando la tua richiesta di prenotazione...");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Richiesta di prenotazione trovata, procedere con il pagamento?");
			System.out.println("Premi Y per confermare o qualsiasi altro tasto per uscire: ");
			String conferma = scan.nextLine();
			if (conferma.toUpperCase().equals("Y")){
				System.out.println("Pagamento in corso...");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Pagamento confermato.");
				System.out.println("Riceverai a breve un riepilogo della tua prenotazione sulla email indicata.");
				System.out.println("");
			}
			else {
				System.out.println("Pagamento annullato.");
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("Unexpected exception, riprovare.");
			System.out.println("");
		}
		
	}

	public static void mostraMenu() {
		
        System.out.println("===============================");
        System.out.println("          MENU CLIENTE         ");
        System.out.println("===============================");
        System.out.println("1. Effettua prenotazione");
		System.out.println("2. Effettua pagamento");
		System.out.println("3. Esci");
		System.out.println("===============================");
		
	}
	
}
