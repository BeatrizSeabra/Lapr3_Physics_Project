/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Node;
import Model.RoadNetwork;
import Model.Section;
import Model.Segment;
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
public class LevelPathAnalysis implements PathAnalysis {

	public String getName() {
		return "Level Path Analysis";
	}

	public List<String[]> analyze(RoadNetwork roadNetwork, Node startNode,
								  Node endNode) {
		Map<Double, List<String[]>> results = new HashMap();
		List<Deque<Section>> sectionPaths = new ArrayList();
		List<Deque<Node>> nodesPaths = roadNetwork.
			getAllPaths(startNode, endNode, sectionPaths);
		for (Deque<Section> sectionPath : sectionPaths) {
			Double total = 0.0;
			List<String[]> result = new ArrayList();
			result.add("Segment;Slope of Segment;Total Slope;".split(";"));
			for (Section section : sectionPath) {
				for (Segment segment : section.getSegments()) {
					total += (segment.getSlope());
					StringBuilder stringBuilder = new StringBuilder();

					stringBuilder.append(segment.toString());

					stringBuilder.append(segment.getSlope());

					stringBuilder.append(total);
					result.add(stringBuilder.toString().split(";"));

				}
			}
			results.put(total, result);
		}
		return results.get(Collections.min(results.keySet()));
	}

}
