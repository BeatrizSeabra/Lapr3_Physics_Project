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
	private List<VehicleBot> vehicleBots = new ArrayList();
	private Integer time = 0;
	private Integer timeStep;
	private Timer timer;
	private List<String[]> result;

	public void setData(Simulation simulation, Run run) {
		this.run = run;
		this.simulation = simulation;
		this.timeStep = run.getTimeStep().getValue().intValue();
	}

	public void run() {
		this.result = result;
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
				getVehicle(), traffic.getNodeStart(), traffic.getNodeEnd(), roadNetwork);
			VehicleBot vehicleBot = new VehicleBot(traffic.getVehicle(), sections, this.run, this.timeStep, traffic.
												   getNodeStart(), traffic.
												   getNodeEnd());
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
			if (traffic.getTimeNews() > 0) {
				traffic.setTimeNews(traffic.getTimeNews() - this.timeStep);
			} else {
				traffic.setTimeNews(Physics.PhysicsMath.
					exponentialDistributionRandom(traffic.getArrivalRate().
						getValue() * 60).intValue());
				Segment segment = traffic.getSegment();
				VehicleBot vehicleBot = traffic.getVehicleBot();
				for (int i = 0; i < traffic.getArrivalRate().getValue(); i++) {
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
