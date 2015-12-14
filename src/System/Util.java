/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class Util {

	private static SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat formatDateComplete = new SimpleDateFormat("yyyy/M/dd HH:mm:ss.SSS");

	public static String toString(Date date) {
		return Util.formatDate.format(date);
	}

	public static Date toDate(String date) {
		try {
			return Util.formatDate.parse(date);
		} catch (Exception ex) {
			return null;
		}
	}

	public static Double toDouble(String string) {
		try {
			return Double.parseDouble(string.replaceAll(",", ".").trim());
		} catch (Exception ex) {
			Error.
				setErrorMessage("The string can not be converted to Double: " + ex);
			return null;
		}
	}

}
