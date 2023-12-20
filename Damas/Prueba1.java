package Damas;

import java.util.Scanner;

public class Prueba1 {
	
	public static void instruccionesDamas() {
		System.out.println("InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n"
				+ "InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n"
				+ "InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n"
				+ "InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n"
				+ "InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n"
				+ "InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n"
				+ "InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n");
	}
	
	public static void imprimirMatriz(int[][] num) {
		// Pinta el indice superior
		for(int cont = 0; cont < 2; cont++) {
			for(int primeralinea = 0; primeralinea < 8; primeralinea++) {
				if(cont == 0) {
					if(primeralinea == 0) {
						System.out.print("  ║ ");
					}
					System.out.print( primeralinea + " ");
				} else if (cont == 1) {
					if(primeralinea== 0) {
						System.out.print("══╬═");
					}
					System.out.print("══");
				}
			} System.out.println("");
		}
		
		// Pinta el tablero 
		for(int cont = 0; cont< num.length; cont++) {
			
			for(int i = 0; i < num[0].length; i++) {
				
				if(i == 0) {
					System.out.print(cont + " ║ ");
				}
				
				if (num[cont][i] == 0) {
					System.out.print(" |");
				} else {
					System.out.print( num[cont][i] + "|");
				}
				 	 
			}			
			System.out.println("");
		}
		
	}

	public static void rellenarMatriz(int[][] num) {
		Scanner sc = new Scanner(System.in);
		
		for(int cont = 0; cont< num.length; cont++) {
			for(int i = 0; i < num[0].length; i++) {
				
				num[cont][i] = 0;
				
				num[cont][cont] = 1;
				
				num[cont][num.length -1 -cont] = 2;
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¡Bienvenido!");
		System.out.println("-------------------------");
		System.out.println("[1]Instrucciones");
		System.out.println("[2]Nueva Partida");
		System.out.println("[0]Salir");
		System.out.println("-------------------------");
		System.out.print("Seleccione: ");
		int seleccionador = sc.nextInt();
		System.out.println("");
		while(seleccionador != 0) {
			
			if(seleccionador == 1) {
				instruccionesDamas();
			}
			
			if(seleccionador == 2) {
				int[][] tablero = new int[8][8];
				rellenarMatriz(tablero);
				imprimirMatriz(tablero);
				
			}
			System.out.println("");
			System.out.println("-------------------------");
			System.out.println("[1]Instrucciones");
			System.out.println("[2]Nueva Partida");
			System.out.println("[0]Salir");
			System.out.println("-------------------------");
			System.out.print("Seleccione: ");
			seleccionador = sc.nextInt();
			System.out.println("");
		}
		
		
		
	}

}
