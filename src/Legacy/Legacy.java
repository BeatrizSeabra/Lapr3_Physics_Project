/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Project;
import Model.Simulation;
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

	/**
	 *
	 * @param filePath
	 * @return
	 */
	public static String getExtension(String filePath) {
		if (!filePath.isEmpty()) {
			return filePath.substring(filePath.lastIndexOf(".")).
				replace(".", "");
		}
		return "";
	}

	/**
	 *
	 * @param filePath
	 * @param text
	 * @param additional
	 */
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

	/**
	 *
	 * @param filePath
	 * @return
	 */
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

	/**
	 *
	 * @param filePath
	 * @return
	 */
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

	/**
	 *
	 * @return
	 */
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

	/**
	 *
	 * @return
	 */
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

	/**
	 *
	 * @param filePath
	 * @return
	 */
	public static List<Project> importRoadNetwork(String filePath) {
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

	/**
	 *
	 * @return
	 */
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

	/**
	 *
	 * @return
	 */
	public static List<FileFilter> getFiltersExtensionsImportSimulations() {
		List<Object> objects = Settings.loadAllClass(Settings.
			getOptions("SimulationImportClass"));
		List<FileFilter> filters = new ArrayList();
		for (Object object : objects) {
			Import imports = (Import) object;
			if (imports != null) {
				filters.add(imports.getExtensionFilter());
			}
		}
		return filters;
	}

	/**
	 *
	 * @param importClassName
	 * @return
	 */
	public static List<FileFilter> getFiltersExtensionsImportObjects(
		String importClassName) {
		List<FileFilter> filters = new ArrayList();
		if (!importClassName.isEmpty()) {
			List<Object> objects = Settings.loadAllClass(Settings.
				getOptions(importClassName));

			for (Object object : objects) {
				Import imports = (Import) object;
				if (imports != null) {
					filters.add(imports.getExtensionFilter());
				}
			}
		}
		return filters;
	}

	/**
	 *
	 * @param filePath
	 * @return
	 */
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

	/**
	 *
	 * @param filePath
	 * @return
	 */
	public static List<Simulation> importSimulation(String filePath) {
		filePath = filePath.trim();
		String extension = Legacy.getExtension(filePath);
		if (extension == null || extension.isEmpty()) {
			Error.
				setErrorMessage("Could not get the file extension: " + filePath);
			return null;
		}
		String data = Legacy.readFile(filePath);
		List<Object> objects = Settings.loadAllClass(Settings.
			getOptions("SimulationImportClass"));
		for (Object object : objects) {
			Import importClass = (Import) object;
			if (importClass != null && importClass.getExtension().
				equals(extension)) {
				return importClass.importData(data);
			}
		}
		Error.setErrorMessage("Could not load this extension: ");
		return null;
	}

	/**
	 *
	 * @param filePath
	 * @param importClassName
	 * @return
	 */
	public static List<Object> importObjects(String filePath,
											 String importClassName) {
		filePath = filePath.trim();
		String extension = Legacy.getExtension(filePath);
		if (extension == null || extension.isEmpty()) {
			Error.
				setErrorMessage("Could not get the file extension: " + filePath);
			return null;
		}
		String data = Legacy.readFile(filePath);
		List<Object> objects = Settings.loadAllClass(Settings.
			getOptions("SimulationImportClass"));
		for (Object object : objects) {
			Import importClass = (Import) object;
			if (importClass != null && importClass.getExtension().
				equals(extension)) {
				return importClass.importData(data);
			}
		}
		Error.setErrorMessage("Could not load this extension: " + extension);
		return null;
	}

	/**
	 *
	 * @param filePath
	 * @param data
	 * @return
	 */
	public static Boolean export(String filePath, List<String[]> data) {
		filePath = filePath.trim();
		String extension = Legacy.getExtension(filePath);
		if (extension == null || extension.isEmpty()) {
			Error.
				setErrorMessage("Could not get the file extension: " + filePath);
			return null;
		}
		List<Object> objects = Settings.loadAllClass(Settings.
			getOptions("ExportClass"));
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

	/**
	 *
	 * @return
	 */
	public static List<FileFilter> getFiltersExtensionsExport() {
		List<Object> objects = Settings.loadAllClass(Settings.
			getOptions("ExportClass"));
		List<FileFilter> filters = new ArrayList();
		for (Object object : objects) {
			Export analyzeExport = (Export) object;
			if (analyzeExport != null) {
				filters.add(analyzeExport.getExtensionFilter());
			}
		}
		return filters;
	}

}
