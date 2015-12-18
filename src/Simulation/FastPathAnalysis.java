/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Node;
import Model.RoadNetwork;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class FastPathAnalysis implements PathAnalysis {

	public String getName() {
		return "Fast Path Analysis";
	}

	public List<String[]> analyze(RoadNetwork roadNetwork, Node startNode,
								  Node endNode) {
		List<String[]> results = new ArrayList();
		results.add("Fast;Path;Analysis".split(";"));
		results.add("1;2;3".split(";"));
		results.add("4;5;6".split(";"));
		return results;
	}

}
