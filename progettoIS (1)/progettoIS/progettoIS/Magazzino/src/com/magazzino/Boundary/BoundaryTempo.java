package com.magazzino.Boundary;

import java.util.Scanner;

import com.magazzino.Control.GestioneMagazzino;

public class BoundaryTempo {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean exit = false;
		
		while(!exit) {

			mostraMenu();
			int scelta = (int) scan.nextInt(); scan.nextLine();
			System.out.println("");

			switch (scelta) {
				case 1:
					generaReport();
					break;
				case 2:
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
		
	public static void generaReport(){
		
		GestioneMagazzino gestioneMagazzino = GestioneMagazzino.getInstance();
		
		try {
			
	        System.out.println("===============================");
	        System.out.println("          GENERA REPORT        ");
	        System.out.println("===============================");
			
			gestioneMagazzino.generaReport();

		} catch (Exception e) {
			System.out.println("Unexpected exception, riprovare.");
			System.out.println();
		}
	}

	public static void mostraMenu() {
		
        System.out.println("===============================");
        System.out.println("            MENU TEMPO         ");
        System.out.println("===============================");
        System.out.println("1. Genera report");
		System.out.println("2. Esci");
		System.out.println("===============================");
		
	}	

}