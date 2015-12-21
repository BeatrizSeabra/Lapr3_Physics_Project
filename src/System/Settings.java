/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import Legacy.Legacy;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class Settings {

	private static String settingsFilePath = "settings.properties";

	public static String getSettingsFilePath() {
		return Settings.settingsFilePath;
	}

	public static void setSettingsFilePath(String filePath) {
		Settings.settingsFilePath = filePath;
	}

	public static String getOption(String key) {
		try {
			Properties properties = new Properties();
			properties.load(new StringReader(Legacy.
				readFile(Settings.settingsFilePath)));
			return properties.getProperty(key);
		} catch (Exception ex) {
			Error.
				setErrorMessage(new StringBuilder("Could not get the settings property: ").
					append(ex).toString());
			return null;
		}
	}

	public static String[] getOptions(String key) {
		String option = Settings.getOption(key);
		if (option == null) {
			return null;
		}
		return option.split(";");
	}

	public static <T> T loadClass(String name) {
		try {
			return (T) Class.forName(name).newInstance();
		} catch (Exception ex) {
			Error.setErrorMessage(new StringBuilder("Class no load: ").
				append(ex).toString());
			return null;
		}
	}

	public static <T> List<T> loadAllClass(String[] names) {
		List<T> objects = new ArrayList();
		for (String name : names) {
			T instanceClass = Settings.loadClass(name);
			if (instanceClass != null) {
				objects.add(instanceClass);
			}
		}
		return objects;
	}

}
