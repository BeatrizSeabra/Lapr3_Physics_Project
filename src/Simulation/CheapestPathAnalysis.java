/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Node;
import Model.RoadNetwork;
import Model.Section;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class CheapestPathAnalysis implements PathAnalysis {

	public String getName() {
		return "Cheapest Path Analysis";
	}

	public List<String[]> analyze(RoadNetwork roadNetwork, Node startNode,
								  Node endNode) {
		Map<Double, List<String[]>> results = new HashMap();
		List<Deque<Section>> sectionPaths = new ArrayList();
		List<Deque<Node>> nodesPaths = roadNetwork.
			getAllPaths(startNode, endNode, sectionPaths);
		Double total = 0.0;
		for (Deque<Section> sectionPath : sectionPaths) {
			List<String[]> result = new ArrayList();
			for (Section section : sectionPath) {
				StringBuilder stringBuilder = new StringBuilder();
				total = total + section.getToll();
				stringBuilder.append("Section:;").append(section.getRoad()).
					append("Section Toll Cost:;").append(section.getToll()).
					append("Section Total Toll Cost:").append(total);
				result.add(stringBuilder.toString().split(";"));
			}
			results.put(total, result);
		}
		return results.get(Collections.min(results.keySet()));

	}

}
