/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Legacy.Legacy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class ResultsController {

	private List<String[]> results;
	private String[] legend;

	/**
	 * @return the results
	 */
	public List<String[]> getResults() {
		return this.results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(List<String[]> results, String[] legend) {
		this.legend = legend;
		this.results = results;
	}
	/*
	 public void setResults(List<Object> results) {
	 List<Step> steps = (List<Step>) (Object) results;
	 if (steps != null) {
	 this.steps = steps;
	 } else {
	 List<Drop> drops = (List<Drop>) (Object) results;
	 if (drops != null) {
	 this.drops = drops;
	 } else {
	 this.results = (List<String[]>) (Object) results;
	 }
	 }
	 }
	 */

	/**
	 * @return the results
	 */
	public String[] getResultsLegend() {
		if (!this.hasResults()) {
			return new String[0];
		}
		return this.legend;
	}

	/**
	 *
	 * @return
	 */
	public String[][] getResultsValues() {
		if (!this.hasResults()) {
			return new String[0][0];
		}
		String[][] values = new String[this.results.size()][this.results.get(0).length + 1];
		for (int i = 1; i < this.results.size(); i++) {
			String[] line = this.results.get(i);
			for (int j = 0; j < line.length; j++) {
				values[i][j] = this.results.get(i)[j];
			}
		}
		return values;
	}

	/**
	 *
	 * @return
	 */
	public Boolean hasResults() {
		if (this.results == null || this.results.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 *
	 * @param filePath
	 * @return
	 */
	public Boolean export(String filePath) {
		List<String[]> array = new ArrayList();
		array.add(this.legend);
		array.addAll(this.results);
		return Legacy.export(filePath, array);
	}

}
