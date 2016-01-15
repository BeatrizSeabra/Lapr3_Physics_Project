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
public class Simulation {

	private Integer id = 0;
	private String name = "";
	private String description = "";
	private List<Traffic> traffics = new ArrayList();
	private List<Run> runs = new ArrayList();

	/**
	 *
	 * @param traffic
	 * @return
	 */
	public Boolean addTraffic(Traffic traffic) {
		return this.traffics.add(traffic);
	}

	/**
	 *
	 * @param run
	 * @return
	 */
	public Boolean addRun(Run run) {
		return this.runs.add(run);
	}

	/**
	 *
	 * @param index
	 * @return
	 */
	public Traffic getTraffic(int index) {
		return this.traffics.get(index);
	}

	/**
	 *
	 * @param index
	 * @return
	 */
	public Run getRun(int index) {
		return this.runs.get(index);
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
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
		return this.name;
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
		return this.description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the traffics
	 */
	public List<Traffic> getTraffics() {
		return this.traffics;
	}

	/**
	 * @return the runs
	 */
	public List<Run> getRuns() {
		return this.runs;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Simulation other = (Simulation) obj;
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
		for (Traffic traffic : this.traffics) {
			hash += 11 * traffic.hashCode();
		}
		for (Run run : this.runs) {
			hash += 11 * run.hashCode();
		}
		return hash;
	}

	@Override
	public Simulation clone() {
		Simulation simulation = new Simulation();
		simulation.setId(this.id);
		simulation.setName(this.name);
		simulation.setDescription(this.description);
		for (Traffic traffic : this.traffics) {
			simulation.addTraffic(traffic.clone());
		}
		return simulation;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("Simulation - ").
			append(this.name).append(" - ").append(this.description).
			append("\n");
		for (Traffic traffic : this.traffics) {
			stringBuilder.append(traffic).append("\n");
		}
		return stringBuilder.toString();
	}

}
