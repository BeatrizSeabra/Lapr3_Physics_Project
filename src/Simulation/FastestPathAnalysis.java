/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Node;
import Model.Regime;
import Model.RoadNetwork;
import Model.Section;
import Model.Segment;
import Model.Step;
import Model.Throttle;
import Model.Vehicle;
import Physics.Measure;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class FastestPathAnalysis extends AnalysisMethod {

	@Override
	public Step analyze(Vehicle vehicle, Section section, Segment segment) {
		// preencher
		Throttle maxThrottle = Collections.max(vehicle.getThrottles());
		Regime minRegime = Collections.max(maxThrottle.getRegimes());
		Measure maxGear = vehicle.getGear(Collections.max(vehicle.getGears().
			keySet()));
		Measure carSpeed = Physics.PhysicsMath.
			carSpeed(vehicle.getWheelSize(), minRegime.
					 getRpmHigh(), vehicle.getFinalDriveRatio(), maxGear);
		Measure relativeSpeed = Physics.PhysicsMath.
			relativeSpeed(carSpeed, section.getWindSpeed(), section.
						  getWindDirection());
		Measure maxSegment = Physics.Measurement.convert(segment.
			getMaxVelocity(), "m/s");
		if (relativeSpeed.getValue() < maxSegment.getValue()) {
			relativeSpeed.setValue(maxSegment.getValue());
		}
		Measure airForce = Physics.PhysicsMath.airResistanceForce(vehicle.
			getDragCoefficient(), vehicle.getFrontalArea(), relativeSpeed);
		Measure gravityForce = Physics.PhysicsMath.gravityForce(vehicle.
			getMass(), segment.getSlope());
		Measure rollingResistanceForce = Physics.PhysicsMath.
			rollingResistanceForce(gravityForce, maxGear, airForce);
		Double sum = rollingResistanceForce.getValue() + airForce.getValue() + gravityForce.
			getValue();
		Measure carForce = new Measure(sum, "N");
		Measure carms = Physics.Measurement.convert(segment.getLength(), "m");
		Measure speed = Physics.Measurement.convert(relativeSpeed, "m/s");
		Measure out = new Measure(carms.getValue() * relativeSpeed.getValue(), "s");
		Measure carPower = Physics.PhysicsMath.engineCarPower(minRegime.
			getTorque(), minRegime.getRpmHigh(), maxGear);
		Step step = new Step();
		step.setVehicle(vehicle.getName());
		step.setSegment(segment.getName());
		step.setRoad(section.getRoad());
		step.setRollingForce(gravityForce);
		step.setAirForce(airForce);
		step.setCarForce(carForce);
		step.setCarPower(carPower);
		step.setGravityForce(gravityForce);
		step.setCarSpeed(carSpeed);
		step.setTimeEntry(new Measure(0.0, "s"));
		step.setTimeOut(out);
		step.setSpeedRelative(relativeSpeed);
		return step;
	}

	@Override
	public List<Step> analyze(Vehicle vehicle, Node startNode, Node endNode,
							  List<Section> sections) {
		List<Step> steps = new ArrayList<>();
		for (Section section : sections) {
			for (Segment segment : section.getSegments()) {
				Step step = this.analyze(vehicle, section, segment);
				step.setNodeStart(startNode.getName());
				step.setNodeEnd(endNode.getName());
				steps.add(step);

			}
		}
		return steps;
	}

	@Override
	public List<Section> analyze(Vehicle vehicle, Node startNode, Node endNode,
								 RoadNetwork roadNetwork) {
		List<Deque<Section>> paths = new ArrayList<>();
		List<List<Step>> stepsList = new ArrayList<>();
		List<Deque<Section>> sections = new ArrayList<>();
		roadNetwork.getAllPaths(startNode, endNode, sections);
		for (Deque<Section> path : sections) {
			paths.add(path);
			stepsList.add(this.
				analyze(vehicle, startNode, endNode, (List<Section>) path));
		}
		double maxtime = 0;
		for (List<Step> steps : stepsList) {

		}
		return (List<Section>) paths.get(0);
	}

	@Override
	public String getName() {
		return "Fastest Path";
	}
}
