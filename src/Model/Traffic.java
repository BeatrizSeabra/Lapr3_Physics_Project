/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Traffic {

	private Integer id = 0;
	private Node nodeStart;
	private Node nodeEnd;
	private Vehicle vehicle;
	private Measure arrivalRate;

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
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 *
	 * @return
	 */
	public Node getNodeStart() {
		return nodeStart;
	}

	/**
	 *
	 * @return
	 */
	public Node getNodeEnd() {
		return nodeEnd;
	}

	/**
	 *
	 * @param nodeStart
	 */
	public void setNodeStart(Node nodeStart) {
		this.nodeStart = nodeStart;
	}

	/**
	 *
	 * @param nodeEnd
	 */
	public void setNodeEnd(Node nodeEnd) {
		this.nodeEnd = nodeEnd;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the arrivalRate
	 */
	public Measure getArrivalRate() {
		return arrivalRate;
	}

	/**
	 * @param arrivalRate the arrivalRate to set
	 */
	public void setArrivalRate(Measure arrivalRate) {
		this.arrivalRate = arrivalRate;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Traffic other = (Traffic) obj;
		if (other == null) {
			return false;
		}
		return this.hashCode() == other.hashCode();
	}

	@Override
	public int hashCode() {
		int hash = 29 * this.getClass().hashCode();
		hash += 11 * this.id.hashCode();
		hash += 11 * this.nodeStart.hashCode();
		hash += 11 * this.nodeEnd.hashCode();
		hash += 11 * this.vehicle.hashCode();
		hash += 11 * this.arrivalRate.hashCode();
		return hash;
	}

	@Override
	public Traffic clone() {
		Traffic traffic = new Traffic();
		traffic.setId(this.id);
		traffic.setNodeStart(this.nodeStart.clone());
		traffic.setNodeEnd(this.nodeEnd.clone());
		traffic.setVehicle(this.vehicle.clone());
		traffic.setArrivalRate(this.arrivalRate.clone());
		return traffic;
	}

	@Override
	public String toString() {
		return new StringBuilder("Traffic - ").append(this.nodeStart).
			append(" - ").append(this.nodeEnd).append(" - ").
			append(this.arrivalRate).append(" - ").
			append(this.vehicle.getName()).toString();
	}

}
