/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Node;
import Model.RoadNetwork;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public interface PathAnalysis extends Analysis {

	/**
	 *
	 * @param roadNetwork
	 * @param startNode
	 * @param endNode
	 * @return
	 */
	List<String[]> analyze(RoadNetwork roadNetwork, Node startNode, Node endNode);

}
