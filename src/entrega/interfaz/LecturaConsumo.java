package entrega.interfaz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LecturaConsumo {

	public ArrayList<Cliente> lista = new ArrayList<Cliente>();
	public Integer totalMetrosConsumidosFamilia= 0;
	public Integer totalMetrosConsumidosComercial= 0;
	public Double totalGastosFamilia= 0d;
	public Double totalGastosComercial= 0.0;

	public LecturaConsumo(String filename) {
		cargarLista(filename);
	}

	private void cargarLista(String filename) {
		try {

			ArrayList<String> listaRegistro;
			listaRegistro = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
//			System.out.println(listaRegistro);
			cargarConsumo(listaRegistro);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void cargarConsumo(ArrayList<String> listaRegistro) {
		for (String s : listaRegistro) {
			int ind = s.indexOf(",");
			String tipoConsumo = s.substring(0, ind);
			int ultimo = s.length();
			s = s.substring(ind + 1, ultimo);
			ind = s.indexOf(",");
			String nombre = s.substring(0, ind);
			ultimo = s.length();
			s = s.substring(ind + 1, ultimo);
			ind = s.indexOf(",");
			String direccion = s.substring(0, ind);
			ultimo = s.length();
			s = s.substring(ind + 1, ultimo);
			ind = s.indexOf(",");
			String cedulaRut = s.substring(0, ind);
			ultimo = s.length();
			s = s.substring(ind + 1, ultimo);
			ind = s.indexOf(",");
			int metrosConsumidos = Integer.parseInt(s.substring(0));

			if (tipoConsumo.equals("F")) {
				ClienteFamiliar cliente = new ClienteFamiliar(nombre, direccion, cedulaRut, metrosConsumidos);
				lista.add(cliente);

			}

			if (tipoConsumo.equals("C")) {
				ClienteComercial cliente = new ClienteComercial(nombre, direccion, cedulaRut, metrosConsumidos);
				lista.add(cliente);

			}

		}
		for (Cliente cli : lista) {
			System.out.println(cli.toString());
			if (cli instanceof ClienteFamiliar) {
				totalMetrosConsumidosFamilia= totalMetrosConsumidosFamilia+((ClienteFamiliar)(cli)).getMetrosConsumidos();
				totalGastosFamilia=totalGastosFamilia+((ClienteFamiliar)(cli)).calcularGastoDeConsumo();
			}
			if (cli instanceof ClienteComercial) {
				totalMetrosConsumidosComercial= totalMetrosConsumidosComercial+((ClienteComercial)(cli)).getMetrosConsumidos();
				totalGastosComercial=totalGastosComercial+((ClienteComercial)(cli)).calcularGastoDeConsumo();
				
			}
			
		
					

		}
		System.out.println("Cliente familiar, el total de metros cubicos es: "+totalMetrosConsumidosFamilia+" y el total de gastos es de: $"+totalGastosFamilia);
		System.out.println("Cliente comercial, el total de metros cubicos es: "+totalMetrosConsumidosComercial+" y el total de gastos es de: $"+totalGastosComercial);
		

	}

}
