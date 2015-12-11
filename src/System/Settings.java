/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import Legacy.Legacy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class Settings {

	private static String configurationFilePath = "Settings.txt";

	public static List<String> getConfiguration(String key) {
		List<String> configuracoes = new ArrayList();
		String configuracao = Legacy.readFile(Settings.configurationFilePath);
		String[] linhas = Legacy.readFile(Settings.configurationFilePath).
			split("\n");
		for (int i = 0; i < linhas.length; i++) {
			String[] linha = linhas[i].split("=");
			if (linha.length == 2 && linha[0].trim().equalsIgnoreCase(key)) {
				configuracoes.add(linha[1].trim());
			}
		}
		return configuracoes;
	}

	public static Object loadClass(String name) {
		try {
			return (Object) Class.forName(name).newInstance();
		} catch (Exception ex) {
			Error.setErrorMessage(new StringBuilder("Class no load: ").
				append(ex).toString());
			return null;
		}
	}

	public static List<Object> loadAllClass(List<String> names) {
		List<Object> objects = new ArrayList();
		StringBuilder error = new StringBuilder();
		for (String name : names) {
			Object instanceClass = Settings.loadClass(name);
			if (instanceClass != null) {
				objects.add(instanceClass);
			} else {
				error.append(Error.getErrorMessage()).append("\n");
			}
		}
		Error.setErrorMessage(error.toString());
		return objects;
	}

}
