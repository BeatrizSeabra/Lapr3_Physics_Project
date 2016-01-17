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
import Physics.Measurement;
import Physics.PhysicsMath;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class MostEfficientTheoricalAnalysis extends AnalysisMethod {

	@Override
	public Step analyze(Vehicle vehicle, Section section, Segment segment) {
		Throttle maxThrottle = Collections.max(vehicle.getThrottles());
		Regime regime = Collections.min(maxThrottle.getRegimes());
		Measure maxGear = vehicle.getGear(Collections.max(vehicle.getGears().
			keySet()));
		Measure wheelSize = vehicle.getWheelSize();
		Measure rpm = regime.getRpmHigh();
		Measure finalDrive = vehicle.getFinalDriveRatio();
		Measure windSpeed = section.getWindSpeed();
		Measure windDir = section.getWindDirection();
		Measure segLimit = Measurement.convert(segment.getMaxVelocity(), "m/s");
		Measure carLimit = Measurement.convert(vehicle.
			getVelocityLimits(section.getTypology()), "m/s");
		Measure carSpeed = PhysicsMath.
			carSpeed(wheelSize, rpm, finalDrive, maxGear);
		Measure relativeSpeed = PhysicsMath.
			relativeSpeed(carSpeed, windSpeed, windDir);
		Measure dreg = vehicle.getDragCoefficient();
		Measure area = vehicle.getFrontalArea();
		Measure slope = segment.getSlope();
		Measure mass = vehicle.getMassTotal();
		Measure rolling = vehicle.getRollingRCoefficient();
		Measure torque = regime.getTorque();
		if (relativeSpeed.getValue() > segLimit.getValue()) {
			relativeSpeed.setValue(segLimit.getValue());
		}
		if (carLimit != null && relativeSpeed.getValue() > carLimit.getValue()) {
			relativeSpeed.setValue(carLimit.getValue());
		}
		Measure airForce = PhysicsMath.
			airResistanceForce(dreg, area, relativeSpeed);
		Measure gravityForce = PhysicsMath.gravityForce(mass, slope);
		Measure rollingForce = PhysicsMath.
			rollingResistanceForce(rolling, mass, slope);
		Measure carForce = new Measure(rollingForce.getValue() + airForce.
			getValue() + gravityForce.getValue(), "N");
		Measure length = Measurement.convert(segment.getLength(), "m");
		Measure out = new Measure(relativeSpeed.getValue() * length.getValue(), "s");
		Measure carPower = PhysicsMath.engineCarPower(torque, rpm, maxGear);
		Step step = new Step();
		step.setAirForce(airForce);
		step.setCarForce(carForce);
		step.setCarPower(carPower);
		step.setCarSpeed(carSpeed);
		step.setGravityForce(gravityForce);
		step.setRoad(section.getRoad());
		step.setRollingForce(rollingForce);
		step.setSegment(segment.getName());
		step.setSpeedRelative(relativeSpeed);
		step.setTimeEntry(new Measure(0.0, "s"));
		step.setTimeOut(out);
		step.setVehicle(vehicle.getName());
		return step;
	}

	@Override
	public List<Step> analyze(Vehicle vehicle, Node startNode, Node endNode,
							  List<Section> sections) {
		List<Step> steps = new ArrayList();
		for (Section section : sections) {
			for (Segment segment : section.getSegments()) {
				Step step = analyze(vehicle, section, segment);
				if (!steps.isEmpty()) {
					Step old = steps.get(steps.size() - 1);
					step.setNodeStart(startNode.getName());
					step.setNodeEnd(endNode.getName());
					step.getAirForce().setValue(step.getAirForce().
						getValue() + old.getAirForce().getValue());
					step.getCarForce().setValue(step.getCarForce().
						getValue() + old.getCarForce().getValue());
					step.getCarPower().setValue(step.getCarPower().
						getValue() + old.getCarPower().getValue());
					step.getCarSpeed().setValue(step.getCarSpeed().
						getValue() + old.getCarSpeed().getValue());
					step.getGravityForce().setValue(step.getGravityForce().
						getValue() + old.getGravityForce().getValue());
					step.getRollingForce().setValue(step.getRollingForce().
						getValue() + old.getRollingForce().getValue());
					step.getSpeedRelative().setValue(step.getSpeedRelative().
						getValue() + old.getSpeedRelative().getValue());
					step.getTimeEntry().setValue(old.getTimeOut().getValue());
					step.getTimeOut().
						setValue(step.getTimeOut().getValue() + old.
							getTimeOut().getValue());
				}
				steps.add(step);
			}
		}
		return steps;
	}

	@Override
	public List<Section> analyze(Vehicle vehicle, Node startNode, Node endNode,
								 RoadNetwork roadNetwork) {
		List<Deque<Section>> paths = new ArrayList();
		List<List<Step>> stepsList = new ArrayList();
		List<Deque<Section>> sections = new ArrayList();
		roadNetwork.getAllPaths(startNode, endNode, sections);
		for (Deque<Section> path : sections) {
			paths.add(path);
			stepsList.add(this.
				analyze(vehicle, startNode, endNode, (List<Section>) path));
		}
		int index = 0;
		double minPower = stepsList.get(0).get(stepsList.get(0).size() - 1).
			getCarPower().getValue();
		for (int i = 0; i < stepsList.size(); i++) {
			double value = stepsList.get(i).get(stepsList.get(i).size() - 1).
				getCarPower().getValue();
			if (minPower > value) {
				index = i;
				minPower = value;
			}
		}
		return (List<Section>) paths.get(index);
	}

	@Override
	public String getName() {
		return "Theoretical Most Energy Efficient Path";
	}

}
