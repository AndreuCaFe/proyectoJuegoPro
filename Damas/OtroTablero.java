package Damas;

import java.util.Scanner;

public class OtroTablero {

	public static void imprimirMatriz(int[][] num) {
		
		// Pinta el indice superior
		for(int cont = 0; cont < 2; cont++) {
			for(int primeralinea = 0; primeralinea < 8; primeralinea++) {
				if(cont == 0) {
					if(primeralinea == 0) {
						System.out.print("    ");
					}
					System.out.print( primeralinea + "   ");
				}
			} 
		}
		System.out.println("");
		// Pinta el tablero 
		for(int cont = 0; cont< num.length; cont++) {
			
			// Lineas horizontales entre las fichas
			for(int i = 0; i < num[0].length; i++) {
				
				if(i == 0) {
					System.out.print("  ╋");
				}
				
				System.out.print("━━━╋");				
				
			} System.out.println("");
			
			// Fichas y lineas verticales
			for(int i = 0; i < num[0].length; i++) {
				if(i == 0) {
					System.out.print(cont + " ┃");
				}
				
				if (num[cont][i] == 0) {
					System.out.print("   ┃");
				} else {
					
					if(num[cont][i] == 1) {
						System.out.print(" ● ┃");
					} else {
						System.out.print(" ○ ┃");
					}
					
				}
				 	 
			} System.out.println("");
			
			// Ultima linea
			if(cont == num.length-1) {
				for(int i = 0; i < num[0].length; i++) {
					
					if(i == 0) {
						System.out.print("  ╋");
					}
					
					System.out.print("━━━╋");				
					
				} System.out.println("");;
			}
			
			
		}
		
	}

	public static void rellenarMatriz(int[][] num) {
		Scanner sc = new Scanner(System.in);
		
		for(int cont = 0; cont< num.length; cont++) {
			for(int i = 0; i < num[0].length; i++) {
				
				// Todos los espacios donde no haya ficha sera cero
				num[cont][i] = 0;
				
				// colocar fichas negras
				if(cont == 0 || cont == 2) {
					if(i %2 == 0) {
						num[cont][i] = 1;
					}
				} else if (cont == 1) {
					if (i %2 != 0) {
						num[cont][i] = 1;
					}
				}
				//colocar fichas blancas
				if(cont == 5 || cont == 7) {
					if(i %2 == 0) {
						num[cont][i] = 2;
					}
				} else if (cont == 6) {
					if (i %2 != 0) {
						num[cont][i] = 2;
					}
				}
				
			}
		}
		
	}

	public static void main(String[] args) {
		
		int[][] tablero = new int[8][8];
		rellenarMatriz(tablero);
		imprimirMatriz(tablero);

	}

}
