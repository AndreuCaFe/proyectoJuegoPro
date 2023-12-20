package Damas;

import java.util.Scanner;

public class JuegoDefinitivo {
	
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
					if(i %2 != 0) {
						num[cont][i] = 2;
					}
				} else if (cont == 6) {
					if (i %2 == 0) {
						num[cont][i] = 2;
					}
				}
				
			}
		}
		
	}

	public static void instruccionesDamas() {
		System.out.println("InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n"
				+ "InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n"
				+ "InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n"
				+ "InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n"
				+ "InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n"
				+ "InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n"
				+ "InstrucionesInstrucionesInstrucionesInstrucionesInstrucionesInstruciones \n");
	}

	public static void movimientoFichas (int[][] tablero, int[] mov, int turno) {
		
		int[] dondeEsta = separarInt(mov[0]);
		int[] dondeVa = separarInt(mov[1]);
		
		if(turno%2 == 1) { // Diferenciar turno de blancas y negras
			
			if(dondeEsta[1]==0) {
				
				if(tablero[dondeEsta[0]-1][dondeEsta[1]+1]==1) {
					
					tablero[dondeVa[0]][dondeVa[1]]=2;
					tablero[dondeEsta[0]][dondeEsta[1]]=0;
					// Si va a la derecha o a la izquierda para borrar la ficha que mata.
					
					if(tablero[dondeEsta[0]-2][dondeEsta[1]-2]==tablero[dondeVa[0]][dondeVa[1]]) {
						tablero[dondeEsta[0]-1][dondeEsta[1]-1]=0;
					} else {
						tablero[dondeEsta[0]-1][dondeEsta[1]+1]=0;
					}
					
				} else {
					tablero[dondeVa[0]][dondeVa[1]]=2;
					tablero[dondeEsta[0]][dondeEsta[1]]=0;
				}
				
			} else if (dondeEsta[1]==7) {
				
				if(tablero[dondeEsta[0]-1][dondeEsta[1]-1]==1) {
					
					tablero[dondeVa[0]][dondeVa[1]]=2;
					tablero[dondeEsta[0]][dondeEsta[1]]=0;
					// Si va a la derecha o a la izquierda para borrar la ficha que mata.
					
					if(tablero[dondeEsta[0]-2][dondeEsta[1]-2]==tablero[dondeVa[0]][dondeVa[1]]) {
						tablero[dondeEsta[0]-1][dondeEsta[1]-1]=0;
					} else {
						tablero[dondeEsta[0]-1][dondeEsta[1]+1]=0;
					}
					
				} else {
					tablero[dondeVa[0]][dondeVa[1]]=2;
					tablero[dondeEsta[0]][dondeEsta[1]]=0;
				}
				
			} else {
				
				// Diferenciar entre si mata o solo mueve
				if(tablero[dondeEsta[0]-1][dondeEsta[1]-1]==1 || tablero[dondeEsta[0]-1][dondeEsta[1]+1]==1) {
					
					tablero[dondeVa[0]][dondeVa[1]]=2;
					tablero[dondeEsta[0]][dondeEsta[1]]=0;
					// Si va a la derecha o a la izquierda para borrar la ficha que mata.
					
					if(tablero[dondeEsta[0]-2][dondeEsta[1]-2]==tablero[dondeVa[0]][dondeVa[1]]) {
						tablero[dondeEsta[0]-1][dondeEsta[1]-1]=0;
					} else {
						tablero[dondeEsta[0]-1][dondeEsta[1]+1]=0;
					}
					
				} else {
					tablero[dondeVa[0]][dondeVa[1]]=2;
					tablero[dondeEsta[0]][dondeEsta[1]]=0;
				}
				
			}
			
		} else { // Negras
			// Diferenciar entre si mata o solo mueve
			if(tablero[dondeEsta[0]+1][dondeEsta[1]-1]==2 || tablero[dondeEsta[0]+1][dondeEsta[1]+1]==2) {
				
				tablero[dondeVa[0]][dondeVa[1]]=1;
				tablero[dondeEsta[0]][dondeEsta[1]]=0;
				// Si va a la derecha o a la izquierda para borrar la ficha que mata.
				if(tablero[dondeEsta[0]+2][dondeEsta[1]-2]==tablero[dondeVa[0]][dondeVa[1]]) {
					tablero[dondeEsta[0]+1][dondeEsta[1]-1]=0;
				} else {
					tablero[dondeEsta[0]+1][dondeEsta[1]+1]=0;
				}
				
			} else {
				tablero[dondeVa[0]][dondeVa[1]]=1;
				tablero[dondeEsta[0]][dondeEsta[1]]=0;
			}
		}
		
	}
	
	public static boolean comprobarMov (int[] mov, int turno, int[][] tablero) {
		
		boolean devuelta = true;
		int[] dondeEsta = separarInt(mov[0]);
		int[] dondeVa = separarInt(mov[1]);
		// Comprobar que el movimiento este dentro de el rango/tablero
		if(dondeEsta[0]<0 || dondeEsta[0]>7 || dondeEsta[1]<0 || dondeEsta[1]>7) {
			return false;
		} else if (dondeVa[0]<0 || dondeVa[0]>7 || dondeVa[1]<0 || dondeVa[1]>7) {
			return false;
		}
		
		if (turno%2 != 0) { //Para saber si es turno de blancas
			
			if(tablero[dondeEsta[0]][dondeEsta[1]] == 2) { // Comprueba que la ficha que quiere mover es blanca
				
				// comprueba que donde quiere mover no haya una ficha ya
				if (tablero[dondeVa[0]][dondeVa[1]] == 1 || tablero[dondeVa[0]][dondeVa[1]] == 2) {
					return false;
					
				} else {
					
					if(dondeEsta[1] == 0) { // si la ficha esta en x-0 comprobamos solo hacia un lado para que no de out of bounce
						
						if(tablero[dondeEsta[0]-1][dondeEsta[1]+1] == 1 && dondeVa[0] == dondeEsta[0]-2 && dondeVa[1] == dondeEsta[1]+2) {
							
						} else if(dondeEsta[0]-1 == dondeVa[0] && dondeEsta[1]+1 == dondeVa[1]) {
							
						} else {
							return false;
						}
						
					} else if(dondeEsta[1] == 7) { // si la ficha esta en x-7 comprobamos solo hacia un lado para que no de out of bounce
						
						if(tablero[dondeEsta[0]-1][dondeEsta[1]-1] == 1 && dondeEsta[0]-1 == dondeVa[0] && dondeEsta[1]-1 == dondeVa[1]) {
							
						} else if (dondeEsta[0]-1 == dondeVa[0] && dondeEsta[1]-1 == dondeVa[1]) {
							
						} else {
							return false;
						}
						
					} else { // Comprueba que el movimiento de la ficha es correcto
						
						if (tablero[dondeEsta[0]-1][dondeEsta[1]-1] == 1 && dondeEsta[0]-2 == dondeVa[0] && dondeEsta[1]-2 == dondeVa[1]) {
							
						} else if(tablero[dondeEsta[0]-1][dondeEsta[0]] == 1 && dondeEsta[0]-2 == dondeVa[0] && dondeEsta[1]+2 == dondeVa[1]) {
							
						} else {
							
							if(dondeEsta[0]-1 == dondeVa[0] && dondeEsta[1]-1 == dondeVa[1]) {
								
							} else if(dondeEsta[0]-1 == dondeVa[0] && dondeEsta[1]+1 == dondeVa[1]) {
								
							} else {
								return false;
							}
							
						}
						
					}
					
				}
				
			} else {
				return false;
			}
			
		} else { // Y si no es turno de blancas es el turno de negras
			
			
			
		}
		
		return devuelta;
	}
	
	public static int[] separarInt (int num) {
		int[] mov = new int[2]; 
		mov[1] = num%10;
		num /= 10;
		mov[0] = num%10;
		return mov;
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
				
				for(int turno = 1; turno > 0; turno++) {
					int[] movimientos = new int[2];
					if(turno%2 != 0) {
						System.out.println("Turno: " + turno + " Blancas");
					} else {
						System.out.println("Turno: " + turno + " Negras");
					}
					System.out.print("Dime tu Movimiento: ");
					movimientos[0] = sc.nextInt(); 
					movimientos[1] = sc.nextInt();
					if(comprobarMov(movimientos, turno, tablero) == false) {
						while(comprobarMov(movimientos, turno, tablero) != true) {
							System.out.println("Movimiento incorrecto! \n");
							System.out.print("Dime tu Movimiento: ");
							movimientos[0] = sc.nextInt(); 
							movimientos[1] = sc.nextInt();
						}
					}
					movimientoFichas(tablero,movimientos,turno);
					imprimirMatriz(tablero);
				}	
				
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
		System.out.println("Adios! :P");
	}

}
