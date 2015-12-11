/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class Error {

	static private String errorMessage;

	static public void setErrorMessage(String errorMessage) {
		Error.errorMessage = errorMessage;
	}

	static public String getErrorMessage() {
		return Error.errorMessage;
	}

}
