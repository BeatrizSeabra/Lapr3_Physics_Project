/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Node;
import Model.RoadNetwork;
import Model.Vehicle;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public interface VehicleAnalysis extends Analysis {

	List<String[]> analyze(Vehicle vehicle, RoadNetwork roadNetwork,
						   Node startNode, Node endNode);
}
