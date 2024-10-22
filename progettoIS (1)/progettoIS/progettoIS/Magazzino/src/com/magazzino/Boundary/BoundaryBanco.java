package com.magazzino.Boundary;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.magazzino.Control.GestioneMagazzino;

public class BoundaryBanco {

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
					registraConsegna();
					break;
				case 2:
					registraRestituzione();
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
		
	public static void registraConsegna(){
		
		GestioneMagazzino gestioneMagazzino = GestioneMagazzino.getInstance();
		boolean inputValido = false;
		int numPrenotazione = 0;
		
		try {
			
	        System.out.println("===============================");
	        System.out.println("       REGISTRA CONSEGNA       ");
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
			
			gestioneMagazzino.registraConsegna(numPrenotazione);

		} catch (Exception e) {
			System.out.println("Unexpected exception, riprovare.");
			System.out.println();
		}
		
	}
	
	public static void registraRestituzione(){
		
		System.out.println("===============================");
        System.out.println("       REGISTRA RESTITUZIONE   ");
        System.out.println("===============================");

		System.out.println("Operazione attualmente non disponibile.");
		System.out.println("");
		
	}

	public static void mostraMenu() {
		
        System.out.println("===============================");
        System.out.println("           MENU BANCO          ");
        System.out.println("===============================");
        System.out.println("1. Registra consegna");
		System.out.println("2. Registra restituzione");
		System.out.println("3. Esci");
		System.out.println("===============================");
		
	}
	
}