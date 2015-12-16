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
import System.Util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class Legacy {

	public static String getExtension(String filePath) {
		return filePath.substring(filePath.lastIndexOf(".")).replace(".", "");
	}

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
		} catch (Exception ex) {
			Error.
				setErrorMessage(new StringBuffer("Error loading file ").
					append(filePath).append(" ").append(ex).toString());
			return null;
		}
	}

	public static Map<String, Double> importScalesMeasures(String filePath) {
		Map<String, Double> map = new HashMap();
		String file = Legacy.readFile(filePath);
		if (file == null) {
			return null;
		}
		for (String line : file.split("\\n")) {
			line = line.trim();
			if (!line.isEmpty()) {
				String data[] = line.split(";");
				if (data.length == 3) {
					map.put(data[0] + data[1], Util.toDouble(data[2]));
				}
			}
		}
		return map;
	}

	public static List<FileFilter> getFiltersExtensionsExportAnalyze() {
		List<Object> objects = Settings.loadAllClass(Settings.
			getOptions("AnalyzeExportClass"));
		List<FileFilter> filters = new ArrayList();
		for (Object object : objects) {
			Export analyzeExport = (Export) object;
			if (analyzeExport != null) {
				filters.add(analyzeExport.getExtensionFilter());
			}
		}
		return filters;
	}

	public static List<FileFilter> getFiltersExtensionsImportRoadNetwork() {
		List<Object> objects = Settings.loadAllClass(Settings.
			getOptions("RoadNetworkImportClass"));
		List<FileFilter> filters = new ArrayList();
		for (Object object : objects) {
			Import roadNetworkImport = (Import) object;
			if (roadNetworkImport != null) {
				filters.add(roadNetworkImport.getExtensionFilter());
			}
		}
		return filters;
	}

	public static String[] getExtensionsImportRoadNetwork() {
		List<FileFilter> filters = Legacy.
			getFiltersExtensionsImportRoadNetwork();
		StringBuilder string = new StringBuilder();
		for (FileFilter filter : filters) {
			for (String extension : ((FileNameExtensionFilter) filter).
				getExtensions()) {
				string.append(";").append(extension);
			}
		}
		return string.toString().substring(1).split(";");
	}

	public static List<RoadNetwork> importRoadNetwork(String filePath) {
		filePath = filePath.trim();
		String extension = Legacy.getExtension(filePath);
		if (extension == null || extension.isEmpty()) {
			Error.
				setErrorMessage("Could not get the file extension: " + filePath);
			return null;
		}
		String data = Legacy.readFile(filePath);
		List<Object> objects = Settings.loadAllClass(Settings.
			getOptions("RoadNetworkImportClass"));
		for (Object object : objects) {
			Import imports = (Import) object;
			if (imports != null && imports.getExtension().
				equals(extension)) {
				return imports.importData(data);

			}
		}
		Error.setErrorMessage("Could not load this extension: ");
		return null;
	}

	public static List<FileFilter> getFiltersExtensionsImportVehicle() {
		List<Object> objects = Settings.loadAllClass(Settings.
			getOptions("VehicleImportClass"));
		List<FileFilter> filters = new ArrayList();
		for (Object object : objects) {
			Import imports = (Import) object;
			if (imports != null) {
				filters.add(imports.getExtensionFilter());
			}
		}
		return filters;
	}

	public static List<Vehicle> importVehicles(String filePath) {
		filePath = filePath.trim();
		String extension = Legacy.getExtension(filePath);
		if (extension == null || extension.isEmpty()) {
			Error.
				setErrorMessage("Could not get the file extension: " + filePath);
			return null;
		}
		String data = Legacy.readFile(filePath);
		List<Object> objects = Settings.loadAllClass(Settings.
			getOptions("VehicleImportClass"));
		for (Object object : objects) {
			Import vehicleImport = (Import) object;
			if (vehicleImport != null && vehicleImport.getExtension().
				equals(extension)) {
				return vehicleImport.importData(data);
			}
		}
		Error.setErrorMessage("Could not load this extension: ");
		return null;
	}

	public static Boolean export(String filePath, String data) {
		filePath = filePath.trim();
		String extension = Legacy.getExtension(filePath);
		if (extension == null || extension.isEmpty()) {
			Error.
				setErrorMessage("Could not get the file extension: " + filePath);
			return null;
		}
		List<Object> objects = Settings.loadAllClass(Settings.
			getOptions("AnalyzeExportClass"));
		for (Object object : objects) {
			Export export = (Export) object;
			if (export != null && export.getExtension().
				equals(extension)) {
				String result = export.export(data);
				Legacy.writeFile(filePath, result, false);
				return true;
			}
		}
		Error.setErrorMessage("Could not load this extension: ");
		return null;
	}

}
