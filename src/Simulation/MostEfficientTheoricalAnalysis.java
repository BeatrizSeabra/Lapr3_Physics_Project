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
import Model.Step;
import Model.Vehicle;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class MostEfficientTheoricalAnalysis extends AnalysisMethod {

	double totalForce = 0;

	@Override
	public Step analyze(Vehicle vehicle, Segment segment) {
		// preencher
		return new Step();
	}

	@Override
	public List<Step> analyze(Vehicle vehicle, Node startNode, Node endNode,
							  List<Section> sections) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<Section> analyze(Vehicle vehicle, Node startNode, Node endNode,
								 RoadNetwork roadNetwork) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public String getName() {
		return "Fastest Path";
	}

}
