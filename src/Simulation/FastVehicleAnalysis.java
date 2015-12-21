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
			Measure total = new Measure(0.0, "s");
			List<String[]> result = new ArrayList();
			result.
				add(";Name;Segment maxVelocity;Restricted maxVelocity;Vehicle Gear;Gear maxVelocity;Used maxVelocity;Lenght;Time;Total".
					split(";"));
			for (Object object : path) {
				if (object instanceof Node) {
					Node node = (Node) object;
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("Node;");
					stringBuilder.append(node.getName()).append(";;;;;;;;");
					stringBuilder.append(total);
					result.add(stringBuilder.toString().split(";"));
				} else if (object instanceof Section) {
					Section section = (Section) object;
					for (Segment segment : section.getSegments()) {
						StringBuilder stringBuilder = new StringBuilder();
						List<Measure> velocities = new ArrayList();
						stringBuilder.append("Segment;");
						stringBuilder.append(segment.getName()).append(";");
						Measure segmentVelocity = Measurement.convert(segment.
							getMaxVelocity(), "km/h");
						velocities.add(segmentVelocity);
						stringBuilder.append(segmentVelocity).append(";");
						Measure typologyVelocity = Measurement.convert(vehicle.
							getVelocityLimits().get(section.getTypology()), "km/h");
						if (typologyVelocity != null) {
							velocities.add(typologyVelocity);
							stringBuilder.append(typologyVelocity);
						}
						stringBuilder.append(";");
						stringBuilder.append(Collections.max(vehicle.getGears().
							keySet())).append(";");
						Measure vehicleVelocity = Measurement.convert(vehicle.
							getMaxVelocity(), "km/h");
						velocities.add(vehicleVelocity);
						stringBuilder.append(vehicleVelocity).append(";");
						Measure usedVelocity = Collections.min(velocities);
						stringBuilder.append(usedVelocity).append(";");
						Measure lenght = Measurement.
							convert(segment.getLength(), "km");
						stringBuilder.append(lenght).append(";");
						Measure time = new Measure(lenght.getValue() / usedVelocity.
							getValue() * 3600, "s");
						stringBuilder.append(time).append(";");
						stringBuilder.append(total);
						total = Measurement.sum(total, time);
						result.add(stringBuilder.toString().split(";"));
					}
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
