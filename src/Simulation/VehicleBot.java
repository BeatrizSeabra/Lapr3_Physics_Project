/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Node;
import Model.Run;
import Model.Section;
import Model.Segment;
import Model.Step;
import Model.Vehicle;
import Physics.Measure;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VehicleBot {

	private Vehicle vehicle;
	private AnalysisMethod analysisMethod;
	private List<Section> sections = new ArrayList();
	private List<Segment> segments;
	private Integer timeStep;
	private Run run;
	private Step step;
	private Node nodeStart;
	private Node nodeEnd;

	private double timeTotal = 0;
	private double timeNext = 0;
	private double timeEnter = 0;

	private int section = 0;
	private int segment = 0;

	private Step stepStop;

	public VehicleBot(Vehicle vehicle, Deque<Section> sections, Run run,
					  Integer timeStep, Node nodeStart, Node nodeEnd) {
		this.run = run;
		this.vehicle = vehicle;
		this.timeStep = timeStep;
		this.nodeStart = nodeStart;
		this.nodeEnd = nodeEnd;
		this.analysisMethod = run.getMethod();
		List<Segment> segments = new ArrayList();
		for (Section section : sections) {
			this.sections.add(section);
		}
		this.segments = this.sections.get(0).getSegments();
	}

	public VehicleBot() {

	}

	public void step() {
		if (this.section < this.sections.size()) {
			this.timeTotal += this.timeStep;
			if (this.segment < this.segments.size()) {
				Segment segment = this.segments.get(this.segment);
				if (segment.getNumberVehiclesCurrent() < segment.
					getNumberVehicles()) {
					this.quit();
					this.segment++;
					this.timeEnter = this.timeTotal;
				} else {
					// Em Espera!
				}
			} else {
				this.section++;
				this.segment = 0;
			}
		}
		/*
		 if (this.section < this.sections.size()) {
		 this.timeTotal += this.timeStep;
		 if (this.timeNext > 0) {
		 if (this.step == null) {
		 this.step = this.analysisMethod.
		 analyze(this.vehicle, this.sections.get(0), this.segments.
		 get(0));
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
		 this.run.addStep(step);
		 System.out.println(step);
		 }
		 this.pass();
		 this.step = new Step();
		 if (!this.sections.isEmpty() && !this.segments.isEmpty()) {
		 this.step = this.analysisMethod.
		 analyze(this.vehicle, this.sections.get(0), this.segments.
		 get(0)
		 );
		 this.step.setTimeEntry(new Measure(this.timeTotal, "s"));
		 this.step.setVehicle(this.vehicle.getName());
		 this.step.setNodeStart(this.nodeStart.getName());
		 this.step.setNodeEnd(this.nodeEnd.getName());
		 this.step.setRoad(this.sections.get(0).getRoad());
		 this.step.setSegment(this.segments.get(0).getName());
		 }
		 }
		 }*/
	}

	public void quit() {
		Step step = this.analysisMethod.analyze(this.vehicle, this.sections.
												get(0), this.segments.get(0));
		step.setTimeEntry(new Measure(this.timeEnter, "s"));
		step.setTimeOut(new Measure(this.timeTotal, "s"));
		step.setVehicle(this.vehicle.getName());
		step.setNodeStart(this.nodeStart.getName());
		step.setNodeEnd(this.nodeEnd.getName());
		step.setRoad(this.sections.get(0).getRoad());
		step.setSegment(this.segments.get(0).getName());
		/*
		 step.getCarPower().setValue(this.step.getCarPower().
		 getValue() + this.stepStop.getCarPower().getValue());
		 step.getCarSpeed().setValue(this.step.getCarSpeed().
		 getValue() + this.stepStop.getCarSpeed().getValue());
		 step.getSpeedRelative()
		 .setValue(this.step.getSpeedRelative().
		 getValue() + this.stepStop.getSpeedRelative().getValue());
		 step.getCarForce().setValue(this.step.getCarForce().
		 getValue() + this.stepStop.getCarForce().getValue());
		 step.getRollingForce().setValue(this.step.getRollingForce().
		 getValue() + this.stepStop.getRollingForce().getValue());
		 step.getAirForce().setValue(this.step.getAirForce().
		 getValue() + this.stepStop.getAirForce().getValue());
		 step.getGravityForce().setValue(this.step.getGravityForce().
		 getValue() + this.stepStop.getGravityForce().getValue());
		 */
		this.run.addStep(step);
	}
	/*
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
	 */
}
