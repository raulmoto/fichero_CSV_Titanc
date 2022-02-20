package juegoDelavida;

import java.io.IOException;
import java.util.Scanner;

public class vida {
	
	/**
	 * Pre: ---
	 * Post: esta clase Java implementa un m�todo main
	 * 		 que pide al usuario datos para con ellos  dimensionar un tablero segun 
	 *       el numero de filas y columnas indique el usuario y a continuacion se inicia el juago que
	 *       consiste en comparar las leluas vivas que tiende cada celda en su alrededor y de a corde a
	 *       eso ir evolucionadno en cada generacion.
	 */

	static Scanner scn = new Scanner(System.in);

	public static void generaciones(String[][] tabla, int generaciones) {

		/*
		 * cuando el usuario le da a iniciar el juego, desde el main se llama a este
		 * metodo n donde se crea la tabla copia, en esta tabla guardaremis los cambios
		 * se van a realizar dela tabla principal o tabla original.
		 */
		String[][] tablacopia = new String[tabla.length][tabla[0].length];
		int generacion = 0;
		// se inicia un bucle que se ejecuta tantas veces como el usuario especifica.
		// en el bucle accedemos al metodo comprobar vidas que es donde hacermos las
		// comprobaciones de cada celca y el resultado se devolvera otravez
		// al metodo generaciones.
		for (int x = 0; x <= generaciones; x++) {// bucle de generaciones
			System.out.println(generacion + " generacion");
			for (int a = 0; a < tabla.length; a++) {
				for (int b = 0; b < tabla.length; b++) {
					tablacopia = comprobarvidas(tabla, tablacopia);
					tabla[a][b] = tablacopia[a][b];
					System.out.print("[");
					System.out.print(tabla[a][b]);
					System.out.print(" ");

				}
				System.out.println("]");

			}
			System.out.println();
			generacion++;

		}

		System.out.println();
		System.out.println(
				"como lo habras notado, en cada generacion las celuas nacen o mueren segun la situacion en la que se encuentren\n"
						+ "y si van evolucioando hasta la generacion que que hallas marcado.");
		System.out.println("");
		System.out.println("Que te ha parecido?");
		System.out.println("");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------");

	}

	// en este metodo realizamos las comprobaciones necesarias para que el juego
	// funcione correctamente.
	public static String[][] comprobarvidas(String[][] tabla, String[][] tablacopia) {

		// recorremos la tabla para comprobar cada posicion
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {

				// empezamos a recorrer el tablero y en cada caso "celusa civas o muertas"
				// comprobamos cuantos vecinos
				// vivos tienen.

				int vida = 0;
				if (i == 0 && j == 0) {

					if (tabla[i][j + 1].equals("*")) {
						vida++;

					}

					if (tabla[i + 1][j].equals("*")) {
						vida++;

					}
					if (tabla[i + 1][j + 1].equals("*")) {
						vida++;

					}
					// contamos las celulas vecinas

					if (vida < 2 || vida > 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = ".";
					} else if (vida == 2 || vida == 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = "*";
					} else if (vida == 3 && tabla[i][j].equals(".")) {
						tablacopia[i][j] = "*";

					}

				}

				// lateral superior------------------------------------------------------
				vida = 0;
				if (i == 0 && j != 0 && j < tabla.length - 1) {

					if (tabla[i][j - 1].equals("*")) {
						vida++;

					}

					if (tabla[i + 1][j - 1].equals("*")) {
						vida++;

					}
					if (tabla[i + 1][j].equals("*")) {
						vida++;

					}
					if (tabla[i + 1][j + 1].equals("*")) {
						vida++;

					}
					if (tabla[i][j + 1].equals("*")) {
						vida++;

					}

					// contamos las celulas vecinas

					if (vida < 2 || vida > 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = ".";
					} else if (vida == 2 || vida == 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = "*";
					} else if (vida == 3 && tabla[i][j].equals(".")) {
						tablacopia[i][j] = "*";

					}

				}

				vida = 0;// lateral izquierdo----------------------------------------------------------
				if (i != 0 && j == 0 && i < tabla.length - 1) {

					if (tabla[i - 1][j + 1].equals("*")) {
						vida++;

					}

					if (tabla[i - 1][j + 1].equals("*")) {
						vida++;

					}
					if (tabla[i][j + 1].equals("*")) {
						vida++;

					}
					if (tabla[i + 1][j + 1].equals("*")) {
						vida++;

					}
					if (tabla[i + 1][j].equals("*")) {

					}

					// contamos las celulas vecinas

					if (vida < 2 || vida > 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = ".";
					} else if (vida == 2 || vida == 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = "*";
					} else if (vida == 3 && tabla[i][j].equals(".")) {
						tablacopia[i][j] = "*";

					}

				}

				// centro1----------------------------------------------------------------------------------------------
				vida = 0;
				if (i != 0 && j == 0 && i != tabla.length - 1) {

					if (tabla[i - 1][j].equals("*")) {
						vida++;

					}

					if (tabla[i - 1][j + 1].equals("*")) {
						vida++;

					}
					if (tabla[i][j + 1].equals("*")) {
						vida++;

					}
					if (tabla[i + 1][j + 1].equals("*")) {
						vida++;

					}
					if (tabla[i + 1][j].equals("*")) {
						vida++;

					}

					// contamos las celulas vecinas

					if (vida < 2 || vida > 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = ".";
					} else if (vida == 2 || vida == 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = "*";
					} else if (vida == 3 && tabla[i][j].equals(".")) {
						tablacopia[i][j] = "*";

					}
				}

				// --------------------------------------------------------CENTRO sin la fila
				// izquierda, superior , inferior
				vida = 0;
				if (i != 0 && j != 0 && i != tabla.length - 1 && j != tabla.length - 1) {

					if (tabla[i - 1][j].equals("*")) {
						vida++;

					}

					if (tabla[i - 1][j + 1].equals("*")) {
						vida++;

					}
					if (tabla[i][j + 1].equals("*")) {
						vida++;

					}
					if (tabla[i + 1][j + 1].equals("*")) {
						vida++;

					}
					if (tabla[i + 1][j].equals("*")) {
						vida++;

					}

					if (tabla[i][j - 1].equals("*")) {
						vida++;

					}

					// contamos las celulas vecinas

					if (vida < 2 || vida > 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = ".";
					} else if (vida == 2 || vida == 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = "*";
					} else if (vida == 3 && tabla[i][j].equals(".")) {
						tablacopia[i][j] = "*";

					}
				}

				// lateral
				// derecho---------------------------------------------------------------------------------------------
				vida = 0;
				if (i != 0 && j == tabla.length - 1 && i != tabla.length - 1) {

					if (tabla[i - 1][j].equals("*")) {
						vida++;

					}

					if (tabla[i - 1][j - 1].equals("*")) {
						vida++;

					}
					if (tabla[i - 1][j].equals("*")) {
						vida++;

					}
					if (tabla[i + 1][j].equals("*")) {
						vida++;

					}
					// contamos las celulas vecinas

					if (vida < 2 || vida > 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = ".";
					} else if (vida == 2 || vida == 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = "*";
					} else if (vida == 3 && tabla[i][j].equals(".")) {
						tablacopia[i][j] = "*";

					}

				}

				// lateral
				// inferior-------------------------------------------------------------------------------------------------------
				vida = 0;
				if (j != 0 && j != tabla.length - 1 && i == tabla.length - 1) {

					if (tabla[i][j - 1].equals("*")) {
						vida++;

					}

					if (tabla[i - 1][j - 1].equals("*")) {
						vida++;

					}
					if (tabla[i - 1][j].equals("*")) {
						vida++;

					}
					if (tabla[i - 1][j + 1].equals("*")) {
						vida++;

					}
					if (tabla[i][j + 1].equals("*")) {
						vida++;

					}

					// contamos las celulas vecinas

					if (vida < 2 || vida > 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = ".";
					} else if (vida == 2 || vida == 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = "*";
					} else if (vida == 3 && tabla[i][j].equals(".")) {
						tablacopia[i][j] = "*";

					}

				}

				vida = 0;

				// angulo final superior derecho
				if (i == 0 && j == tabla.length - 1) {
					if (tabla[i][j - 1].equals("*")) {
						vida++;

					}
					if (tabla[i + 1][j].equals("*")) {
						vida++;

					}

					if (tabla[i + 1][j - 1].equals("*")) {
						vida++;

					}

					// contamos las celulas vecinas

					if (vida < 2 || vida > 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = ".";
					} else if (vida == 2 || vida == 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = "*";
					} else if (vida == 3 && tabla[i][j].equals(".")) {
						tablacopia[i][j] = "*";

					}

				}

				vida = 0;

				// angulo inferior final izquierdo
				if (i == tabla.length - 1 && j == 0) {
					if (tabla[i][j + 1].equals("*")) {
						vida++;

					}

					if (tabla[i - 1][j].equals("*")) {
						vida++;

					}

					if (tabla[i - 1][j + 1].equals("*")) {
						vida++;

					}

					// contamos las celulas vecinas

					if (vida < 2 || vida > 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = ".";
					} else if (vida == 2 || vida == 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = "*";
					} else if (vida == 3 && tabla[i][j].equals(".")) {
						tablacopia[i][j] = "*";

					}

				}

				vida = 0;

				// angulo final derecho

				if (i == tabla.length - 1 && j == tabla.length - 1) {
					if (tabla[i][j - 1].equals("*")) {
						vida++;

					}

					if (tabla[i - 1][j].equals("*")) {
						vida++;

					}

					if (tabla[i - 1][j - 1].equals("*")) {
						vida++;

					}

					// contamos las celulas vecinas

					if (vida < 2 || vida > 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = ".";
					} else if (vida == 2 || vida == 3 && tabla[i][j].equals("*")) {
						tablacopia[i][j] = "*";
					} else if (vida == 3 && tabla[i][j].equals(".")) {
						tablacopia[i][j] = "*";

					}

				}

			}

		}
		return tablacopia;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// el programa inicia en el main.
		// lo primero que hago es crear la tabla bidimensional llanada tabla, el scanner
		// y solicitar al usuario especificar la dimension
		// que quisera que tenga el tablero.
		/*
		 * el tablero tendra F filas y C columnas segun indique el usuario. creo un
		 * metodo ramdom del 1 al 100 para rellenar el tablero y los guardo en una
		 * variable llamada aleatorio. Si el numero es mayor al 80% en la tabla se
		 * rellena con un asterisco en dicha posicion y si no es asi pues se rellena con
		 * un pinto ".", cuando el usuario inicia el juego para ver el numero de
		 * generaciones el progarma llam al metodo generaciones que es donde se realiza
		 * el bucle tantas veces como generacions pida ver el usuaio.
		 */
		System.out.println("Bienvenid@ al juego de la vida!!, soy Raul y sere tu guia durante el juego.");
		System.out.println("");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------");
		System.out.println("que quieres hacer ?:");
		System.out.println("");
		System.out.println("1.ver las reglas del juego.");
		System.out.println("2.saber mas sobre el juego.");
		System.out.println("3.iniciar juego.");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------");
		int respuesta = scn.nextInt();
		if (respuesta == 1) {

			System.out.println(
					"------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"Cada celda puede estar o vac�a o habilitada por una �nica c�lula viva. Cada celda, excepto \r\n"
							+ "las de la periferia, tiene 8 celdas vecinas: todas sus celdas adyacentes (que la rodean).\n"
							+ "Cada cierto tiempo, ocurre una renovaci�n generacional de las c�lulas siguiendo las normas \r\n"
							+ "que se citan a continuaci�n:\n"
							+ "# Una c�lula viva muere de inanici�n si en las celdas vecinas a la que ocupa hay \r\n"
							+ "menos de 2 c�lulas vivas.\n"
							+ "# Una c�lula viva sobrevive sin en las celdas vecinas o la que ocupa has 2 o 3 c�lulas \r\n"
							+ "vivas.\n"
							+ "# Una c�lula viva muere por superpoblaci�n si en las celdas vecinas a la que ocupa \r\n"
							+ "hay m�s de tres c�lulas vivas.\n"
							+ "\n  # En una celda vac�a puede nacer, por reproducci�n, una c�lula viva si en las celdas \r\n"
							+ "vecinas hay exactamente tres c�lulas vivas.");
			System.out.println(
					"------------------------------------------------------------------------------------------------------------");

		} else if (respuesta == 2) {
			System.out
					.println("El Juego de la vida es un aut�mata celular dise�ado por el matem�tico brit�nico John \r\n"
							+ "Horton Conway en 1970.\r\n"
							+ "Hizo su primera aparici�n p�blica en el n�mero de octubre de 1970 de la revista Scientific \r\n"
							+ "American, en la columna de juegos matem�ticos de Martin Gardner. Desde un punto de \r\n"
							+ "vista te�rico, es interesante porque es equivalente a una m�quina universal de Turing, es \r\n"
							+ "decir, todo lo que se puede computar algor�tmicamente se puede computar en el juego de \r\n"
							+ "la vida.\r\n"
							+ "Desde su publicaci�n, ha atra�do mucho inter�s debido a la gran variabilidad de la evoluci�n \r\n"
							+ "de los patrones. Se considera que el Juego de la vida es un buen ejemplo \r\n"
							+ "de emergencia y autoorganizaci�n.\r\n"
							+ "Es interesante para cient�ficos, matem�ticos, economistas y otros observar c�mo patrones \r\n"
							+ "complejos pueden provenir de la implementaci�n de reglas muy sencillas.\r\n"
							+ "El Juego de la vida tiene una variedad de patrones reconocidos que provienen de \r\n"
							+ "determinadas posiciones iniciales. Poco despu�s de la publicaci�n, se descubrieron \r\n"
							+ "el pentamin� R, el planeador o caminador (en ingl�s, glider, conjunto de c�lulas que se \r\n"
							+ "desplazan) y el explosionador (c�lulas que parecen formar la onda expansiva de una \r\n"
							+ "explosi�n), lo que atrajo un mayor inter�s hacia el juego. \r\n"
							+ "Para muchos aficionados, el juego de la vida solo era un desaf�o de programaci�n y una \r\n"
							+ "manera divertida de usar ciclos de la CPU.\r\n"
							+ "1 Para otros, sin embargo, el juego adquiri� m�s \r\n" + "connotaciones filos�ficas.");

		} else if (respuesta == 3) {

			System.out.println("inserte el numero de filas para el tablero");
			int f = scn.nextInt();
			System.out.println("inserte el numero de columnas para el tablero");
			int c = scn.nextInt();
			System.out.println("inserte el numero de generaciones");
			int generaciones = scn.nextInt();
			String[][] tabla = new String[f][c];

			String[][] tablacopia2 = new String[tabla.length][tabla[0].length];

			for (int i = 0; i < tabla.length; i++) {
				for (int j = 0; j < tabla.length; j++) {
					int aleatorio = (int) (Math.random() * (100 - 1 + 1) + 1);
					if (aleatorio > 80) {
						tabla[i][j] = "*";
					} else {
						tabla[i][j] = ".";
					}
					System.out.print("[");
					System.out.print(tabla[i][j]);
					System.out.print(" "); // el espacio etre las filas
				} // debajo del segundo bucle
				System.out.println("]");
			}

			System.out.println("desea ver como han evolucionado? pulse 1 para haceptar o pulse 2 para volver a Inicio");
			int resp = scn.nextInt();
			if (resp == 1) {
				generaciones(tabla, generaciones);
			} else if (resp == 2) {
				main(args);
			}

		}
		main(args);
	}

}
