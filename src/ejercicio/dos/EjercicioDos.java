package ejercicio.dos;

import java.util.Scanner;

public class EjercicioDos {

	public static void main(String[] args) {

		Integer numeros[] = new Integer[5];
		Integer numerosValidos = 0;
		Integer numerosInValidos = 0;
		Integer suma = 0;

		System.out.println("ingrese 5 numeros: ");

		for  (int i = 0; i<numeros.length; i++) {

 			System.out.println("Ingrese la posicion "+ i);
			try {

				Scanner sc = new Scanner(System.in);
				int eleccionDeNumero = sc.nextInt();
				numeros[i] = eleccionDeNumero;
				System.out.println("Usted ingreso el numero " + numeros[i]);
				numerosValidos++;
				suma = suma + numeros[i];
				
				
			} catch (Exception e) {
				System.out.println("Solo se puede ingresar un valor numerico");
				numeros[i] = 0;
				numerosInValidos++;
				

			}

		}
		System.out.println("La suma del array es  "+ suma);
		System.out.println("La cantidad de numeros validos es "+ numerosValidos);
		System.out.println("La cantidad de numeros invalidos es "+ numerosInValidos);
			
	}

}
