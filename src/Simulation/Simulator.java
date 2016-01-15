/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Controller.ContextController;
import Model.Drop;
import Model.RoadNetwork;
import Model.Run;
import Model.Section;
import Model.Segment;
import Model.Simulation;
import Model.Traffic;
import Physics.Measure;
import Physics.Measurement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Timer;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Simulator {

	private Simulation simulation;
	private Run run;
	private Boolean active = true;
	private Map<Traffic, Segment> segments = new HashMap();
	private List<VehicleBot> vehicleBots = new ArrayList();
	private Integer time = 0;
	private Integer timeStep;

	public Simulator(Simulation simulation, String name, Measure time,
					 Measure timeStep) {
		this.simulation = simulation;
		this.run = new Run();
		this.run.setName(name);
		this.run.setTime(time);
		this.run.setTimeStep(timeStep);
		this.timeStep = Measurement.convert(timeStep, "s").getValue().intValue();
	}

	public void run() {
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				active = false;
			}
		};
		this.createBots();
		Measure time = Measurement.convert(this.run.getTime(), "s");
		new Timer(new Integer((time.getValue() * 1000) + ""), action).start();
		while (this.active) {
			System.out.println("ALGO");
			this.stepVehicles();
			this.stepNewVehicles();
			this.time += this.timeStep;
		}
	}

	private void createBots() {
		RoadNetwork roadNetwork = ContextController.getOpenProject().
			getRoadNetwork();
		for (Section section : roadNetwork.getSections()) {
			for (Segment segment : section.getSegments()) {
				segment.setVehicles(0);
			}
		}
		for (Traffic traffic : this.simulation.getTraffics()) {
			traffic.getNodeStart().getBots().clear();
		}
		for (Traffic traffic : this.simulation.getTraffics()) {
			Deque<Section> sections = this.run.getMethod().path(traffic.
				getVehicle(), roadNetwork, traffic.getNodeStart(), traffic.
																getNodeEnd());
			/*
			 Deque<Segment> segments = new ArrayDeque();
			 for (Section section : sections) {
			 for (Segment segment : section.getSegments()) {
			 segments.add(segment);
			 }
			 }*/
			VehicleBot vehicleBot = new VehicleBot(sections, this.run.getSteps(), this.timeStep);
			traffic.getNodeStart().getBots().
				put(sections.peekFirst(), vehicleBot);
		}
	}

	private void stepVehicles() {
		for (VehicleBot vehicleBot : this.vehicleBots) {
			vehicleBot.step();
		}
	}

	private void stepNewVehicles() {
		for (Traffic traffic : this.simulation.getTraffics()) {
			Integer amount = Physics.PhysicsMath.
				exponentialDistributionRandom(traffic.getArrivalRate().
					getValue()).intValue();
			Segment segment = this.segments.get(traffic);
			for (int i = 0; i < amount; i++) {
				VehicleBot vehicleBot = traffic.getNodeStart().getBots().
					get(segment);
				if (segment.getVehicles() < segment.getNumberVehicles()) {
					this.vehicleBots.add(vehicleBot);
				} else {
					this.run.
						addDrop(new Drop(traffic.getVehicle().getName(), traffic.
										 getNodeStart().getName(), traffic.
										 getNodeEnd().getName(), this.time.
										 toString()));
				}
			}
		}
	}

}
