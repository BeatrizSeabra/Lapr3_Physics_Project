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

	public Boolean addTraffic(Traffic traffic) {
		return this.traffics.add(traffic);
	}

	public Traffic getTraffic(int index) {
		return this.traffics.get(index);
	}

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

	/**
	 * @return the traffics
	 */
	public List<Traffic> getTraffics() {
		return traffics;
	}

	/**
	 * @param traffics the traffics to set
	 */
	public void setTraffics(List<Traffic> traffics) {
		this.traffics = traffics;
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
		hash += 11 * this.getName().hashCode();
		hash += 11 * this.getDescription().hashCode();
		for (Traffic traffic : this.traffics) {
			hash += 7 * traffic.hashCode();
		}
		return hash;
	}

	@Override
	public Simulation clone() {
		return new Simulation();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("Simulation - " + this.name + " - " + this.description + "\n");
		for (Traffic traffic : this.traffics) {
			stringBuilder.append(traffic + "\n");
		}
		return stringBuilder.toString();
	}

}
