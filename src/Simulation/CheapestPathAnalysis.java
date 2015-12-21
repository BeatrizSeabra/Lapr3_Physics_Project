/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Node;
import Model.RoadNetwork;
import Model.Section;
import Physics.Measure;
import Physics.Measurement;
import java.util.ArrayDeque;
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

		List<Deque<Object>> paths = new ArrayList();
		for (int iList = 0; iList < nodesPaths.size(); iList++) {
			Deque<Object> deque = new ArrayDeque();
			List<Object> nodes = (List) nodesPaths.get(iList);
			List<Object> sections = (List) sectionPaths.get(iList);
			for (int iDeque = 0; iDeque < nodes.size(); iDeque++) {
				deque.add(nodes.get(iDeque));
				if (iDeque < sections.size()) {
					deque.add(sections.get(iDeque));
				}
			}
			paths.add(deque);
		}

		for (Deque<Object> path : paths) {
			Measure total = new Measure(0.0, "€");
			List<String[]> result = new ArrayList();
			result.add(";Name;Cost;Total".split(";"));
			for (Object object : path) {
				if (object instanceof Node) {
					Node node = (Node) object;
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("Node;");
					stringBuilder.append(node.getName());
					stringBuilder.append(";;");
					stringBuilder.append(total);
					result.add(stringBuilder.toString().split(";"));
				} else if (object instanceof Section) {
					Section section = (Section) object;
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("Section;");
					stringBuilder.append(section.getRoad());
					stringBuilder.append(";");
					Measure toll = section.getToll();
					stringBuilder.append(toll);
					stringBuilder.append(";");
					stringBuilder.append(total);
					result.add(stringBuilder.toString().split(";"));
					total = Measurement.sum(total, toll);
				}
			}
			results.put(total.getValue(), result);
		}
		if (results.isEmpty()) {
			return new ArrayList();
		}
		return results.get(Collections.min(results.keySet()));
	}

}
