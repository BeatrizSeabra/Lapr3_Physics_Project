/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Controller.ContextController;
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
import java.util.Deque;
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
	private Map<Traffic, Segment> segments;

	public Simulator(Simulation simulation, String name, Measure time,
					 Measure timeStep) {
		this.simulation = simulation;
		this.run = new Run(name, time, timeStep);
	}

	public void run() {

		Measure time = Measurement.convert(this.run.getTime(), "s");
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				active = false;
			}
		};
		new Timer(new Integer((time.getValue() * 60) + ""), action).start();
		while (this.active) {
			System.out.println("ALGO");
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
			Deque<Section> sections = this.run.getMethod().path(traffic.
				getVehicle(), roadNetwork, traffic.getNodeStart(), traffic.
																getNodeEnd());
		}
	}

	private void stepVehicles() {

	}

	private void stepNewVehicles() {
		for (Traffic traffic : this.simulation.getTraffics()) {

		}
	}

}
