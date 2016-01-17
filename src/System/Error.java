/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import Legacy.Legacy;
import java.time.LocalDateTime;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class Error {

	static private String errorMessage;
	static private String keyLogFilePath = "LogFilePath";

	/**
	 *
	 * @return
	 */
	static public String getLogFilePath() {
		return Settings.getOption(Error.keyLogFilePath);
	}

	/**
	 *
	 * @param errorMessage
	 */
	static public void setErrorMessage(String errorMessage) {
		Error.log(errorMessage);
		Error.errorMessage = errorMessage;
	}

	/**
	 *
	 * @return
	 */
	static public String getErrorMessage() {
		return Error.errorMessage;
	}

	/**
	 *
	 * @param occurrence
	 */
	static public void log(String occurrence) {
		String text = new StringBuilder(LocalDateTime.now().toString().
			replace('T', ' ')).append(": ").append(occurrence.
				replaceAll("\n", " - ")).append("\n\n").toString();
		Legacy.writeFile(Error.getLogFilePath(), text, true);
	}

	/**
	 *
	 * @return
	 */
	static public String log() {
		return Legacy.readFile(Error.getLogFilePath());
	}

	/**
	 *
	 */
	static public void clearLog() {
		Legacy.writeFile(Error.getLogFilePath(), " ", false);
	}

}
