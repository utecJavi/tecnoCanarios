package ejercicio.tres;

import java.util.Scanner;


public class EjercicioTres {
	public static void main(String[] args) {

	    Mascota mascotas[] = new Mascota[3];

	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Ingreso de mascotas");

	    for (int i = 0; i < mascotas.length; i++) {

	        boolean hayError = true;
	        int id = 0, patas = 0;
	        String nombre = "";

	        while (hayError) {

	            try {
	            	System.out.println("-------------------");
	                System.out.println("Mascota id: " + i);
	                id = i;

	                System.out.println("ingrese el nombre de la mascota");
	                nombre = scanner.next();

	                System.out.println("ingrese la cantidad de patas: ");
                	patas = Integer.valueOf(scanner.next());
	                
	                if (patas != 2 && patas != 4) {
	                    throw new Exception("Patas incorrectas");
	                }

	                mascotas[i] = new Mascota(id, patas, nombre);

	                hayError = false;
	            } catch (NumberFormatException ee) {
	            	System.err.println("ERROR: Intentelo de nuevo. La cantidad de patas debe ser un valor numerico ");
	            	
	            } catch (Exception e) {

	                System.err.println("ERROR: Intentelo de nuevo " + e.getMessage() );
	            }

	        }

	    }

	    scanner.close();

	}
	}


