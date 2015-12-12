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
	private List<RoadNetwork> roadNetworks = new ArrayList();
	private List<Vehicle> vehicles = new ArrayList();

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
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean addRoadNetwork(RoadNetwork roadNetwork) {
		return this.roadNetworks.add(roadNetwork);
	}

	public List<RoadNetwork> getRoadNetworks() {
		return new ArrayList(this.roadNetworks);
	}

	public Boolean addVehicle(Vehicle vehicle) {
		return this.vehicles.add(vehicle);
	}

	public List<Vehicle> getVehicles() {
		return new ArrayList(this.vehicles);
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
		hash += 11 * this.name.hashCode();
		hash += 11 * this.description.hashCode();
		for (RoadNetwork roadNetwork : this.roadNetworks) {
			hash += 7 * roadNetwork.hashCode();
		}
		for (Vehicle vehicle : this.vehicles) {
			hash += 7 * vehicle.hashCode();
		}
		return hash;
	}

	@Override
	public String toString() {
		return new StringBuilder(this.id.toString()).append(" - ").
			append(this.name).toString();
	}

	@Override
	public Project clone() {
		Project project = new Project();
		project.setId(this.id);
		project.setName(this.name);
		project.setDescription(this.description);
		for (RoadNetwork roadNetwork : this.roadNetworks) {
			project.addRoadNetwork(roadNetwork);
		}
		for (Vehicle vehicle : this.vehicles) {
			project.addVehicle(vehicle);
		}
		return project;
	}

}
