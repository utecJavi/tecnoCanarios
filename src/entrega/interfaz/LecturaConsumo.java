package entrega.interfaz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LecturaConsumo {

	public ArrayList<Cliente> lista = new ArrayList<Cliente>();

	public LecturaConsumo(String filename) {
		cargarLista(filename);
	}

	private void cargarLista(String filename) {
		try {

			ArrayList<String> listaRegistro;
			listaRegistro = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
			System.out.println(listaRegistro);
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

			Double gastoConsumo = 0.0;

			if (tipoConsumo.equals("F")) {
				ClienteFamiliar cliente = new ClienteFamiliar(nombre, direccion, cedulaRut, metrosConsumidos);
				gastoConsumo = cliente.calcularGastoDeConsumo();
				lista.add(cliente);

			}

			if (tipoConsumo.equals("C")) {
				ClienteComercial cliente = new ClienteComercial(nombre, direccion, cedulaRut, metrosConsumidos);
				gastoConsumo = cliente.calcularGastoDeConsumo();
				lista.add(cliente);

			}

		}
		for(Cliente cli:lista) {
			System.out.println(cli.toString());
		}

	}

}
