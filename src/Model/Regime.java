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
public class Regime implements Comparable<Regime> {

	private Measure torque;
	private Measure rpmLow;
	private Measure rpmHigh;
	private Measure fuelConsumption;

	public Regime() {
	}

	public Regime(Measure torque, Measure rpmLow, Measure rpmHigh,
				  Measure fuelConsumption) {
		this.torque = torque;
		this.rpmLow = rpmLow;
		this.rpmHigh = rpmHigh;
		this.fuelConsumption = fuelConsumption;
	}

	/**
	 * @return the torque
	 */
	public Measure getTorque() {
		return torque;
	}

	/**
	 * @param torque the torque to set
	 */
	public void setTorque(Measure torque) {
		this.torque = torque;
	}

	/**
	 * @return the rpmLow
	 */
	public Measure getRpmLow() {
		return rpmLow;
	}

	/**
	 * @param rpmLow the rpmLow to set
	 */
	public void setRpmLow(Measure rpmLow) {
		this.rpmLow = rpmLow;
	}

	/**
	 * @return the rpmHigh
	 */
	public Measure getRpmHigh() {
		return rpmHigh;
	}

	/**
	 * @param rpmHigh the rpmHigh to set
	 */
	public void setRpmHigh(Measure rpmHigh) {
		this.rpmHigh = rpmHigh;
	}

	/**
	 * @return the fuelConsumption
	 */
	public Measure getFuelConsumption() {
		return fuelConsumption;
	}

	/**
	 * @param espFuelConsumption the fuelConsumption to set
	 */
	public void setFuelConsumption(Measure espFuelConsumption) {
		this.fuelConsumption = espFuelConsumption;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Regime other = (Regime) obj;
		if (other == null) {
			return false;
		}
		return this.hashCode() == other.hashCode();
	}

	@Override
	public int hashCode() {
		int hash = 29 * this.getClass().hashCode();
		hash += 11 * this.getTorque().hashCode();
		hash += 11 * this.getRpmLow().hashCode();
		hash += 11 * this.getRpmHigh().hashCode();
		hash += 11 * this.getFuelConsumption().hashCode();
		return hash;
	}

	@Override
	public Regime clone() {
		return new Regime(this.torque, this.rpmLow, this.rpmHigh, this.fuelConsumption);
	}

	@Override
	public int compareTo(Regime regime) {
		return this.rpmHigh.compareTo(regime.rpmHigh);
	}

}
