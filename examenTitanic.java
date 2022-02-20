import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class examenTitanic {
	
	/**
	 * Pre: 
	 * Post:coge la ruta en la que se encuentra el archivo para ser leido. hace las comprobaciones necesarias
	 * para verificar la cantidad de hombre abordo y mujeres, asi como hombre sy mujeres muertas en el incidente.
	 */

	public static void leer(String ruta, String palabra, String palabra2) {
		// creo el metodo leer y le paso los valores del main.
		// creo el objeto.
		// creo los iteradores para los datos que vamos a contar
		File ubicacion = new File(ruta);
		int contador = 0;
		int mujeres = 0;
		int contadorhombre = 0;

		int hombresMuertos = 0;
		int hombresvivos = 0;

		int mujeresMuertas = 0;
		int mujeresVIvas = 0;
		try {
			// los datos que de la ruta lo capturamos con el Scanner
			Scanner scn = new Scanner(ubicacion);
			// iniciamos el bucle para recorrer las filas.

			while (scn.hasNextLine()) {
				String dato = scn.nextLine();
				String[] lineaSep = dato.split(",");
				for (int i = 3; i < lineaSep.length; i++) {

					if (lineaSep[i].equalsIgnoreCase(palabra)) {
						mujeres++;
					} else if (lineaSep[i].equalsIgnoreCase(palabra2)) {
						contadorhombre++;
					}
					if (i == 4) {
						contador++;
						// System.out.println(lineaSep[i]); lista de pasajeros

						// hacemos las comparaciones
						// si en la posicion 0 al leerlo encontramos un genero femenino, contamos
						// lo mismo hacemos con los hombres
					}

					if (lineaSep[1].equalsIgnoreCase("0") && lineaSep[i].equalsIgnoreCase("female")) {
						mujeresMuertas++;
					} else if (lineaSep[1].equalsIgnoreCase("1") && lineaSep[i].equalsIgnoreCase("female")) {
						mujeresVIvas++;

					}
					if (lineaSep[1].equalsIgnoreCase("0") && lineaSep[i].equalsIgnoreCase("male")) {
						hombresMuertos++;

					} else if (lineaSep[1].equalsIgnoreCase("1") && lineaSep[i].equalsIgnoreCase("male")) {
						hombresvivos++;
					}

				}
				// System.out.println(dato);
				// imprimimos los resultados

			}
			System.out.println();
			System.out.println("En el titanic habian " + contador + " pasejeros abordo");
			System.out.println(mujeres + " mujeres abordo");
			System.out.println(contadorhombre + " hombres abordo");
			System.out.println(mujeresMuertas + " Mujeres murieron en aquel incidente");
			System.out.println(mujeresVIvas + " Mujeres se salvaron en aquel incidente");
			System.out.println(hombresMuertos + " hombres murieron en aquel incidente");
			System.out.println(hombresvivos + " hombres sobrevivieron en aquel incidente");
			System.out.println(((hombresMuertos * 100) / (hombresvivos + hombresMuertos)) + " %  de hombres muertos");
			System.out.println(((mujeresMuertas * 100) / (mujeresVIvas + mujeresMuertas)) + " %  de mujeres muertas");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// primero le paso la ruta en donde esta el archivo y le indico los valores a
		// buscar
		String ruta = "C:/Users/RAUL-CDH/Desktop/titanic.txt";
		String fememino = "female";
		String masculino = "male";
		leer(ruta, fememino, masculino);

	}

}
