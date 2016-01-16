/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Node;
import Model.Section;
import Model.Segment;
import Model.Step;
import Model.Vehicle;
import Physics.Measure;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VehicleBot {

	private Vehicle vehicle;
	private AnalysisMethod analysisMethod;
	private Deque<Section> sections;
	private Deque<Segment> segments;
	private Integer timeStep;
	private List<Step> steps;
	private Step step;
	private Node nodeStart;
	private Node nodeEnd;

	private double timeTotal = 0;
	private double timeNext = 0;

	private double timeEnter = 0;

	private Step stepStop;

	public VehicleBot(Vehicle vehicle, Deque<Section> sections, List<Step> steps,
					  Integer timeStep, AnalysisMethod analysisMethod) {
		this.vehicle = vehicle;
		this.sections = sections;
		this.steps = steps;
		this.timeStep = timeStep;
		this.analysisMethod = analysisMethod;
		Deque<Segment> segments = new ArrayDeque();
		for (Segment segment : this.sections.getFirst().getSegments()) {
			segments.push(segment);
		}
		this.segments = segments;
	}
        
        public VehicleBot(){

        }

	public void step() {
		if (!this.sections.isEmpty()) {
			this.timeTotal += this.timeStep;
			if (this.timeNext > 0) {
				if (this.step == null) {
					this.step = this.analysisMethod.
						analyze(this.vehicle, this.segments.getFirst());
				}
				this.step.getCarPower().setValue(this.step.getCarPower().
					getValue() + this.stepStop.getCarPower().getValue());
				this.step.getCarSpeed().setValue(this.step.getCarSpeed().
					getValue() + this.stepStop.getCarSpeed().getValue());
				this.step.getSpeedRelative().setValue(this.step.
					getSpeedRelative().
					getValue() + this.stepStop.getSpeedRelative().getValue());
				this.step.getCarForce().setValue(this.step.getCarForce().
					getValue() + this.stepStop.getCarForce().getValue());
				this.step.getRollingForce().
					setValue(this.step.getRollingForce().
						getValue() + this.stepStop.getRollingForce().getValue());
				this.step.getAirForce().setValue(this.step.getAirForce().
					getValue() + this.stepStop.getAirForce().getValue());
				this.step.getGravityForce().
					setValue(this.step.getGravityForce().
						getValue() + this.stepStop.getGravityForce().getValue());
			} else {
				this.stepStop = null;
				if (step != null) {
					this.step.setTimeOut(new Measure(this.timeTotal, "s"));
					this.steps.add(step);
					System.out.println(step);
				}
				this.pass();
				this.step = new Step();
				this.step = this.analysisMethod.
					analyze(this.vehicle, this.segments.getFirst());
				this.step.setTimeEntry(new Measure(this.timeTotal, "s"));
				this.step.setVehicle(this.vehicle.getName());
				//this.step.setNodeStart(this.nodeStart.getName());
				//this.step.setNodeEnd(this.nodeEnd.getName());
				this.step.setRoad(this.sections.getFirst().getRoad());
				this.step.setSegment(this.segments.getFirst().getName());
			}
		}
	}

	public void pass() {
		if (this.segments.isEmpty()) {
			this.sections.pop();
			Deque<Segment> segments = new ArrayDeque();
			for (Segment segment : this.sections.getFirst().getSegments()) {
				segments.push(segment);
			}
			this.segments = segments;
		} else {
			this.segments.pop();
		}
	}

}
