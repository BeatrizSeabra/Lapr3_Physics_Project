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

	private Vehicle vehicle;
	private Measure arrivalRate;

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
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

}
