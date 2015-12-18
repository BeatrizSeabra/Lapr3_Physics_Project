/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Node;
import Model.RoadNetwork;
import Model.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class EconomicVehicleAnalysis implements VehicleAnalysis {

	public String getName() {
		return "Economic Vehicle Analysis";
	}

	public List<String[]> analyze(Vehicle vehicle, RoadNetwork roadNetwork,
								  Node startNode, Node endNode) {
		List<String[]> results = new ArrayList();
		results.add("Economic;Vehicle;Analysis".split(";"));
		results.add("1;2;3".split(";"));
		results.add("4;5;6".split(";"));
		return results;
	}

}
