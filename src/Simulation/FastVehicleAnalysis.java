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
import Model.Vehicle;
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
public class FastVehicleAnalysis implements VehicleAnalysis {

	public String getName() {
		return "Fast Vehicle Analysis";
	}

	public List<String[]> analyze(Vehicle vehicle, RoadNetwork roadNetwork,
								  Node startNode, Node endNode) {
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
			Double total = 0.0;
			List<String[]> result = new ArrayList();
			result.
				add(";MaxVelocity;MaxVehicleVelocity;VelocityUsed;Lenght;Total".
					split(";"));
			for (Object object : path) {
				if (object instanceof Node) {
					Node node = (Node) object;
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("Node;");
					stringBuilder.append(node.getName());
					stringBuilder.append(";0;0;0;");
					stringBuilder.append(total);
					result.add(stringBuilder.toString().split(";"));
				} else if (object instanceof Section) {
					Section section = (Section) object;
					for (Segment segment : section.getSegments()) {
						StringBuilder stringBuilder = new StringBuilder();
						List<Double> maxVelocity = new ArrayList();
						maxVelocity.add(segment.getMaxVelocity().getValue());
						Double velocityTypology = vehicle.getVelocityLimits().
							get(section.getTypology());
						if (velocityTypology != null) {
							maxVelocity.add(velocityTypology);
						}
						stringBuilder.append("Segment;");
						stringBuilder.append(segment.getName());
						stringBuilder.append(";");
						stringBuilder.
							append(segment.getMaxVelocity().getValue());
						stringBuilder.append(";");
						stringBuilder.append(Collections.min(maxVelocity));
						stringBuilder.append(";");
						stringBuilder.append(segment.getLength().getValue());
						stringBuilder.append(";");
						stringBuilder.append(total);
						total += segment.getLength().getValue();
						result.add(stringBuilder.toString().split(";"));
					}
				}
			}
			results.put(total, result);
		}
		return results.get(Collections.min(results.keySet()));
	}

}
