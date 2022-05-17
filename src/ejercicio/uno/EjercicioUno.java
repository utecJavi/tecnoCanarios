package ejercicio.uno;

import java.util.Scanner;

public class EjercicioUno {

	public static void main(String[] args) {

		String nombrePersonas[] = { "Marcos", "Maxi", "Javier", "Luciano", "Danny" };

		System.out.println("La lista de nombres va desde 0 a 4");

		while  (true) {

			System.out.println("A que posicion de la lista de nombres quiere acceder?");
			try {

				Scanner sc = new Scanner(System.in);
				int eleccionDeUsuario = sc.nextInt();
				System.out.println("El nombre de la persona es: " + nombrePersonas[eleccionDeUsuario]);

				

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("No se puede elegir un numero mayor de 4");

			}

		}

	}

}
