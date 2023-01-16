package restApi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.management.RuntimeErrorException;

public class apiRest {

	public static void main(String[] args) throws IOException {

		// solicitar peticion
		URL url = new URL("https://pokeapi.co/api/v2/pokemon/1");
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		conexion.connect();

		// peticion correcta
		int resp = conexion.getResponseCode();
		if (resp != 200) {
			throw new RuntimeErrorException(null, "ocurrio un error " + resp);
		} else {
			// Leer datos
			StringBuilder info = new StringBuilder();
			Scanner scaner = new Scanner(url.openStream());

			while (scaner.hasNext()) {
				info.append(scaner.nextLine());
			}
			scaner.close();
			// mostrar datos
			System.out.println(info);
		}
	}
}