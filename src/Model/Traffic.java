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

	private Node nodeStart;
	private Node nodeEnd;
	private Vehicle vehicle;
	private Measure arrivalRate;

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	public Node getNodeStart() {
		return nodeStart;
	}

	public Node getNodeEnd() {
		return nodeEnd;
	}

	public void setNodeStart(Node nodeStart) {
		this.nodeStart = nodeStart;
	}

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
		hash += 11 * this.nodeStart.hashCode();
		hash += 11 * this.nodeEnd.hashCode();
		hash += 11 * this.vehicle.hashCode();
		hash += 11 * this.arrivalRate.hashCode();
		return hash;
	}

	@Override
	public String toString() {
		return new StringBuilder("Traffic - " + this.nodeStart + " - " + this.nodeEnd + " - " + this.arrivalRate + " - " + this.vehicle.
			getName()).
			toString();
	}

}
