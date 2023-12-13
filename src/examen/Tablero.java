package examen;

import java.util.Random;

public class Tablero {
	
	// Constante que almacena el tamaño de la cuadrícula
	static final int TAM_TABLERO = 5;
	
	// Estático donde se almacena la variable de la coordenada y del tesoro
	static int yTesoro;
	// Estático donde se almacena la variable de la coordenada x del tesoro
	static int xTesoro;
	
	// Variable donde se almacena la variable de la coordenada y del jugador
	int yJugador = 1;
	
	// Variable donde se almacena la variable de la coordenada x del jugador
	int xJugador = 1;

	// Constructor vacío
	public Tablero() {}
	
	// Función que genera la posición aleatoria del tesoro
	static void generaPosicionTesoro() {
		// Creamos un nuevo objeto Random
		Random rand = new Random();
		
		// Generamos una posición aleatoria y se la asignamos a la y del tesoro
		yTesoro = rand.nextInt(1, 6);
		
		// Generamos una posición aleatoria y se la asignamos a la x del tesoro
		xTesoro = rand.nextInt(1, 6);
	}
	
	// Función que pinta el tablero
	void pintaTablero() {
		// Vamos a pintar las columnas
		for (int i=1; i<=TAM_TABLERO; i++) {
			System.out.print("\t" + i);
		}
		
		// Salto para las columnas
		System.out.println();
		
		// Vamos a pintar las filas
		for (int i=1; i<=TAM_TABLERO; i++) {
			// Colocamos los números
			System.out.print(i);
			// Comprobamos en que posición del eje vertical se encuentra el jugador
			if (xJugador == i) {
				// Según el eje horizontal pintamos los espacios hasta donde se encuentre el jugador
				for (int e=0; e<yJugador; e++) {
					System.out.print("\t");
				}
				// Pintamos la casilla del jugador
				System.out.print("J");
			}
			
			// Doble salto de línea para marcar el espacio entre las filas
			System.out.println();
			System.out.println();
		}
	}

	// Función que mueve al jugador
	int mueveJugador(String movimiento) {
		// Variable donde se almacenará el valor del movimiento
		int valorMovimiento = -1;
		
		// Según el movimiento introducido
		switch (movimiento) {
			// Movimiento hacia arriba
			case "ARRIBA":
				// Si el jugador no está en el límite superior del tablero, sube una casilla
				if (xJugador != 1) {
					xJugador--;
					valorMovimiento = 0;
				}
				break;
			
			// Movimiento hacia abajo
			case "ABAJO":
				// Si el jugador no está en el límite inferior del tablero,, baja una casilla
				if (xJugador != TAM_TABLERO) {
					xJugador++;
					valorMovimiento = 0;
				}
				break;
				
			// Movimiento hacia la izquierda
			case "IZQUIERDA":
				// Si el jugador no está en el límite izquierdo del tablero, se desplaza una casilla a la izquierda
				if (yJugador != 1) {
					yJugador--;
					valorMovimiento = 0;
				}
				break;
				
			// Movimiento hacia la derecha
			case "DERECHA":
				// Si el jugador no está en el límite derecho del tablero, se desplaza una casilla a la derecha
				if (yJugador != TAM_TABLERO) {
					yJugador++;
					valorMovimiento = 0;
				}
				break;
				
			// Cadena incorrecta
			default:
				valorMovimiento = -2;
				break;
		}
		
		// Devolvemos el valor del movimiento
		return valorMovimiento;
	}

	// Función que comprueba si ha encontrado el tesoro
	boolean buscaTesoro() {
		// Variable donde se almacena si se ha encontrado el tesoro
		boolean tesoroEncontrado = false;
		
		// Comprueba si las posiciones del jugador y del tesoro coinciden
		if (yJugador == yTesoro && xJugador == xTesoro) tesoroEncontrado = true;
		
		// Devolvemos si se ha encontrado el tesoro
		return tesoroEncontrado;
	}
}
