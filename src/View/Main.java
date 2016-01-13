/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Node;
import Model.Project;
import Model.Regime;
import Model.Section;
import Model.Segment;
import Model.Simulation;
import Model.Throttle;
import Model.Traffic;
import Model.Vehicle;
import Physics.Measure;
import System.Error;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		Project project = new Project();
		project.setName("meu projeto!!!");
		project.setDescription("meu projeto descrição!!!");
		List<Project> projects = new ArrayList();
		projects.add(project);
		Section section = new Section();
		section.setDirection("Section Diretion");
		section.setRoad("Section road");
		section.setToll(new Measure(1.0, "€"));
		section.setTypology("Section typology");
		section.setWindDirection(new Measure(2.0, "°"));
		section.setWindSpeed(new Measure(3.0, "km"));
		Node nodeStart = new Node("N1");
		Node nodeEnd = new Node("N2");
		project.getRoadNetwork().addSection(nodeStart, nodeEnd, section);
		Segment segment = new Segment();
		segment.setName("Segment name");
		segment.setHeight(new Measure(1.0, "km"));
		segment.setLength(new Measure(3.0, "km"));
		segment.setMaxVelocity(new Measure(4.0, "km"));
		segment.setMinVelocity(new Measure(5.0, "km"));
		segment.setSlope(new Measure(6.0, "°"));
		segment.setNumberVehicles(8);
		section.addSegment(segment);
		Data.Data.getProjectData().save(projects);

		Throttle throttle1 = new Throttle();
		throttle1.setPercentage(new Measure(25.0, "%"));
		throttle1.
			addRegime(new Regime(new Measure(85.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(8.2, "g/KWh")));
		throttle1.
			addRegime(new Regime(new Measure(95.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(6.2, "g/KWh")));
		throttle1.
			addRegime(new Regime(new Measure(80.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(10.2, "g/KWh")));
		Throttle throttle2 = new Throttle();
		throttle2.setPercentage(new Measure(50.0, "%"));
		throttle2.
			addRegime(new Regime(new Measure(135.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(5.2, "g/KWh")));
		throttle2.
			addRegime(new Regime(new Measure(150.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(3.2, "g/KWh")));
		throttle2.
			addRegime(new Regime(new Measure(140.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(8.2, "g/KWh")));
		Throttle throttle3 = new Throttle();
		throttle3.setPercentage(new Measure(100.0, "%"));
		throttle3.
			addRegime(new Regime(new Measure(200.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(2.2, "g/KWh")));
		throttle3.
			addRegime(new Regime(new Measure(240.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(1.2, "g/KWh")));
		throttle3.
			addRegime(new Regime(new Measure(190.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(4.2, "g/KWh")));
		Vehicle vehicle = new Vehicle();
		vehicle.setId(1);
		vehicle.setName("Nissan Skyline 2001");
		vehicle.setDescription("2001 Nissan Skyline GT-R R34 V-spec II N1");
		vehicle.setType("car");
		vehicle.setMotorization("combustion");
		vehicle.setFuel("gasoline");
		vehicle.setMass(new Measure(1550.0, "kg"));
		vehicle.setLoad(new Measure(0.0, "kg"));
		vehicle.setDragCoefficient(new Measure(0.34, "ratio"));
		vehicle.setFrontalArea(new Measure(1.8, "m2"));
		vehicle.setRollingRCoefficient(new Measure(0.01, "ratio"));
		vehicle.setWheelSize(new Measure(0.3266, "m"));
		vehicle.setMinRPM(new Measure(8500.0, "rpm"));
		vehicle.setMaxRPM(new Measure(1000.0, "rpm"));
		vehicle.setFinalDriveRatio(new Measure(3.545, "ratio"));
		vehicle.setEnergyRegeneration(new Measure(3.827, "ratio"));
		vehicle.setGear(1, new Measure(3.827, "ratio"));
		vehicle.setGear(2, new Measure(2.36, "ratio"));
		vehicle.setGear(3, new Measure(1.685, "ratio"));
		vehicle.setGear(4, new Measure(1.312, "ratio"));
		vehicle.setGear(5, new Measure(1.0, "ratio"));
		vehicle.setGear(6, new Measure(0.793, "ratio"));
		vehicle.addThrottle(throttle1);
		vehicle.addThrottle(throttle2);
		vehicle.addThrottle(throttle3);
		vehicle.setVelocityLimits("rua", new Measure(40.0, "km/h"));
		project.addVehicle(vehicle);
		List<Vehicle> vehicles = new ArrayList();
		vehicles.add(vehicle);
		Data.Data.getVehicleData().save(project, vehicles);

		Simulation simulation = new Simulation();
		simulation.setDescription("test");
		simulation.setName("test2");
		Traffic traffic = new Traffic();
		traffic.setNodeStart(nodeStart);
		traffic.setNodeEnd(nodeEnd);
		traffic.setVehicle(vehicle);
		traffic.setArrivalRate(new Measure(1.0, "ratio"));
		simulation.addTraffic(traffic);
		project.addSimulation(simulation);
		List<Simulation> simulations = new ArrayList();
		simulations.add(simulation);
		Data.Data.getSimulationData().save(project, simulations);
		vehicle.setId(0);
		Data.Data.getVehicleData().save(project, vehicles);

		/*
		 Simulation simu1 = new Simulation();
		 simu1.setName("simula1");
		 simu1.setDescription("simula1 descrip");
		 Simulation simu2 = new Simulation();
		 simu2.setName("simula2");
		 simu2.setDescription("simula2 descrip");
		 List<Simulation> simus = new ArrayList();
		 simus.add(simu1);
		 simus.add(simu2);
		 System.out.println("SIMUS ERROS: " + Data.Data.getSimulationData().
		 save(project, simus));
		 */
		try {
			Error.clearLog();
			new ApplicationGUI();
		} catch (Exception ex) {
			Error.setErrorMessage("ERROR: " + ex);
		}

	}

}
