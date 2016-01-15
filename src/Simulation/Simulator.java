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
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Simulator {

	private Simulation simulation;
	private Run run;
	private Boolean active = false;
	private Boolean pause = false;
	//private Map<Traffic, Segment> segments = new HashMap();
	private List<VehicleBot> vehicleBots = new ArrayList();
	private Integer time = 0;
	private Integer timeStep;
	private Timer timer;

	public void setData(Simulation simulation, String name, Measure time,
						Measure timeStep, AnalysisMethod analysisMethod) {
		this.simulation = simulation;
		this.run = new Run();
		this.run.setName(name);
		this.run.setTime(time);
		this.run.setTimeStep(timeStep);
		this.run.setMethod(analysisMethod);
		this.timeStep = Measurement.convert(timeStep, "s").getValue().intValue();
	}

	public void run() {
		this.createBots();
		this.active = true;
		timer = new Timer();
		timer.schedule(new TimerSchedule(), this.run.getTime().getValue().
					   intValue() * 1000);
		while (this.getActive()) {
			while (this.getPause()) {
			}
			System.out.println(this.vehicleBots.size());
			this.stepVehicles();
			this.stepNewVehicles();
			this.time += this.timeStep;
		}

		System.out.println("DROP!!!! " + this.run.getDrops().size());
	}

	private class TimerSchedule extends TimerTask {

		@Override
		public void run() {
			active = false;
			timer.cancel();
		}
	}

	private void createBots() {
		RoadNetwork roadNetwork = ContextController.getOpenProject().
			getRoadNetwork();
		for (Section section : roadNetwork.getSections()) {
			for (Segment segment : section.getSegments()) {
				segment.setNumberVehiclesCurrent(0);
			}
		}
		for (Traffic traffic : this.simulation.getTraffics()) {
			Deque<Section> sections = this.run.getMethod().path(traffic.
				getVehicle(), roadNetwork, traffic.getNodeStart(), traffic.
																getNodeEnd());
			VehicleBot vehicleBot = new VehicleBot(traffic.getVehicle(), sections, this.run.
												   getSteps(), this.timeStep, this.run.
												   getMethod());
			traffic.setSegment(sections.peekFirst().getSegments().get(0));
			traffic.setVehicleBot(vehicleBot);
		}
	}

	private void stepVehicles() {
		for (VehicleBot vehicleBot : this.vehicleBots) {
			vehicleBot.step();
		}
	}

	private void stepNewVehicles() {
		for (Traffic traffic : this.simulation.getTraffics()) {
			int amount = Physics.PhysicsMath.
				exponentialDistributionRandom(traffic.getArrivalRate().
					getValue()).intValue();
			amount = 1;
			Segment segment = traffic.getSegment();
			VehicleBot vehicleBot = traffic.getVehicleBot();
			for (int i = 0; i < amount; i++) {
				int numberVehicles = segment.getNumberVehiclesCurrent();
				if (numberVehicles < segment.getNumberVehicles()) {
					this.vehicleBots.add(vehicleBot);
					segment.setNumberVehiclesCurrent(numberVehicles + 1);
				} else {
					Drop drop = new Drop();
					drop.setVehicle(traffic.getVehicle().getName());
					drop.setNodeStart(traffic.getNodeStart().getName());
					drop.setNodeEnd(traffic.getNodeEnd().getName());
					drop.setTime(new Measure(Double.parseDouble(this.time.
						toString()), "s"));
					this.run.addDrop(drop);

				}
			}
		}
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the pause
	 */
	public Boolean getPause() {
		return pause;
	}

	/**
	 * @param pause the pause to set
	 */
	public void setPause(Boolean pause) {
		this.pause = pause;
	}

}
