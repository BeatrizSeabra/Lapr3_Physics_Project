/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Project {

	private Integer id;
	private String name;
	private String description;
	private RoadNetwork roadNetwork = new RoadNetwork();
	private List<Vehicle> vehicles = new ArrayList();
	private List<Simulation> simulations = new ArrayList();

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.roadNetwork.getName();
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.roadNetwork.setName(name);
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.roadNetwork.getDescription();
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.roadNetwork.setDescription(description);
	}

	/**
	 * @return the roadNetwork
	 */
	public RoadNetwork getRoadNetwork() {
		return this.roadNetwork;
	}

	/**
	 * @param roadNetwork the roadNetwork to set
	 */
	public void setRoadNetwork(RoadNetwork roadNetwork) {
		this.roadNetwork = roadNetwork;
	}

	public Boolean addVehicle(Vehicle vehicle) {
		return this.vehicles.add(vehicle);
	}

	public List<Vehicle> getVehicles() {
		return new ArrayList(this.vehicles);
	}

	public Boolean addSimulation(Simulation simulation) {
		return this.simulations.add(simulation);
	}

	public List<Simulation> getSimulations() {
		return new ArrayList(this.simulations);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Project other = (Project) obj;
		if (other == null) {
			return false;
		}
		return this.hashCode() == other.hashCode();
	}

	@Override
	public int hashCode() {
		int hash = 29 * this.getClass().hashCode();
		hash += 11 * this.id.hashCode();
		hash += 11 * this.getName().hashCode();
		hash += 11 * this.getDescription().hashCode();
		hash += 11 * this.roadNetwork.hashCode();
		for (Vehicle vehicle : this.vehicles) {
			hash += 7 * vehicle.hashCode();
		}
		for (Simulation simulation : this.simulations) {
			hash += 7 * simulation.hashCode();
		}
		return hash;
	}

	@Override
	public String toString() {
		return new StringBuilder(this.id.toString()).append(" - ").
			append(this.getName()).toString();
	}

	@Override
	public Project clone() {
		Project project = new Project();
		project.setId(this.id);
		project.setName(this.name);
		project.setDescription(this.description);
		project.setRoadNetwork(this.roadNetwork.clone());
		for (Vehicle vehicle : this.vehicles) {
			project.addVehicle(vehicle);
		}
		return project;
	}

}
