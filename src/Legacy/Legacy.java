/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.RoadNetwork;
import Model.Vehicle;
import System.Error;
import System.Settings;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class Legacy {

	public static void writeFile(String filePath, String text,
								 boolean additional) {
		try {
			File arquivo = new File(filePath);
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo, additional));
			escritor.write(text);
			escritor.close();
		} catch (Exception ex) {
//			//Verificar se dar erro se gravar no ficheiro de log e esse devolver erro
//			System.out.println(Dados.
//				mensagemLog(new StringBuffer("Erro ao gravar no ficheiro ").
//					append(nomeFicheiro).append(" ").append(ex).toString()));
			Error.
				setErrorMessage(new StringBuffer("Error writing to file ").
					append(filePath).append(" ").append(ex).toString());
		}
	}

	public static String readFile(String filePath) {
		try {
			File arquivo = new File(filePath);
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			return new Scanner(arquivo).useDelimiter("\\Z").next();
//			//Forma de leitura do ficheiro oposta a usada para escrita, mais complexa!
//			BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
//			StringBuilder texto = new StringBuilder();
//			String linha;
//			while ((linha = leitor.readLine()) != null) {
//				texto.append(linha);
//			}
//			leitor.close();
//			return texto.toString();
		} catch (Exception ex) {
			Error.
				setErrorMessage(new StringBuffer("Error loading file ").
					append(filePath).append(" ").append(ex).toString());
			return null;
		}
	}

	public static List<Vehicle> importVehicles(String filePath) {
		String data = Legacy.readFile(filePath);
		String extension = filePath.split(".")[filePath.split(".").length - 1];
		List<Object> objects = Settings.loadAllClass(Settings.
			getConfiguration("importVehicles"));
		for (Object object : objects) {
			VehicleImport vehicleImport = (VehicleImport) object;
			if (vehicleImport != null && vehicleImport.getExtension().
				equals(extension)) {
				return vehicleImport.importData(data);

			}
		}
		Error.setErrorMessage("Could not load this extension: ");
		return null;
	}

	public static List<RoadNetwork> importRoadNetwork(String filePath) {
		String data = Legacy.readFile(filePath);
		String extension = filePath.split(".")[filePath.split(".").length - 1];
		List<Object> objects = Settings.loadAllClass(Settings.
			getConfiguration("importRoadNetwork"));
		for (Object object : objects) {
			RoadNetworkImport roadNetworkImport = (RoadNetworkImport) object;
			if (roadNetworkImport != null && roadNetworkImport.getExtension().
				equals(extension)) {
				return roadNetworkImport.importData(data);

			}
		}
		Error.setErrorMessage("Could not load this extension: ");
		return null;
	}

}
