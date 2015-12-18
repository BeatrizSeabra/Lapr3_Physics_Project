/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Legacy.Legacy;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class ResultsController {

	private List<String[]> results;

	/**
	 * @return the results
	 */
	public List<String[]> getResults() {
		return this.results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(List<String[]> results) {
		this.results = results;
	}

	/**
	 * @return the results
	 */
	public String getResultsString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (String[] line : this.results) {
			for (String column : line) {
				stringBuilder.append(column).append(" ");
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	public Boolean export(String filePath) {
		return Legacy.export(filePath, this.results);
	}

}
