/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Simulation.VehicleBot;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Node {

	private Integer id = 0;
	private String name = "none";
	private Map<Segment, VehicleBot> bots = new HashMap();

	/**
	 *
	 * @param name
	 */
	public Node(String name) {
		this.name = name;
	}

	/**
	 *
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 *
	 * @param id
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
	 * @return the bots
	 */
	public Map<Segment, VehicleBot> getBots() {
		return bots;
	}

	/**
	 * @param bots the bots to set
	 */
	public void setBots(
		Map<Segment, VehicleBot> bots) {
		this.bots = bots;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Node other = (Node) obj;
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
		return hash;
	}

	@Override
	public Node clone() {
		Node node = new Node(name);
		node.setId(this.id);
		return node;
	}

	@Override
	public String toString() {
		return "Node | name: " + this.name;
	}

}
