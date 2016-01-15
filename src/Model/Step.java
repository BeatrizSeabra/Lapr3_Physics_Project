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
public class Step {

	private String vehicle;
	private String nodeStart;
	private String nodeEnd;
	private String road;
	private String segment;
	private Measure timeEntry;
	private Measure timeOut;
	private Measure carPower;
	private Measure carSpeed;
	private Measure speedRelative;
	private Measure carForce;
	private Measure rollingForce;
	private Measure airForce;
	private Measure gravityForce;

	/**
	 * @return the vehicle
	 */
	public String getVehicle() {
		return this.vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the nodeStart
	 */
	public String getNodeStart() {
		return this.nodeStart;
	}

	/**
	 * @param nodeStart the nodeStart to set
	 */
	public void setNodeStart(String nodeStart) {
		this.nodeStart = nodeStart;
	}

	/**
	 * @return the nodeEnd
	 */
	public String getNodeEnd() {
		return this.nodeEnd;
	}

	/**
	 * @param nodeEnd the nodeEnd to set
	 */
	public void setNodeEnd(String nodeEnd) {
		this.nodeEnd = nodeEnd;
	}

	/**
	 * @return the road
	 */
	public String getRoad() {
		return this.road;
	}

	/**
	 * @param road the road to set
	 */
	public void setRoad(String road) {
		this.road = road;
	}

	/**
	 * @return the segment
	 */
	public String getSegment() {
		return this.segment;
	}

	/**
	 * @param segment the segment to set
	 */
	public void setSegment(String segment) {
		this.segment = segment;
	}

	/**
	 * @return the timeEntry
	 */
	public Measure getTimeEntry() {
		return this.timeEntry;
	}

	/**
	 * @param timeEntry the timeEntry to set
	 */
	public void setTimeEntry(Measure timeEntry) {
		this.timeEntry = timeEntry;
	}

	/**
	 * @return the timeOut
	 */
	public Measure getTimeOut() {
		return this.timeOut;
	}

	/**
	 * @param timeOut the timeOut to set
	 */
	public void setTimeOut(Measure timeOut) {
		this.timeOut = timeOut;
	}

	/**
	 * @return the carPower
	 */
	public Measure getCarPower() {
		return this.carPower;
	}

	/**
	 * @param carPower the carPower to set
	 */
	public void setCarPower(Measure carPower) {
		this.carPower = carPower;
	}

	/**
	 * @return the carSpeed
	 */
	public Measure getCarSpeed() {
		return this.carSpeed;
	}

	/**
	 * @param carSpeed the carSpeed to set
	 */
	public void setCarSpeed(Measure carSpeed) {
		this.carSpeed = carSpeed;
	}

	/**
	 * @return the speedRelative
	 */
	public Measure getSpeedRelative() {
		return this.speedRelative;
	}

	/**
	 * @param speedRelative the speedRelative to set
	 */
	public void setSpeedRelative(Measure speedRelative) {
		this.speedRelative = speedRelative;
	}

	/**
	 * @return the carForce
	 */
	public Measure getCarForce() {
		return this.carForce;
	}

	/**
	 * @param carForce the carForce to set
	 */
	public void setCarForce(Measure carForce) {
		this.carForce = carForce;
	}

	/**
	 * @return the rollingForce
	 */
	public Measure getRollingForce() {
		return this.rollingForce;
	}

	/**
	 * @param rollingForce the rollingForce to set
	 */
	public void setRollingForce(Measure rollingForce) {
		this.rollingForce = rollingForce;
	}

	/**
	 * @return the airForce
	 */
	public Measure getAirForce() {
		return this.airForce;
	}

	/**
	 * @param airForce the airForce to set
	 */
	public void setAirForce(Measure airForce) {
		this.airForce = airForce;
	}

	/**
	 * @return the gravityForce
	 */
	public Measure getGravityForce() {
		return this.gravityForce;
	}

	/**
	 * @param gravityForce the gravityForce to set
	 */
	public void setGravityForce(Measure gravityForce) {
		this.gravityForce = gravityForce;
	}

	@Override
	public String toString() {
		return "Step | vehicle: " + this.vehicle + " | node start: " + this.nodeStart + " | node end: " + this.nodeEnd + " | road: " + this.road + " | segment: " + this.segment + " | time entry: " + this.timeEntry + " | time out: " + this.timeOut + " | car power: " + this.carPower + " | car speed: " + this.carSpeed + " | speed relative: " + this.speedRelative + " | car force: " + this.carForce + " | rolling force: " + this.rollingForce + " | air force: " + this.airForce + " | gravity force: " + this.gravityForce;
	}

	@Override
	public int hashCode() {
		int hash = 29 * this.getClass().hashCode();
		hash += 11 * this.vehicle.hashCode();
		hash += 11 * this.nodeStart.hashCode();
		hash += 11 * this.nodeEnd.hashCode();
		hash += 11 * this.road.hashCode();
		hash += 11 * this.segment.hashCode();
		hash += 11 * this.timeEntry.hashCode();
		hash += 11 * this.timeOut.hashCode();
		hash += 11 * this.carPower.hashCode();
		hash += 11 * this.carSpeed.hashCode();
		hash += 11 * this.speedRelative.hashCode();
		hash += 11 * this.carForce.hashCode();
		hash += 11 * this.rollingForce.hashCode();
		hash += 11 * this.airForce.hashCode();
		hash += 11 * this.gravityForce.hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Step other = (Step) obj;
		if (other == null) {
			return false;
		}
		return this.hashCode() == other.hashCode();
	}
}
